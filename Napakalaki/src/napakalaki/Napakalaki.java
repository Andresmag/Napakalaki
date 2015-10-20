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
        
        //monstruos[0] = 3 Byakhees de bonanza
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(1, 2);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        
        //monstruos[1] = Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Chibithulhu" , 2, badConsequence, prize));
        
        
        //monstruos[2] = El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        
        //monstruos[3] = Angeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Decarta 1 mano visible y 1 mano oculta",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(1, 4);
        monstruos.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));
        
        
        //monstruos[4] = El gorron en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET.ARMOR.ONEHAND.BOTHHANDS.SHOES)), //No estoy seguro de que se pueda
                new ArrayList());
        prize = new Prize(1, 3);
        monstruos.add(new Monster("El gorron en el umbral", 10, badConsequence, prize));
        
        
        //monstruos[5] = H.P Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(1, 2);
        monstruos.add(new Monster("H.P Munchcraft", 6, badConsequence, prize));
        
        
        //monstruos[6] = Bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        
        //monstruos[7] = El rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros",
                5, 3, 0);
        prize = new Prize(2, 4);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        
        //monstruos[8] = La que redacta en las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles",
                2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        
        //monstruos[9] = Los hondos
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",
                true);
        prize = new Prize(1, 2);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        
        //monstruos[10] = Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",
                2, 0, 2);
        prize = new Prize(1, 2);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        
        //monstruos[11] = Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        prize = new Prize(1, 2);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        
        //monstruos[12] = Pollipolipo volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",
                3, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));
        
        
        //monstruos[13] = Yskhtihyssg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto",
                true);
        prize = new Prize(1, 3);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        
        //monstruos[14] = Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto",
                true);
        prize = new Prize(1, 4);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        
        //monstruos[15] = Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
                2,
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(1, 2);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        //monstruos[16] = El espia
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
        
        
        //monstruos[17] = El lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",
                2, 5, 0);
        prize = new Prize(1, 4);
        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        
        //monstruos[18] = Bicefalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND.BOTHHANDS)),  //Lo de perder todos los tesoros visibles de las manos no se como es, he probado asi pero dudo que lo sea
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bicefalo", 20, badConsequence, prize));
        
        
        //Prueba de muestra por pantalla
        System.out.println(monstruos.get(0).toString() );
        System.out.println(monstruos.get(4).toString() );
        
    }
    
}
