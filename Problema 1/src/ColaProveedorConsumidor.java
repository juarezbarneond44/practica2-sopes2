import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DOER 
 */
public class ColaProveedorConsumidor{
    
    
    private int max;
    private int cola[] ;
    
    private CentroAcopio ca;
    
    // concurrencia
    private ReentrantLock bloqueo = new ReentrantLock();
    private Condition estaVacio = bloqueo.newCondition();
    private Condition estaLleno = bloqueo.newCondition();

    public int getMax() {
        return max;
    }

    public int [] getCola() {
        return cola;
    }
    
    
    public ColaProveedorConsumidor(int max,CentroAcopio ca) {
        this.ca = ca;
        this.max = max;
        this.cola = new int[max];
        for(int i=0;i<max;i++){
            this.cola[i]=0;
        }
    }
    
    public void graphInsertar(){
        try {
            ca.getLblLlego().setText("Productor");
            ca.updateBodega(this);
            ca.setnProductores(ca.getnProductores()+1);
            ca.updateProductores();
            try{
                Thread.sleep(2000);                
            }catch(Exception E){
            System.out.println("8");

            }
        } catch (Exception ex) {
            Logger.getLogger(ColaProveedorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void degraphInsertar(){
        ca.setnProductores(ca.getnProductores()-1);
        ca.setnProductoresTotal(ca.getnProductoresTotal()+1);
        int nContador = ca.getnConsumidoresTotal() +ca.getnProductoresTotal();
        ca.getLblContador().setText("Atendidos: "+nContador+"/100");

        ca.updateProductores();
    }
    public void graphRemover(){
        try {
            ca.getLblLlego().setText("Consumidor");
            ca.updateBodega(this);
            ca.setnConsumidores(ca.getnConsumidores()+1);
            ca.updateConsumidores();

            try{
                Thread.sleep(2000);                
            }catch(Exception E){
            System.out.println("7");

            }

            
        } catch (Exception ex) {
            Logger.getLogger(ColaProveedorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void degraphRemover(){
        ca.setnConsumidoresTotal(ca.getnConsumidoresTotal()+1);
        ca.setnConsumidores(ca.getnConsumidores()-1);
        int nContador = ca.getnConsumidoresTotal() +ca.getnProductoresTotal();
        ca.getLblContador().setText("Atendidos: "+nContador+"/100");

        ca.updateConsumidores();
    }
    
    public void insertar(int val){
        bloqueo.lock();
        
        try {
            
            while(cola[max-1] != 0){
                estaLleno.await(); // -> 4 productores esperando
            }
            // ---> 4 continuan
            int indexDisponible=0;
            for(int i=0;i<cola.length ;i++ ){
                if(cola[i]==0){
                    indexDisponible=i;
                    break;
                }
                
            }
            cola[indexDisponible]=1;
            this.degraphInsertar();
            System.out.println("INSERT " + indexDisponible + " - " + val);
                   
            estaVacio.signalAll();  // -> 1 productor insertó
            
            //noVacio.signal();
 
        } catch (Exception e) {
            System.out.println("6");
            e.printStackTrace();

        } finally {
            bloqueo.unlock();

        }
    }
    
    public void remover(){
        try {
            bloqueo.lock();

            while(cola[0]==0){
                estaVacio.await();  // -> 3 consumidores esprando
            }
            System.out.println("COLA ");
            for(int i=0;i<cola.length;i++){
                System.out.print(cola[i]);
            }

            int indiceAVaciar=max-1;
            for(int i=max-1;i>=0;i--){
                if(this.cola[i]==1){
                    indiceAVaciar=i;
                    this.cola[indiceAVaciar]=0;
                    break;
                }
            }
            
            System.out.println("ELIMINO en" + indiceAVaciar + " - " + this.cola[indiceAVaciar]);
            this.degraphRemover();
            estaLleno.signal();  // -> Libere 2 
            //noLleno.signalAll();  // -> Libere 2 
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("5");
            return;

        } finally {
            bloqueo.unlock();

        }
    }
    
    public void print(){
        for (int i = 0; i < this.max; i++) {
            System.out.println( "Se insertó en : [" +i + "] - valor : " +  cola[i]);
            
        }
    }
    
    

}
