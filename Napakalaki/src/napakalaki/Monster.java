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
public class Monster {
 
    //Atributos
    private String name;
    private int combatLevel;
    
    //Atributos de otras clases
    private Prize price;
    private BadConsequence bc;
    
    //Consultores
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    
    //Constructor
    public Monster(String newName, int level, BadConsequence newBC, Prize newPrice){
        name = newName;
        combatLevel = level;
        bc = newBC;
        price = newPrice;
    }
    
    //Implementación del método toString  (Por resvisar[Algebro])
    @Override
    public String toString(){
        String resp = "\nNombre = " + name + "\tNivel = " +Integer.toString(combatLevel);
        resp +=  price.toString();
        resp += "\nMal rollo : " + bc.toString();
        return resp;
    }
}
