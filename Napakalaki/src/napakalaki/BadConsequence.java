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
        
        levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;        
        
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
        death = false;
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
     if(nVisibleTreasures > 0)
        nVisibleTreasures -= 1;
     else
        specificVisibleTreasures.remove(t.getType());
    }
    
    public void substractHiddenTreasure(Treasure t){
     if(nHiddenTreasures > 0)
        nHiddenTreasures -= 1;
     else
        specificHiddenTreasures.remove(t.getType());
    }
    
    public boolean isEmpty(){
        boolean esta_vacio = ( nHiddenTreasures == 0 && nVisibleTreasures == 0 &&
                specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty() );        
        return esta_vacio;
    }

    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v , ArrayList<Treasure> h){
        BadConsequence badConse= null;
        ArrayList<TreasureKind> badSpecificVisible = new ArrayList<> ();
        ArrayList<TreasureKind> badSpecificHidden = new ArrayList<> ();
        
        if(nVisibleTreasures > 0 || nHiddenTreasures > 0){
            int badvisible=nVisibleTreasures, badhidden=nHiddenTreasures;
            if(badvisible > v.size())
                badvisible = v.size();
            if(badhidden > h.size())
                badhidden = h.size();
            
            badConse = new BadConsequence(getText(),getLevels(),badvisible,badhidden);
        }
        else{
            if(!specificVisibleTreasures.isEmpty()){
                for(TreasureKind type : specificVisibleTreasures){
                    Treasure tesv;
                    boolean insertadov = false;
                    int tamv = v.size(), i=0;

                    while(i < tamv && !insertadov){
                        tesv = v.get(i);
                        insertadov = tesv.getType() == type;
                        i++;
                    }
                    if(insertadov)
                        badSpecificVisible.add(type);
                }
            }
            
            if(!specificHiddenTreasures.isEmpty()){
                for(TreasureKind type : specificHiddenTreasures){
                    Treasure tesh;
                    boolean insertadoh = false;
                    int tamh = h.size(), j=0;

                    while(j < tamh && !insertadoh){
                        tesh = h.get(j);
                        insertadoh = tesh.getType() == type;
                        j++;
                    }
                    if(insertadoh)
                        badSpecificHidden.add(type);
                }
            }
            
            badConse = new BadConsequence(getText(),getLevels(),badSpecificVisible,badSpecificHidden);   
        }
        
        return badConse;     
    }
        


    
    //Implementacion de la clase toString
    @Override
    public String toString(){
        String resp = text; 
        if(death)
            resp+= "\nEstas muerto";
        else{
            if(levels != 0)
                resp+= "\nNiveles que pierdes: " + Integer.toString(levels);
            
            if(nVisibleTreasures != 0 || nHiddenTreasures != 0){
                resp += "\nTesoros perdidos: ";
                if(nVisibleTreasures != 0)
                    resp += "\n\t -> Visibles = " + Integer.toString(nVisibleTreasures);
                
                if(nHiddenTreasures != 0)
                    resp += "\n\t -> Ocultos = " + Integer.toString(nHiddenTreasures);
            }
            
            if(!specificVisibleTreasures.isEmpty() || !specificHiddenTreasures.isEmpty()){
                resp += "\nTesoros especificos perdidos:";
                String borraCorchetesOculto = specificHiddenTreasures.toString();
                String borraCorchetesVisible = specificVisibleTreasures.toString();
                
                if(!specificVisibleTreasures.isEmpty())
                    resp += "\n\t -> Visibles : " + borraCorchetesVisible.substring(1, borraCorchetesVisible.length()-1);
                
                if(!specificHiddenTreasures.isEmpty() )
                    resp += "\n\t -> Ocultos : " + borraCorchetesOculto.substring(1, borraCorchetesOculto.length()-1);
            }
        }
        
        return resp;
    }
}
