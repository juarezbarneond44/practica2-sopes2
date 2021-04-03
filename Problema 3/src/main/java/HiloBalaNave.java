
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juare
 */
public class HiloBalaNave extends Thread{
    @Override
public void run(){
try{
    while(Panel.juevoEmpezado){
        for (Bala bala :  Ventana.balaNave) {
            if(!bala.activo){continue;}
            int aux=bala.getY()+20;
            if(aux>600){bala.activo=false;bala.setVisible(false);bala.setEnabled(false);}
            // si toca una nave le baja vida y desaparece
            bala.setBounds(bala.getX(), aux, 5, 7);
            golpearJugador(bala);
        }
        try {
        Thread.sleep(200);
        }
        catch (InterruptedException e) {
        System.out.println(e);
      }
    }
} 
catch (Error e) {
        System.out.println(e);
      }
}
 private void golpearJugador(Bala bala){
    int posx1=Ventana.jugador1.getX();
    int posx2=Ventana.jugador2.getX();
    int posxB=bala.getX();
     int posyB=bala.getY();
    //ver si golpea a jugador1
      if(posx1<=posxB && posx1+40>=posxB &&posyB>=530){
      
         Ventana.jugador1.vida--;
         bala.activo=false;bala.setVisible(false);bala.setEnabled(false);
         if(Ventana.jugador1.vida==0){
            Ventana.jugador1.vivo=false;
            Ventana.jugador1.setVisible(false); 
                if(!Ventana.jugador2.vivo){
                Panel.juevoEmpezado=false;
                JOptionPane.showMessageDialog(null, "Perdiste!!!  Juego terminado has matado:"+(Ventana.totalNaves-Ventana.navesVivas)+" Naves.");
            }
         }
   
      }else if(posx2<=posxB && posx2+40>=posxB&&posyB>=530){
         Ventana.jugador2.vida--;
         bala.activo=false;bala.setVisible(false);bala.setEnabled(false);
         if(Ventana.jugador2.vida==0){
            Ventana.jugador2.vivo=false;
            Ventana.jugador2.setVisible(false); 
            if(!Ventana.jugador1.vivo){
                Panel.juevoEmpezado=false;
                JOptionPane.showMessageDialog(null, "Perdiste!!!  Juego terminado has matado:"+(Ventana.totalNaves-Ventana.navesVivas)+" Naves.");
            }
         }
      }  
        Panel.panel1.updateUI();
        
     
     
     
   }



    
}
