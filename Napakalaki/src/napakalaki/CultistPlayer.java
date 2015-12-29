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
public class CultistPlayer extends Player{
    //Atributos
    private static int totalCultistPlayers = 0;
    CardDealer dealer = CardDealer.getInstance();
    Cultist myCultistCard = null;

    //Constructor
    public CultistPlayer(Player p, Cultist c){
        super(p);
        totalCultistPlayers++;
        myCultistCard = dealer.nextCultist();  
    }
    
    //Metodos
    public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override
    protected int getCombatLevel(){
        int suma = (int) (super.getCombatLevel() + super.getCombatLevel() * 0.2);
        suma += myCultistCard.getGainedLevels() * totalCultistPlayers;
        return suma;
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        int posAleatoria = (int) (Math.random()* visibleTreasures.size());
        Treasure lostTreasure = visibleTreasures.get(posAleatoria);
        visibleTreasures.remove(lostTreasure);
        return lostTreasure; 
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return (!visibleTreasures.isEmpty());
    }
    
    @Override
    public String toString(){
        String resp =  super.toString() + "\nJUGADOR SECTARIO \n";
        return resp;
    }
}
