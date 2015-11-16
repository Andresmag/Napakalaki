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
    
    private static Napakalaki instance = null;
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer = null;
    private ArrayList<Player> players = new ArrayList();
    
    
    //Constructor privado. (Quizás haya que modificarlo)
    private Napakalaki(){ }
    
 
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
            int numAleatorio = (int) (Math.random()* players.size() + 1);
            currentPlayer = players.get(numAleatorio);        
        }else{
            int num = 0;
            while (players.get(num) != currentPlayer)
              num += 1;
            
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
        final int maximasReiteraciones = 10;    //Maximo de reiteraciones erroneas.
        boolean asignando = true;
        while(asignando){
            ArrayList<Integer> numeros = new ArrayList <> ();   //lista que contendrá el 'numero de cada jugador'
            for(int i=0; i< players.size(); i++)
                numeros.add(i);
            int iterador = 0;
            int reiterador = 0;
            while(reiterador < maximasReiteraciones ||  iterador < players.size()){
                int numeroAleatorio;
                    numeroAleatorio = (int) (Math.random()* numeros.size() + 1); //Genero un numero aleatorio para la posicion en el vector
                    Player jugadorActual = players.get(iterador);
                    Player elegido = players.get(numeros.get(numeroAleatorio)); //El jugador con el 'numero' igual a dicha posicion de la lista de numeros
                if(elegido == jugadorActual)  //Es él mismo.
                    reiterador++;
                else{       //No es él mismo.
                    jugadorActual.setEnemy(elegido);    //Asigno al enemigo
                    numeros.remove(numeroAleatorio);    //Elimino el que está en la posicion 'numeroAleatorio'
                    iterador++;                 //Indico que pase al siguiente jugador.
                    reiterador = 0;             //Reinicio el contador de elecciones erróneas
                } 
            }
            asignando = reiterador < maximasReiteraciones;  //NO hemos superado el maximo (hemos asignado todos correctamente)
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
        //POR IMPLEMENTAR
        return null;
    }
    
    public Monster getCurrentMonster(){
        //POR IMPLEMENTAR
        return null; 
    }
    
    public boolean nextTurn() {
        //POR IMPLEMENTAR
        return false; 
    }
    
    public boolean endOfGame(CombatResult result){
        //POR IMPLEMENTAR
        return false;
    }
     
}
