
import javax.swing.JOptionPane;






public class HiloBalaJugador extends Thread{
@Override
public void run(){
    while(Panel.juevoEmpezado){
        for (Bala bala :  Ventana.balaJugador) {
            if(!bala.activo){continue;}
            int aux=bala.getY()-20;
            if(aux<0){bala.activo=false;bala.setVisible(false);bala.setEnabled(false);}
            // si toca una nave le baja vida y desaparece
            bala.setBounds(bala.getX(), aux, 5, 7);
            golpearNave(bala);
        }
        try {
        Thread.sleep(200);
        }
        catch (InterruptedException e) {
        System.out.println(e);
      }
    }
}
 private void golpearNave(Bala bala){
    for (int i = 0; i < 20; i++) {
        for (int j = 0; j < 35; j++) {
            Nave nave=Ventana.naves[i][j];
            if(nave==null){continue;}
            if(!nave.vivo){continue;}
            int auxX= nave.getX();
            int auxY= nave.getY();
            int balaX=bala.getX();
            int balaY=bala.getY();
            if(auxX<=balaX && auxX+40>=balaX&&auxY>balaY && auxY-20<=balaY){
                bala.activo=false;bala.setVisible(false);bala.setEnabled(false);
                nave.vida--;
                if(nave.vida==0){
                   nave.vivo=false;
                   nave.setVisible(false);
                   Panel.panel1.updateUI();
                   Ventana.navesVivas--;
                   if(Ventana.navesVivas==0){Panel.juevoEmpezado=false;
                   JOptionPane.showMessageDialog(null, "Ganaste!!!  Juego terminado has matado:"+Ventana.totalNaves+" Naves.");
                 
                   }
                }
            }
         }
      }
   }
}
