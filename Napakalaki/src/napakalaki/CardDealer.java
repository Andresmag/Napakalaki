/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Alejandro
 */
public class CardDealer {
    
    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultist;
    
    //Constructor privado.
    private CardDealer(){
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedCultist = new ArrayList();
    }
    
    private void initTreasureCardDeck(){
        //Como los Arrays ya estan inicializados, introducimos las cartas
        // directamente en unused
        
        unusedTreasures.add(new Treasure("¡Si mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthutlu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr.Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicon", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicon", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycon", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
       unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
        
         shuffleTreasures();    //Los barajamos una vez introducidos
    }
    
    private void initMonsterCardDeck(){
        //Como los Arrays ya estan inicializados, introducimos las cartas
        // directamente en unused
        
        BadConsequence badConsequence;
        Prize prize;

        //monstruos[0] = 3 Byakhees de bonanza
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //monstruos[1] = Chibithulhu
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu" , 2, badConsequence, prize));
        
        //monstruos[2] = El sopor de Dunwich
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        //monstruos[3] = Angeles de la noche ibicenca
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Decarta 1 mano visible y 1 mano oculta",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(1, 4);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));
        
        //monstruos[4] = El gorron en el umbral
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles",
                0,BadConsequence.MAXTREASURES,0);
        prize = new Prize(1, 3);
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, badConsequence, prize));
        
        
        //monstruos[5] = H.P Munchcraft
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("H.P Munchcraft", 6, badConsequence, prize));
        
        
        //monstruos[6] = Bichgooth
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        
        //monstruos[7] = El rey de rosa
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles",
                5, 3, 0);
        prize = new Prize(2, 4);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        
        //monstruos[8] = La que redacta en las tinieblas
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles",
                2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        
        //monstruos[9] = Los hondos
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",
                true);
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        
        //monstruos[10] = Semillas Cthulhu
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",
                2, 0, 2);
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        
        //monstruos[11] = Dameargo
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        
        //monstruos[12] = Pollipolipo volante
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",
                3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));
        
        
        //monstruos[13] = Yskhtihyssg-Goth
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto",
                true);
        prize = new Prize(1, 3);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        
        //monstruos[14] = Familia feliz
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estas muerto",
                true);
        prize = new Prize(1, 4);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        
        //monstruos[15] = Roboggoth
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
                2,
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        //monstruos[16] = El espia
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        
        
        //monstruos[17] = El lenguas
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",
                2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        
        //monstruos[18] = Bicefalo 
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",
                3,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), 
                new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicefalo", 20, badConsequence, prize));
        
        //monstruos[19] = El mal indecible impronunciable
        badConsequence = new SpecificBadConsequence("Pierdes una mano visible",
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(1, 3);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        //monstruos[20] = Testigos oculares
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",
                0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize, 2));
        
        //monstruos[21] = El gran Cthulhu
        badConsequence = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres",
                true);
        prize = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran Cthulhu", 10, badConsequence, prize, 4));
        
        //monstruos[22] = Serpiente político
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles",
                2, 0, 0);
        prize = new Prize(1, 2);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, badConsequence, prize, -2));
        
        //monstruos[23] = Felpuggoth
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND,
                        TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));
        
        //monstruos[24] = Shoggoth
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles",
                2, 0, 0);
        prize = new Prize(2, 4);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        //monstruos[25] = Lolitagooth
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles",
                2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
        
        shuffleMonsters(); //Los barajamos una vez incluidos
    }
    
    private void initCultistCardDeck(){
        //Como los Arrays ya estan inicializados, introducimos las cartas
        // directamente en unused
        
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 1));
        
        shuffleCultist(); //Los barajamos una vez introducidos
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    } 
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultist(){
        Collections.shuffle(unusedCultist);
    }
    
    public static CardDealer getInstance(){
        if(instance == null)
            instance = new CardDealer();
        return instance;
    }
    
    public Treasure nextTreasure(){
        Treasure t = null;
        if(unusedTreasures.isEmpty()){
            if(!usedTreasures.isEmpty()){
                //Lo volvemos a rellenar
                for(Treasure usedTreasure : usedTreasures)
                    unusedTreasures.add(usedTreasure);

                //Lo volvemos a barajar
                shuffleTreasures();

                //Limpiamos el mazo de descartes
                usedTreasures.clear();
            }
            else
                System.out.println("No hay cartas tampoco en el mazo de descartes");
        }
        
        if(!unusedTreasures.isEmpty()){
            //Cojemos el primero
            t = unusedTreasures.get(0);
        
            //Y lo quitamos del mazo de donde se cogen para evitar repetirlo
            unusedTreasures.remove(t);
        }
        
        return t;
    }
    
    public Monster nextMonster (){
        if(unusedMonsters.isEmpty()){
            //Lo volvemos a rellenar
            for(Monster usedMonster : usedMonsters)
                unusedMonsters.add(usedMonster);
            
            
            //Lo volvemos a barajar
            shuffleMonsters();
            
            //Limpiamos el mazo de descartes
            usedMonsters.clear();
        }
        
        //Cojemos el primero
        Monster m = unusedMonsters.get(0);
        
        //Lo añadimos al mazo de descartes para no volver a cogerlo
        giveMonsterBack(m);
        
        //Y lo quitamos del mazo de donde se cogen para evitar repetirlo
        unusedMonsters.remove(m);
        
        return m;  
    }
    
    public Cultist nextCultist(){
        Cultist c = unusedCultist.get(0); //Cojemos el primero
        unusedCultist.remove(c); //Lo quitamos de la lista para no volver a cogerlo
        
        return c;        
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards (){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
    }
    
}
