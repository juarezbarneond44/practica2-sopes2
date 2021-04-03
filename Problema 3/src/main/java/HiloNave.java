

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juare
 */
public class HiloNave extends Thread {
   
    int direccion=1;
    boolean cambio=false;
    boolean cambioX=true;
    boolean bajar=false;
    int aumento=0;
@Override
public void run(){
    while(Panel.juevoEmpezado==true){ 
       if(cambio){direccion=3;}
       if(bajar){
            if(cambioX){direccion=1;}
            else{direccion=2;}
            bajar=false;
       }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 35; j++) {
                if(Ventana.naves[i][j]==null){continue;}
                 if(Ventana.naves[i][j].vivo!=true){continue;}
               Ventana.naves[i][j].Bala();
                  
                int posx=Ventana.naves[i][j].getX();// obtenemos la posicion en X
                int posy=Ventana.naves[i][j].getY();// obtenemos la posicion en Y                              
                if(direccion==1){//se mueve a la izquierda
                    int aux=posx-i*40-40;
                    if(aux==0){
                        cambioX=false;
                        cambio=true;
                    }
                      Ventana.naves[i][j].setBounds(posx-40,posy, 40, 20);
                }
                else if (direccion==2){ // se mueve a la derecha
                int aux=posx+(20-i)*40+40;
                    if(aux==1000){
                        cambio=true;
                        cambioX=true;
                    }
                     Ventana.naves[i][j].setBounds(posx+40,posy, 40, 20);
                }
                else if (direccion==3){ // se mueve abajo
                    // bajar un nivel
                    cambio=false;
                    bajar=true;
                    if(posy+20*j>=530){
                    Panel.juevoEmpezado=false;
                    }
                   Ventana.naves[i][j].setBounds(posx,posy+20, 40, 20);
                }
            } 
        }
        try {
        Thread.sleep(1500); 
        }
        catch (InterruptedException e) {
        System.out.println(e);
      }
    }
}
}
