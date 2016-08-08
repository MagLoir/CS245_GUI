/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MagloireRaphaelo
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

public class PA1test extends JFrame{


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // opens the first page
        JFrame gui = new JFrame("Hangman");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.add(new First_PageImage());
        gui.pack();
        gui.setVisible(true);
        
        // action to open the second page
        
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
                JFrame gui = new JFrame("Hangman");
                gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //change this from EXIT to DISPOSE
                gui.add(new SecondPage());
                gui.pack();
                gui.setVisible(true);
            }
        };

         
        // set timer to perform action after 3 seconds
        Timer timer = new Timer(3000 ,taskPerformer);
        timer.setRepeats(false);
        timer.start();
         
        


    }
    
}
