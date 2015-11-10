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
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     *
     */
    
    //Consulta los monstruos con nivel mayor de "nivelminimo"
    public static void ConsultaNivel(ArrayList<Monster> monstruos,int nivelminimo){
        System.out.println("MONSTRUOS CON NIVEL SUPERIOR A " + nivelminimo + " :");
        for(Monster monstruo : monstruos){
            if(monstruo.getCombatLevel() > nivelminimo)
                System.out.println(monstruo.toString());
        }
    }
    
    //Consulta los monstruos que solo implican perdida de niveles
    public static void ConsultaSoloNiveles (ArrayList<Monster> monstruos){
        System.out.println("MONSTRUOS CUYO MAL ROLLO SOLO IMPLICA PERDIDA DE NIVELES:");
        boolean soloniveles;
        for(Monster monstruo : monstruos){
            soloniveles =(monstruo.getBadConsequence().getNHiddenTreasures()==0 &&
                          monstruo.getBadConsequence().getNVisibleTreasures() == 0 &&
                          !(monstruo.getBadConsequence().getDeath()) );
            if(soloniveles)
                System.out.println(monstruo.toString());
        }    
    }
    
    public static void ConsultaGananciaNivel (ArrayList<Monster> monstruos, int cantidadminima){
        System.out.println("MONSTRUOS CON LOS QUE GANAS MAS DE UN NIVEL:");
         for(Monster monstruo : monstruos)
            if(monstruo.getLevelsGained() > cantidadminima)
                System.out.println(monstruo.toString());   
    }
    
    public static void ConsultaTipoConcreto (ArrayList<Monster> monstruos, TreasureKind tipo){
        System.out.println("MONSTRUOS CON LOS QUE PIERDES EL OBJETO ESPECIFICO: " + tipo);
        boolean tipoencontrado;   
        for(Monster monstruo : monstruos){
            tipoencontrado = monstruo.getBadConsequence().getSpecificHiddenTreasures().contains(tipo) ||
                             monstruo.getBadConsequence().getSpecificVisibleTreasures().contains(tipo);
            if(tipoencontrado)
                System.out.println(monstruo.toString());
        }
    }      
            
            
    public static void main(String[] args) {
        
//     //Consultar monstruos con nivel superior a 'n'
/*       int superiorNivelCombat = 10;
       ConsultaNivel(monstruos,superiorNIvelCombat);
*/
    
//     //Consultar monstruos cuyo BadConsequence implica solo perdida de niveles.
//       ConsultaSoloNiveles(monstruos);

        
//     //Consultar monstruos cuyo premio consta de más de 'n' niveles;
/*       int superiorNivelPrize = 1;
       ConsultaGananciaNivel(monstruos,superiorNivelPrize);
*/ 
        
//     //Consultar monstruos cuya Consecuencia afecta a un objeto de tipo 'type'
/*      TreasureKind type = TreasureKind.ARMOR;
       ConsultaTipoConcreto(monstruos,type);
*/     
       // Para mostrar todos los monstruos
/*        
        for(Monster monstruo : monstruos){
            System.out.println(monstruo.toString());
        }
        
        //Prueba de la clase Treasure

        Treasure t;
        t = new Treasure("Espada mata Algebros", 5, TreasureKind.BOTHHANDS);
        System.out.println(t.toString());
*/
        Dice dice = Dice.getInstance();
        System.out.println(dice.toString());
    }
}
