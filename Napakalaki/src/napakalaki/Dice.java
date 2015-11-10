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
    
    private Dice() {
    }
    
    public static Dice getInstance() {
        return DiceHolder.INSTANCE;
    }
    
    private static class DiceHolder {

        private static final Dice INSTANCE = new Dice();
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
