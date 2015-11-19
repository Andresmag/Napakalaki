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

//POR IMPLEMENTAR 

public class Napakalaki {
    
    private static Napakalaki instance;
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    
    //Constructor privado. (Quizás haya que modificarlo)
    private Napakalaki(){
        currentMonster = null;
        dealer = null;
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
              currentPlayer = players.get(num);
        }
         return currentPlayer;
    }

    private boolean nextTurnAllowed(){
        return currentPlayer.validState();
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
        //POR IMPLEMENTAR
        return null;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        //POR IMPLEMENTAR
    }
 
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        //POR IMPLEMENTAR
    }   
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
         //POR IMPLEMENTAR
     }
     
    public void initGame(ArrayList<String> players){
        //POR IMPLEMENTAR 
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster; 
    }
    
    public boolean nextTurn() {
        //POR IMPLEMENTAR
        return false; 
    }
    
    public boolean endOfGame(CombatResult result){
        return result.equals(CombatResult.WINGAME);
    }
     
}
