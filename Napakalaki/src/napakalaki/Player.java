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
class Player {
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
        //Supongo que los ocultos no cuenta
        return combatLevel;   //falta mas
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
        //Falta la parte de los tesoros
    }
    
    private void applyBadConsequence(Monster m){
        if(m.getBadConsequence().getDeath())
            dead = true;
        else{
            decrementLevels(m.getBadConsequence().getLevels());
        //Falta la parte de los tesoros
        }
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
        //IMPLEMENTAR
        return null;
    }
    
    public void makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }    
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
    }
    
    public boolean validState(){
        boolean validState = pendingBadConsequence.isEmpty() && 
                             getHiddenTreasures().size() < 5 ;
        return validState;
    }
    
    public void initTreasures(){
        //IMPLEMENTAR
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        //IMPLEMENTAR
        return null;
    }
    
    public void setEnemy(Player newEnemy){
        enemy = newEnemy;
    }
    
    private Treasure giveMeATreasure(){
        int posAleatoria = (int) (Math.random()* hiddenTreasures.size() );
        return hiddenTreasures.get(posAleatoria);
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        boolean canSteal = false;
        if(enemy.getVisibleTreasures().size() > 0 || 
                enemy.getHiddenTreasures().size() >0)
                    canSteal = true;
        return canSteal;
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void dicardAllTreasures(){
        visibleTreasures.clear();
        hiddenTreasures.clear();
    }
}