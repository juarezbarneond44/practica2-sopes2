/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robles
 */
public class Barbero {
    public boolean ocupado;
    public boolean[] sillas = new boolean[50];
  
    public Barbero(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public synchronized void inicioCorte(int numClie) {
        while (isOcupado()) {
            System.out.println("Barbero atendiendo al cliente: " + numClie + ", no puede atender a alguien más. Espere");
            try {
                // con la finalidad de que se pueda representar la concurrencia el hilo bloquea el proceso de las demás hasta que se habilite pormedio de la ejecucion del fin del corte
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setOcupado(true);
        System.out.println("El barbero atiende al cliente: " + numClie);
    }

    public synchronized void finCorte(int numClie) {
        this.setOcupado(false);
        System.out.println("El barbero ha terminado de atender al clietne: " + numClie);
        //libera cualquier posible bloqueo que se realice por medio de otros hilos
        notify();
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
