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
public class SpecificBadConsequence extends BadConsequence{
    
    //Atributos
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList(); 
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    //Constructor
    public SpecificBadConsequence(String newText, int numLevels, 
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        
        super(newText, numLevels);
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }
    
     //Consultores
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    //Métodos
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        specificVisibleTreasures.remove(t.getType());
    }
    
    public void substractHiddenTreasure(Treasure t){
         specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public boolean isEmpty(){
        return (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v , ArrayList<Treasure> h){
        ArrayList<TreasureKind> badSpecificVisible = new ArrayList<> ();
        ArrayList<TreasureKind> badSpecificHidden = new ArrayList<> ();

        if(!specificVisibleTreasures.isEmpty()){
            ArrayList <Treasure> copiav = new ArrayList(v);
            for(TreasureKind type : specificVisibleTreasures){
                int i = 0;
                boolean encontradov = false;

                while((i < copiav.size()) && !encontradov){
                    if(copiav.get(i).getType() == type){
                        encontradov = true;
                        badSpecificVisible.add(type);
                        copiav.remove(i);
                    }
                    i++;
                }
            }
        }
            
        if(!specificHiddenTreasures.isEmpty()){
            ArrayList <Treasure> copiah = new ArrayList(h);
            for(TreasureKind type : specificHiddenTreasures){
                int j = 0;
                boolean encontradoh = false;
                    
                while((j < copiah.size()) && !encontradoh){
                    if(copiah.get(j).getType() == type){
                        encontradoh = true;
                        badSpecificHidden.add(type);
                        copiah.remove(j);
                    }
                    j++;
                }
            }
        }
            
        SpecificBadConsequence badConse = new SpecificBadConsequence(getText(),getLevels(),badSpecificVisible,badSpecificHidden);   
        return badConse; 
    }
    
    @Override
    public String toString(){
        String resp = text;
        if(levels != 0)
            resp+= "\nNiveles que pierdes: " + Integer.toString(levels);
    
        if(!specificVisibleTreasures.isEmpty() || !specificHiddenTreasures.isEmpty()){
            resp += "\nTesoros especificos perdidos:";
            String borraCorchetesOculto = specificHiddenTreasures.toString();
            String borraCorchetesVisible = specificVisibleTreasures.toString();
                
            if(!specificVisibleTreasures.isEmpty())
                resp += "\n\t -> Visibles : " + borraCorchetesVisible.substring(1, borraCorchetesVisible.length()-1);
                
            if(!specificHiddenTreasures.isEmpty() )
                resp += "\n\t -> Ocultos : " + borraCorchetesOculto.substring(1, borraCorchetesOculto.length()-1);
        }

        return resp;
    }
}
