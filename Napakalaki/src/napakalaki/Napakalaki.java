/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Algebro
 * @author Andresmag
 */

//POR IMPLEMENTAR 

public class Napakalaki {
    
    private static final Napakalaki instance = null;
    
    //Constructor privado. (Quizás haya que modificarlo)
    private Napakalaki(){ }
    
 
    public static Napakalaki getInstance(){
        return instance;
    }
    
    private void initPlayers (ArrayList<String> names){
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
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        //POR IMPLEMENTAR
    }
 
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        //POR IMPLEMENTAR
    }   
    
    public makeTreasuresVisible(ArrayList<Treasure> treasures){
         //POR IMPLEMENTAR
     }
     
    public void initGame(ArrayList<String> players){
        //POR IMPLEMENTAR
    }
    
    public Player getCurrentPlayer(){
        //POR IMPLEMENTAR
        return null;
    }
    
    public Monster getCurrentMonster(){
        //POR IMPLEMENTAR
        return null; 
    }
    
    public boolean nextTurn() {
        //POR IMPLEMENTAR
        return false; 
    }
    
    public boolean endOfGame(CombatResult result){
        //POR IMPLEMENTAR
        return false;
    }
     
}
