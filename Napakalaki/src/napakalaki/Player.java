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
        //IMPLEMENTAR
        return false;
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
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
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
        boolean validState = false;
        if(pendingBadConsequence.isEmpty() && getHiddenTreasures().size() < 5)
            validState = true;
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
        //Implementar
        return null;
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