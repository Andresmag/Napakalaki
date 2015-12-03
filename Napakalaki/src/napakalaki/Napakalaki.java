/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Algebro
 * @author Andresmag
 */


public class Napakalaki {
    
    private static Napakalaki instance;
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    
    //Constructor privado. 
    private Napakalaki(){
        currentMonster = null;
        dealer = CardDealer.getInstance();
        currentPlayer = null; 
        players = new ArrayList<>();
    }
    
 
    public static Napakalaki getInstance(){
        if(instance == null)
            instance = new Napakalaki();
        
        return instance;
    }
    
    private void initPlayers (ArrayList<String> names){
        if(!names.isEmpty() )
            for (String name : names) {
                Player nuevoPlayer = new Player(name);
                players.add(nuevoPlayer);
            }
    } 
    
    private Player nextPlayer(){
        if(currentPlayer == null){
            int numAleatorio = (int) (Math.random()* players.size() );
            currentPlayer = players.get(numAleatorio);        
        }else{
            int num = players.indexOf(currentPlayer);
            if(num == players.size()-1)
              currentPlayer = players.get(0);
            else
              currentPlayer = players.get(num+1);
        }
         System.out.println("\nNEXT PLAYER : " + currentPlayer.getName() + "\n");
         return currentPlayer;
    }

    private boolean nextTurnAllowed(){
        boolean resp;
        if(currentPlayer==null)
            resp = true;
        else
            resp = currentPlayer.validState();
        return resp;
    }
    
    private void setEnemies(){
        int iterador = 0;
        int tam = players.size();
        int numeroAleatorio;
        Player jugadorActual;
        Player elegido;
        while(iterador < tam){
            numeroAleatorio = (int) (Math.random()* tam ); //Genero un numero aleatorio para la posicion en el vector
            jugadorActual = players.get(iterador);
            elegido = players.get(numeroAleatorio); //Se elige un jugador aleatorio
            if(elegido != jugadorActual){  //No es él mismo.
                jugadorActual.setEnemy(elegido);    //Asigno al enemigo
                iterador++;                 //Indico que pase al siguiente jugador.
            } 
        }
        
    }
    
    public CombatResult developCombat (){
        CombatResult resp = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        return resp;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for (Treasure treasure : treasures) {
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
 
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for (Treasure treasure : treasures) {
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }   
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
         for(Treasure treasure : treasures)
              currentPlayer.makeTreasureVisible(treasure);
         
     }
     
    public void initGame(ArrayList<String> players){
         initPlayers(players);
         setEnemies();
         dealer.initCards();
         nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster; 
    }
    
    public boolean nextTurn() {
        boolean stateOK = nextTurnAllowed();
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            if(currentPlayer.isDead())
                currentPlayer.initTreasures();
        }
        return stateOK; 
    }
    
    public boolean endOfGame(CombatResult result){
        return result.equals(CombatResult.WINGAME);
    }
     
}
