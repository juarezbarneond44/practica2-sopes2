
import java.awt.Color;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juare
 */
public class Bala extends JButton{
    boolean activo=true;
    public Bala(int x,int y) {
        setVisible(true);
        setBounds(x, y, 5, 7);
        setBackground(Color.black);
        setFocusable(false);
        
        
    }
    
}
