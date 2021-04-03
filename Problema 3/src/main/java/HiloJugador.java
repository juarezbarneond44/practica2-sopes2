/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juare
 */
public class HiloJugador extends Thread{
    
    public int letra=0;
    private int tiempoJugador=100;
    @Override
public void run(){
while(Panel.juevoEmpezado){
        System.out.print("");
            switch (letra){
            case 65:   
                if(!Ventana.jugador1.vivo){break;}
               int posx=Ventana.jugador1.getX();
               if(posx==0){break;}
               else{                   
               Ventana.jugador1.setBounds(posx-20, 530, 40, 20);
                    try {
                    Thread.sleep(tiempoJugador); 
                    letra=0;
                    }
                    catch (InterruptedException ee) {
                    System.out.println(ee);
                  }               
               } 
               break;
            case 83:
                 if(!Ventana.jugador1.vivo){break;}
               int balax=Ventana.jugador1.getX();
               int balay=Ventana.jugador1.getY()-20;
               Bala nuevaBala=new Bala(balax+18,balay);
               Panel.panel1.agregarBala(nuevaBala);
               Ventana.balaJugador.push(nuevaBala);
                try {
                    Thread.sleep(tiempoJugador); 
                    letra=0;
                }
                catch (InterruptedException ee) {
                    System.out.println(ee);
                }
               break;
            case 68:   
                 if(!Ventana.jugador1.vivo){break;}
               int posxd=Ventana.jugador1.getX();
               int posxd2=Ventana.jugador2.getX()-40;
               if(posxd>=960){break;}
               else if(posxd2==posxd&& Ventana.jugador2.vivo){break;}
               else{                   
                Ventana.jugador1.setBounds(posxd+20, 530, 40, 20);
                    try {
                    Thread.sleep(tiempoJugador); 
                    letra=0;
                    }
                    catch (InterruptedException ee) {
                    System.out.println(ee);
                  }               
               }     
                break;
            case 74:
                   if(!Ventana.jugador2.vivo){break;}
               int posxj2=Ventana.jugador1.getX()+40;
               int posxj=Ventana.jugador2.getX();
               if(posxj==0){break;}
               else if(posxj==posxj2&& Ventana.jugador1.vivo){break;}
               else{
                 Ventana.jugador2.setBounds(posxj-20, 530, 40, 20);
                    try {
                    Thread.sleep(tiempoJugador); 
                    letra=0;
                    }
                    catch (InterruptedException ee) {
                    System.out.println(ee);
                  } 
               }
                break;
            case 75:
                 if(!Ventana.jugador2.vivo){break;}
               int balax1=Ventana.jugador2.getX();
               int balay1=Ventana.jugador2.getY()-20;
               Bala nuevaBala1=new Bala(balax1+18,balay1);
               Panel.panel1.agregarBala(nuevaBala1);
               Ventana.balaJugador.push(nuevaBala1);
                try {
                    Thread.sleep(tiempoJugador); 
                    letra=0;
                }
                catch (InterruptedException ee) {
                    System.out.println(ee);
                }
                break;
            case 76:
                   if(!Ventana.jugador2.vivo){break;}
                int posx2=Ventana.jugador2.getX();
                    if(posx2>=960){break;}
                    else{                   
                        Ventana.jugador2.setBounds(posx2+20, 530, 40, 20);
                    try {
                    Thread.sleep(tiempoJugador); 
                    letra=0;
                    }
                    catch (InterruptedException ee) {
                    System.out.println(ee);
                  }               
               } 
                break;                
            default:
                letra=0;
                break;
        }
}
}
}
