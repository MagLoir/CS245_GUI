/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa1test;

/**
 *
 * @author MagloireRaphaelo
 */
import java.awt.*;
import javax.swing.*;

public class PA1test extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private ImageIcon image;
    private JLabel label;
    PA1test(){
        setLayout(new FlowLayout());
        image = new ImageIcon(getClass().getResource("milkyway.jpg"));
        label = new JLabel(image);
        add(label);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PA1test gui = new PA1test();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Imagetest");
    }
    
}
