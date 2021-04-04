import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DOER 
 */
public class HiloCola implements Runnable{
    
    ColaProveedorConsumidor cola;
    int numero;
    int probProds;
    public HiloCola(ColaProveedorConsumidor cola, int probProds, int numero) {
        this.cola = cola;
        this.numero = numero;
        this.probProds = probProds;
        
    }

    @Override
    public void run() {
        Random r = new Random();
        int random_number = r.nextInt(101);
        System.out.println("PROD PROB"+this.probProds);
        if(random_number < this.probProds){
            cola.graphInsertar();
            cola.insertar(numero);
        } else {
            cola.graphRemover();
            cola.remover();
        }
        
    }
    
    
    

}