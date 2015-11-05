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
    final static int MAXTREASURES = 10;
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
    }
    
    //Constructor Texto-Muerte(bool)
    public BadConsequence(String newText, boolean newDeath){
        text = newText;
        death = newDeath;
        
        levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;        
        
    }
    
    //Constructor con listas (Texto-Niveles-ListaVisibles-ListaOcultos)
    public BadConsequence(String newText, int newLevels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        text = newText;
        levels = newLevels;
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
        
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;        
    }    
    
    //Consultores
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }    
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public boolean getDeath (){
        return death;
    }
    
   public void substractVisibleTreasure(Treasure t){
        specificVisibleTreasures.remove(t.getType());
    }
    
    public void substractHiddenTreasure(Treasure t){
        specificHiddenTreasures.remove(t.getType());
    }
    
    public boolean isEmpty(){
        boolean esta_vacia = false;
        if(nHiddenTreasures == 0 && nVisibleTreasures == 0 &&
                specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty())
            esta_vacia = true;
        
        return esta_vacia;
    }

/*    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v , ArrayList<Treasure> h){
        //FALTA POR IMPLEMENTAR
        return this;
    }
*/
    
    //Implementacion de la clase toString
    @Override
    public String toString(){
        String resp = text; 
        if(death)
            resp+= "\nEstas muerto";
        else
            if(levels != 0)
                resp+= "\nNiveles que pierdes: " + Integer.toString(levels);
            
            if(nVisibleTreasures != 0 || nHiddenTreasures != 0)
                resp += "\nTesoros perdidos: ";
                if(nVisibleTreasures != 0)
                    resp += "\n\t -> Visibles = " + Integer.toString(nVisibleTreasures);
                if(nHiddenTreasures != 0)
                    resp += "\n\t -> Ocultos = " + Integer.toString(nHiddenTreasures);
            
            if(specificVisibleTreasures.isEmpty() || specificHiddenTreasures.isEmpty())
                resp += "\nTesoros especificos perdidos:";
                String borraCorchetesOculto = specificHiddenTreasures.toString();
                String borraCorchetesVisible = specificVisibleTreasures.toString();
                
                if(specificVisibleTreasures.isEmpty()) 
                    
                    resp += "\n\t -> Visibles : " + borraCorchetesVisible.substring(1, borraCorchetesVisible.length()-1);
                if(specificHiddenTreasures.isEmpty() )
                    
                    resp += "\n\t -> Ocultos : " + borraCorchetesOculto.substring(1, borraCorchetesOculto.length()-1);
        
        return resp;
    }
}
