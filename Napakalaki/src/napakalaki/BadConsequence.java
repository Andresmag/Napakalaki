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
 
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
   
    //Atributos de tipo lista de TreasureKind
 
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList(); 
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList(); 
    
    //Constructores
    public BadConsequence(String newText, int newLevels, int nVisible, int nHidden){
        text = newText;
        levels = newLevels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    public BadConsequence(String newText, boolean newDeath){
        text = newText;
        death = newDeath;
    }
    
    //Consultores
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    
    //Constructor con listas
    public BadConsequence(String newText, int newLevels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        text = newText;
        levels = newLevels;
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }
    
    //Implementacion de la clase toString
    public String toString(){
        String resp = "\nTexto: \" " + text + " \" \nLevels = " + Integer.toString(levels) + "\tTesoros = " + Integer.toString(nVisibleTreasures + nHiddenTreasures);
        resp += "\nVisibles : " + Integer.toString(nVisibleTreasures) + "\nOcultos : " + Integer.toString(nHiddenTreasures);
        resp += "\nMuerte : ";
        if(death)
            resp+= "Sí";
        else
            resp+= "No";
        
        return resp;
    }
}
