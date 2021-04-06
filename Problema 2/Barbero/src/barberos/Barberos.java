/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberos;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import barberos.Cliente;
import static java.lang.Thread.sleep;

/**
 *
 * @author Robles
 */
public class Barberos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Barbero barbero = new Barbero(false);
        for (int i = 0; i < 50; i++) {
            Cliente c = new Cliente(i + 1, barbero);
            c.start();
        }
    }
     
}
