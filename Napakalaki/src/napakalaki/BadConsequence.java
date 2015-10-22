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
    
    //Constructor Texto-Niveles-TesorosVisible-TesorosOcultos
    public BadConsequence(String newText, int newLevels, int nVisible, int nHidden){
        text = newText;
        levels = newLevels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        
        death = false;
        specificHiddenTreasures = null;
        specificVisibleTreasures = null;
    }
    
    //Constructor Texto-Muerte(bool)
    public BadConsequence(String newText, boolean newDeath){
        text = newText;
        death = newDeath;
        
        levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificHiddenTreasures = null;
        specificVisibleTreasures = null;        
        
    }
    
    //Constructor con listas (Texto-Niveles-ListaVisibles-ListaOcultos)
    public BadConsequence(String newText, int newLevels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        text = newText;
        levels = newLevels;
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
        
        nVisibleTreasures = specificVisibleTreasures.size();
        nHiddenTreasures = specificHiddenTreasures.size();        
        
        
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
    
    
    //Implementacion de la clase toString
    @Override
    public String toString(){
        String borraCorchetesVisible = specificVisibleTreasures.toString();
        String borraCorchetesOculto = specificHiddenTreasures.toString();
        String resp = "\nTexto: \"" + text + "\" \nLevels = " + Integer.toString(levels) + "\tTesoros: "
                + " visbles = " + Integer.toString(nVisibleTreasures)
                + " ocultos = " + Integer.toString(nHiddenTreasures)
                + "\nVisibles : " + borraCorchetesVisible.substring(1, borraCorchetesVisible.length()-1)
                + "\nOcultos : " + borraCorchetesOculto.substring(1, borraCorchetesOculto.length()-1)
                + "\nMuerte : ";
        if(death)
            resp+= "Sí";
        else
            resp+= "No";
        
        return resp;
    }
}
