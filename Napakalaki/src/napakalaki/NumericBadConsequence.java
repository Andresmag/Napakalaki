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
public class NumericBadConsequence extends BadConsequence{
    
    //Atributos
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    
    //Constructor 
    public NumericBadConsequence(String newText, int newLevels, int nVisible, int nHidden){
        super(newText, newLevels);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    //Consultores 
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    //Métodos
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures > 0)
            nVisibleTreasures -= 1;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures > 0)
            nHiddenTreasures -= 1;    
    }
    
    @Override
    public boolean isEmpty(){
        return (nHiddenTreasures == 0 && nVisibleTreasures == 0);
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v , ArrayList<Treasure> h){
        int badvisible = 0; 
        int badhidden = 0;
        if(nVisibleTreasures > 0){
            badvisible = nVisibleTreasures;
            if(badvisible > v.size())
                badvisible = v.size();
        }
            
        if(nHiddenTreasures > 0){
            badhidden = nHiddenTreasures;
            if(badhidden > h.size())
                badhidden = h.size();
        }
        
        NumericBadConsequence badConse = new NumericBadConsequence(getText(),getLevels(),badvisible,badhidden);
        return badConse;
    } 
    
    @Override
    public String toString(){
        String resp = text; 
        if(levels != 0)
            resp+= "\nNiveles que pierdes: " + Integer.toString(levels);
        
        if(nVisibleTreasures != 0 || nHiddenTreasures != 0){
                resp += "\nTesoros perdidos: ";
                if(nVisibleTreasures != 0)
                    resp += "\n\t -> Visibles = " + Integer.toString(nVisibleTreasures);
                
                if(nHiddenTreasures != 0)
                    resp += "\n\t -> Ocultos = " + Integer.toString(nHiddenTreasures);
        }
        
        return resp;        
    }
}
