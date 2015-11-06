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
    public Player(String name){ }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead = false;   //Supongo que esto es traer a la vida
    }
    
    private int getCombatLevel(){
        return level;   //falta mas
    }
    
    private void incrementLevels(int i){
        level += i;
    }
    
    private void decrementLevels(int i){
        level -= i;
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
    
    private void dielfNoTreasures(){
        //IMPLEMENTAR
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
        //IMPLEMENTAR
        return false;
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
        //IMPLEMENTAR
        return false;
    }
    
    private boolean canYouGiveMeATreasure(){
        //IMPLEMENTAR
        return false;
    }
    
    private void haveStolen(){
        //IMPLEMENTAR
    }
    
    public void dicardAllTreasures(){
        visibleTreasures.clear();
        hiddenTreasures.clear();
    }
}