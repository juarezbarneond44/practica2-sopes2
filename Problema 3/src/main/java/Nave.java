
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*; 
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juare
 */
public class Nave extends JButton {
    int vida=2;
    boolean direccion=true; // true== izquierda
    boolean vivo=true;
       public Nave (int posX,int posY){
       setBounds(posX, posY, 40, 20);
       setVisible(true);
        setFocusable(false);
       setBackground(Color.red);
   



    
       
       
       
    }
    
    public void Bala(){
        double probabilidad=Math.random() * (80 - 1+ 1) + 1 ;
        
        if(probabilidad>=3&&probabilidad<4){
           Bala bala=new Bala(getX()+18,getY()+27);
           Panel.panel1.add(bala);
           Ventana.balaNave.push(bala);
           Panel.panel1.updateUI();
           
            
        }
        
    }

   
}

