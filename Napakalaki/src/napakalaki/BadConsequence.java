/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Andresmag
 * @author Algebro
 */
 
public abstract class BadConsequence {
    
    //Atributos
    final static int MAXTREASURES = 10;
    protected String text;
    protected int levels;
       
    //Constructor
    public BadConsequence(String newText, int numLevels){
        text = newText;
        levels = numLevels;
    }   
    
   //Consultores    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    //Métodos
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract boolean isEmpty();

    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v , ArrayList<Treasure> h);

    @Override
    public abstract String toString();
}