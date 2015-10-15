/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Andresmag
 * @author Algebro
 */
public class Napakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Array contenedor de monstruos
        ArrayList<Monster> monstruos = new ArrayList();
        
        //Declaración de los distintos tipos de monstruos con sus malos rollos y premios y añadidos al vector
        //Objetos necesarios
        BadConsequence badConsequence;
        Prize prize;
        
        //Monstruos
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(1, 2);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Chibithulhu" , 2, badConsequence, prize));
        
        //Prueba de muestra por pantalla
        System.out.println(monstruos.get(0).toString() );
        System.out.println(monstruos.get(1).toString() );
        
    }
    
}
