/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Alejandro
 */
public class Treasure {
    private TreasureKind type;
    private String name;
    private int bonus;
    
    public Treasure (String n, int b, TreasureKind t){
        type = t;
        name  = n;
        bonus = b;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBonus() {
        return bonus;
    }
   
    public TreasureKind getType(){
        return type;
    }
    
    @Override
    public String toString(){
        String resp = "Nombre del tesoro: " + name + "\nTipo de tesoro: " + type +
                "\nBonificacion otorgada: " + bonus;
        
        return resp;
    }
}
