
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juare
 */
public class Ventana extends JPanel{
 
 //    private URL url = getClass().getResource("https://img.unocero.com/2020/10/nasa-sonidos-espacio-halloween-1200x600.jpg");
//    Image image = new ImageIcon(url).getImage();
    // @Override
   // public void paint(Graphics g){
      ////  g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
       // g.setOpaque(False);
  //   //   super.paint(g);
  ///  }    
    
    
    public static  Jugador jugador1=new Jugador(260,Color.BLUE);
    public static  Jugador jugador2=new Jugador(760,Color.GREEN);
    public static  Nave naves[][]=new Nave[20][35];
    public static int totalNaves=60;
    public static int navesVivas=60;
    public static LinkedList<Bala> balaJugador = new LinkedList<Bala>();
    public static LinkedList<Bala> balaNave = new LinkedList<Bala>();
    
    
    public Ventana (){
       
        
        addKeyListener(new movJugador1());
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
       
       setLayout(null);
        setBounds(0,0,1012,600);
       // setResizable(false);
        setVisible(true);
        llenarNaves();
  
        
       
        setFocusable(true);
        
        
       add(this.jugador1);
       add(this.jugador2);
       add(new JLabel());
        

    }
    public void llenarNaves(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 20; j++) {
             Nave aux=new Nave(120+40*j,0+20*i);
                naves[j][i]=aux;
               add(aux);
            }
        }
    
    }
    public void agregarBala(Bala dato){
    add(dato);
    updateUI();
    }
private class movJugador1 extends KeyAdapter {
    boolean tiempo=true;
    public void keyPressed(KeyEvent e) {
    //System.out.println( e.getKeyCode());
       // message = "Key Pressed: " + e.getKeyCode();
         int key= e.getKeyCode();
        // System.out.println(key);
        Panel.hilojugador1.letra=key;
       
    }
}
}
