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
    private int levelChangeAgainstCultistPlayer;
    
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
    
    public int getCombatLevelAgainstCultistPlayer(){
        int level = this.getCombatLevel() + levelChangeAgainstCultistPlayer;
        return level;
    }

    public BadConsequence getBadConsequence (){
        return bc;
    }
    
    public int getLevelsGained(){
        return price.getLevel();
    }
    
    public int getTreasuresGained(){
        return price.getTreasures();
    }
    
    //Constructores
    public Monster(String newName, int level, BadConsequence newBC, Prize newPrice){
        name = newName;
        combatLevel = level;
        bc = newBC;
        price = newPrice;
        levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String n, int l, BadConsequence b, Prize p, int IC){
        name = n;
        combatLevel = l;
        bc = b;
        price = p;
        levelChangeAgainstCultistPlayer = IC;
    }
    
    @Override
    public String toString(){
        String resp = "\nNombre: " + name + "\t  Nivel: " + getCombatLevel();
        if(levelChangeAgainstCultistPlayer != 0)
            resp += "\nNivel contra sectarios: " + getCombatLevelAgainstCultistPlayer();
        
        resp +=  "\nNiveles que ganas: " + getLevelsGained() + "\tTesoros que ganas: " + getTreasuresGained();
        resp += "\nMal rollo: " + bc.toString();
        return resp;
    }
}
