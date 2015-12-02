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
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
   
    //Métodos
    public Player(String newName){ 
        name = newName;
        level = 1;
        enemy = null;
        pendingBadConsequence = null;
    }
    
    public String getName(){
        return name;
    }
    
    
    private void bringToLife(){
        dead = false;   //Supongo que esto es traer a la vida
    }
    
    
    private int getCombatLevel(){
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
            for(int i=0; i< nTreasures; i++)
                hiddenTreasures.add(dealer.nextTreasure());
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
              int una_mano = 0;  //Contador para ver cuantos tesoros OneHand lleva equipados
              int i=0, tam = visibleTreasures.size();
              Treasure tes;
              while(i< tam && puedeEquipar){
                    tes = visibleTreasures.get(i);
                    puedeEquipar = !(tes.getType() == TreasureKind.BOTHHANDS);
                    if(puedeEquipar && tes.getType() == TreasureKind.ONEHAND){
                        una_mano++;
                        puedeEquipar = (una_mano < 2);
                    }
                    i++;
              }
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
        
        return contador;    //Supongo que es asi
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
        if (getCombatLevel() > m.getCombatLevel() ){
            applyPrize(m);
            if(level >= MAXLEVEL)
                result = CombatResult.WINGAME;
            else
                result = CombatResult.WIN;
        }
        else{
            applyBadConsequence(m);
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
        boolean validState = pendingBadConsequence==null;    //Si es nulo, es el primero turno.
        if(!validState)
            validState = pendingBadConsequence.isEmpty() && getHiddenTreasures().size() < 5 ;

        if(validState)
            System.out.println("\nESTADO VÁLIDO\n");
        else
            System.out.println("\nESTADO INVÁLIDO\n");
        return validState;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        int diceNumber = dice.nextNumber();
        System.out.println("\nTIRADA DE DADO : " + diceNumber + "\n");
        switch(diceNumber){
            case 1:
                   hiddenTreasures.add(dealer.nextTreasure());
            break;
            case 6:
                   hiddenTreasures.add(dealer.nextTreasure());
                   hiddenTreasures.add(dealer.nextTreasure());
                   hiddenTreasures.add(dealer.nextTreasure());
            break;
            default:
                   hiddenTreasures.add(dealer.nextTreasure());
                   hiddenTreasures.add(dealer.nextTreasure());
            break;
        }
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
    
    private Treasure giveMeATreasure(){
        int posAleatoria = (int) (Math.random()* hiddenTreasures.size() );
        Treasure lostTreasure =hiddenTreasures.get(posAleatoria);
        hiddenTreasures.remove(lostTreasure);
        return lostTreasure;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        return (!hiddenTreasures.isEmpty());
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> copiaVisible = new ArrayList<>(visibleTreasures);
        ArrayList<Treasure> copiaHidden = new ArrayList<> (hiddenTreasures);
        
        for(Treasure treasure : copiaVisible)
            discardVisibleTreasure(treasure);
        for(Treasure treasure : copiaHidden)
            discardHiddenTreasure(treasure);
       
    }
    
    @Override
    public String toString (){
        String resp = "\nNOMBRE : " + name + "\n" +
                    "Nivel :\t" + level + "\tPoder :\t" + getCombatLevel() + "\n" +
                    "Enemigo : " + enemy.getName() + "\n" +
                    "Mal rollo pendiente : \n";
                    if(pendingBadConsequence == null || pendingBadConsequence.isEmpty())
                        resp += "-NO HAY-";
                    else
                        resp += pendingBadConsequence.toString();
              
        return resp;
    }
}