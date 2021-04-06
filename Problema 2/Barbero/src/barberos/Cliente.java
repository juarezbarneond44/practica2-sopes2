/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberos;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robles
 */
public class Cliente extends Thread{
    private Barbero barber;
    private int turnocliente;
    
    public Cliente(int clienumber, Barbero barber) {
        this.turnocliente = clienumber;
        this.barber = barber;
    }

    @Override
    public void run() {
        try {
            barber.inicioCorte(turnocliente);
            sleep(1000);
            barber.finCorte(turnocliente);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
