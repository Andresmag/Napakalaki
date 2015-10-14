/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Andresmag
 * @author Algebro
 */
public class Prize {
    private int treasures;
    private int level;
    
    public Prize(int newLevel, int newTreasures){
        level = newLevel;
        treasures = newTreasures;
    }
    
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevel(){
        return level;
    }
    
    //Metodo toString
    public String toString(){
        return "Treasures = "+Integer.toString(treasures)+"levels = "+Integer.toString(level);
    }
}
