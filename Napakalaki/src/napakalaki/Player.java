/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 * @author Andresmag
 */
public class Player {
    final static int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    protected Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    protected ArrayList<Treasure> visibleTreasures = new ArrayList();
   
    //Métodos
    public Player(String newName){ 
        name = newName;
        level = 1;
        enemy = null;
        pendingBadConsequence = null;
    }
    
    public Player(Player p){
        name = p.getName();
        level = p.getLevels();
        dead = p.isDead();
        canISteal = p.canISteal();
        enemy = p.enemy;
        pendingBadConsequence = p.pendingBadConsequence;
        visibleTreasures = p.getVisibleTreasures();
        hiddenTreasures = p.getHiddenTreasures();
    }
    
    public String getName(){
        return name;
    }
    
    
    private void bringToLife(){
        dead = false;   
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected int getCombatLevel(){
        int combatLevel = level;
        for(Treasure visibleTreasures : visibleTreasures){
            combatLevel += visibleTreasures.getBonus();
        }
        return combatLevel;
    }
    
    private void incrementLevels(int i){
        level += i;
    }
    
    private void decrementLevels(int i){
        level -= i;
        
        if(level < 1)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        incrementLevels(m.getLevelsGained());
        int nTreasures = m.getTreasuresGained();
        if (nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            Treasure treasure = null;
            for(int i=0; i< nTreasures; i++){
                treasure = dealer.nextTreasure();
                if(treasure != null)
                    hiddenTreasures.add(treasure);    
            }      
        }  
    }
    
    private void applyBadConsequence(Monster m){
         BadConsequence badConsequence = m.getBadConsequence();
         int nLevels = badConsequence.getLevels();
         decrementLevels(nLevels);
         BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
         setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean puedeEquipar = true;
        TreasureKind tipoObjeto = t.getType();
      
        switch (tipoObjeto){
            case BOTHHANDS :
                int h=0, btam = visibleTreasures.size();
                Treasure btes;
                while(h< btam && puedeEquipar){
                    btes = visibleTreasures.get(h);
                    puedeEquipar = !( btes.getType() == tipoObjeto || btes.getType() == TreasureKind.ONEHAND );
                    h++;
                }
            break;
            case ONEHAND :
              puedeEquipar = ((howManyVisibleTreasures(tipoObjeto) < 2) && 
                      (howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0));
            break;
            default:
                int j=0, dtam = visibleTreasures.size();
                Treasure dtes;
                while(j< dtam && puedeEquipar){
                    dtes = visibleTreasures.get(j);
                    puedeEquipar = !(dtes.getType() == tipoObjeto);
                    j++;
                }
            break;
        }
        return puedeEquipar;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador = 0;
        for (Treasure visibleTreasure : visibleTreasures) {
            if (visibleTreasure.getType() == tKind) {
                contador++;
            }
        }
        
        return contador;    
    }
    
    private void dieIfNoTreasures(){
            dead = visibleTreasures.isEmpty() && hiddenTreasures.isEmpty();
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        CombatResult result;
        System.out.printf("\nHAY COMBATE\n");
        if (getCombatLevel() > this.getOponentLevel(m)){
            applyPrize(m);
            if(level >= MAXLEVEL)
                result = CombatResult.WINGAME;
            else
                result = CombatResult.WIN;
        }
        else{
            applyBadConsequence(m);
            if(this.shouldConvert())
                result = CombatResult.LOSEANDCONVERT;
            else
                result = CombatResult.LOSE;
        }
        return result;
    }
    
    public void makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }    
    }
    
    public void discardVisibleTreasure(Treasure t){
       visibleTreasures.remove(t);
       if( pendingBadConsequence!=null && !pendingBadConsequence.isEmpty() )
           pendingBadConsequence.substractVisibleTreasure(t);
       
       dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
       hiddenTreasures.remove(t);
       if( pendingBadConsequence!=null && !pendingBadConsequence.isEmpty() )
           pendingBadConsequence.substractHiddenTreasure(t);
       
       dieIfNoTreasures();        
    }
    
    public boolean validState(){
        boolean validState = ((pendingBadConsequence==null || pendingBadConsequence.isEmpty()) &&
                getHiddenTreasures().size() < 5);    

        if(validState)
            System.out.println("\nESTADO VÁLIDO\n");
        else
            System.out.println("\nESTADO INVÁLIDO\n");
        return validState;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        Treasure t;
        bringToLife();
        int diceNumber = dice.nextNumber();
        System.out.println("\nTIRADA DEL DADO : " + diceNumber);
        switch(diceNumber){
            case 1:
                t = dealer.nextTreasure();
                if(t != null)
                    hiddenTreasures.add(t);
            break;
            case 6:
                for(int i=0; i<3; i++){
                    t = dealer.nextTreasure();
                    if(t != null)
                        hiddenTreasures.add(t);
                }
            break;
            default:
                for(int i=0; i<2; i++){
                    t = dealer.nextTreasure();
                    if(t != null)
                        hiddenTreasures.add(t);
                }
            break;
        }
        
        dieIfNoTreasures(); //En caso de que al ir a robar no haya cartas en
        //ninguna de las dos barajas, el jugador tambien debe aparecer como muerto
        //si antes de intentar robar no tenia tesoros y al no poder robar sigue 
        //sin tener
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        System.out.append("Numero obtenido al tirar el dado: " + number + "\n");
        return (number == 1);
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        Treasure treasure = null;
        if(canISteal())
            if(enemy.canYouGiveMeATreasure()){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        return treasure;
    }
    
    public void setEnemy(Player newEnemy){
        enemy = newEnemy;
    }
    
    protected Player getEnemy(){
        return this.enemy;
    }
    
    protected Treasure giveMeATreasure(){
        int posAleatoria = (int) (Math.random()* hiddenTreasures.size() );
        Treasure lostTreasure =hiddenTreasures.get(posAleatoria);
        hiddenTreasures.remove(lostTreasure);
        return lostTreasure;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    protected boolean canYouGiveMeATreasure(){
        return (!hiddenTreasures.isEmpty());
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> copiaVisible = new ArrayList<>(visibleTreasures);
        ArrayList<Treasure> copiaHidden = new ArrayList<> (hiddenTreasures);
        CardDealer dealer = CardDealer.getInstance();
        
        for(Treasure treasure : copiaVisible){
            discardVisibleTreasure(treasure);
            //Lo pasamos al mazo de descartados (usedTreasures)
            dealer.giveTreasureBack(treasure);
        }
        
        for(Treasure treasure : copiaHidden){
            discardHiddenTreasure(treasure);
            //Lo pasamos al mazo de descartados (usedTreasures)
            dealer.giveTreasureBack(treasure);
        }
       
    }
    
    @Override
    public String toString (){
        String resp =  name +
        "\nNivel : " + level + "\tNivel de combate : " + getCombatLevel();
        if(canISteal)
            resp += "\nEnemigo : " + enemy.getName();
        
        if(!isDead())
            resp += "\nJugador vivo";
        else
            resp += "\nJugador muerto";
                    
        resp += "\nMal rollo pendiente : \n";
        if(pendingBadConsequence == null || pendingBadConsequence.isEmpty())
            resp += "-NO HAY-";
        else
            resp += pendingBadConsequence.toString();
              
        return resp;
    }
}