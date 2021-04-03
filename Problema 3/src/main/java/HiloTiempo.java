/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juare
 */
public class HiloTiempo extends  Thread{
    
    @Override
    public void run(){
        while(Panel.juevoEmpezado){
             try {
                Thread.sleep(25000); 
                Panel.velocidadAparicionNave+=500;
                
                
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }       
        
        
        
        
        
        }
    
        
    }
    
}
