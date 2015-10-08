/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Andresmag
 */
public class Monster {
    private String name;
    private int combatLevel;
    
    //Consultores
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    //Atributos de otras clases
    private Prize price;
    private BadConsequence bc;
    
    public Monster(String newName, int level, BadConsequence newBC, Prize newPrice){
        name = newName;
        combatLevel = level;
        bc = newBC;
        price = newPrice;
    }
    
    //Implementación del método toString
    public String toString(){
        return "Nombre = " + name + "Nivel = " +Integer.toString(combatLevel);
        //Faltan cosas, supongo...
    }
}
