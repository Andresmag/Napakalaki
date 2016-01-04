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
public class Cultist {
    //Atributos
    private String name;
    private int gainedLevels;
    
    //Constructor
    public Cultist(String nombre, int levels){
        name = nombre;
        gainedLevels = levels;
    }
    
    //Metodos
    public int getGainedLevels(){
        return gainedLevels; 
    }
    
    @Override
    public String toString(){
        String resp = "\nNombre de sectario: " + name;
        resp += "\nNiveles que ganas por cada sectario en juego: " + getGainedLevels();
        
        return resp;
    }
}
