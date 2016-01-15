
package napakalaki;

import Test.GameTester;


public class EjemploMain {

    public static void main(String[] args) {
      Napakalaki game = Napakalaki.getInstance();
      GameTester test = GameTester.getInstance();
      
      // Poner el numero de jugadores con el que se quiera probar
      test.play(game, 2); 
              
    }
}
