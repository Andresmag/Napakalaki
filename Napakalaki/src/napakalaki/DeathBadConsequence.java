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
public class DeathBadConsequence extends NumericBadConsequence {
    
    //Atributos
    private boolean death;
    
    //Constructor
    public DeathBadConsequence(String newText, boolean newDeath){
        super(newText, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
        death = newDeath;
    }
    
    //Consultor
    
    public boolean getDeath (){
        return death;
    }
    
    //Método
    @Override
    public String toString(){
        String resp = text + "\nEstas muerto";
        return resp;
    }
}
