/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Lenovo
 */
public class Dice {
    
    private static Dice instance = null;
    
    private Dice(){
    }
    
    public static Dice getInstance(){
        if(instance == null){
            instance = new Dice();
        }
        
        return instance;
    }
    
    public int nextNumber(){
        int number = (int) (Math.random()*6+1);
        return number;
    }
    
    @Override
    public String toString(){
        String resp = "Numero obtenido: " + nextNumber();
        return resp;
    }
}
