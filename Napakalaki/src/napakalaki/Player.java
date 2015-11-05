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
 * @author Andresmag
 */
class Player {
    final static int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    Player enemy;
    private BadConsequence pendingBadConsequence;
    ArrayList<Treasure> hiddenTreasures = new ArrayList <> ();
    ArrayList<Treasure> visibleTreasures = new ArrayList <> ();
   
    
}
