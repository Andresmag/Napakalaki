/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class CardDealer {
    
    private static final CardDealer instance = null;
    ArrayList<Monster> unusedMonsters = new ArrayList <> ();
    ArrayList<Monster> usedMonsters = new ArrayList <> ();
    ArrayList<Treasure> unusedTreasures = new ArrayList <> ();
    ArrayList<Treasure> usedTreasures = new ArrayList <> ();
    
    //Constructor privado. (Quizás haya que modificarlo)
    private CardDealer(){}
    
    private void initTreasureCardDeck(){
        //FALTA POR IMPLEMENTAR
    }
 
    private void initMonsterCardDeck(){
        //FALTA POR IMPLEMENTAR
    }
    
    private void suffleTreasures(){
        //FALTA POR IMPLEMENTAR
    } 
    
    private void suffleMonsters(){
        //FALTA POR IMPLEMENTAR
    }
    
    public CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        //FALTA POR IMPLEMENTAR
        return null;
    }
    
    public Monster nextMonster (){
        //FALTA POR IMPLEMENTAR
        return null;    
    }
    
    public void giveTreasureBack(Treasure t){
        //FALTA POR IMPLEMENTAR
    }
    
    public void giveMonsterBack(Monster m){
        //FALTA POR IMPLEMENTAR
    }
    
    public void initCards (){
        initTreasureCardDeck();
        initMonsterCardDeck();
    }
    
}
