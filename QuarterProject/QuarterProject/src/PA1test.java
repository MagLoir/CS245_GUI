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
        final JFrame gui = new JFrame("Hangman");
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.add(new First_PageImage());
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        
        // closes current window and opens hangman game window
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
                JFrame second = new JFrame("Hangman");
                second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //change this from EXIT to DISPOSE
                second.add(new SecondPage());
                second.pack();
                second.setLocationRelativeTo(null);
                second.setVisible(true);
                gui.dispose();
            }
        }; 
        
        // set timer to perform action after 3 seconds
        Timer timer = new Timer(1000 ,taskPerformer);
        timer.setRepeats(false);
        timer.start();
        


    }
    
}
