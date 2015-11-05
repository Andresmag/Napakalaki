/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Algebro
 * @author Andresmag
 */

//POR IMPLEMENTAR 

public class Napakalaki {
    
    private static final Napakalaki Instance = null;
    
    //Constructor privado. (Quizás haya que modificarlo)
    private Napakalaki(){ }
    
 
    public static Napakalaki getInstance(){
        return Instance;
    }
    
    private void initPlayers (String[] players){
        //POR IMPLEMENTAR
    }
    
    private Player nextPlayer(){
        //POR IMPLEMENTAR
        return null;
    }
    
    private boolean nextTurnAllowed(){
        //POR IMPLEMENTAR
        return false;
    }
    
    private void setEnemies(){
        //POR IMPLEMENTAR
    }
    
    public CombatResult developCombat (){
        //POR IMPLEMENTAR
        return null;
    }
    
    public void discardVisibleTreasures(Treasure[] treasures){
        
    }
    
}
