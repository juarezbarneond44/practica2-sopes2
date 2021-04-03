
import java.awt.Color;
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
public class Jugador extends JButton{
    int vida=3;
    boolean vivo=true;
   

    public Jugador(int x,Color pintura) {
    setBounds(x, 530, 40, 20);
    setFocusable(false);
    setBackground(pintura);

    }
   

}
