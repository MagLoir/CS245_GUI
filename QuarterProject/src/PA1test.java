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
        //gui.dispose();
        
//        final JFrame splashScreen = new JFrame("Hangman");
//        splashScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        
//        ActionListener taskP = new ActionListener(){
//          public void actionPerformed(ActionEvent e){
//              
//        splashScreen.add(new First_PageImage());
//        splashScreen.pack();
//        splashScreen.setVisible(true);
//              splashScreen.dispose();
//          }  
//        };
        // action to open the second page    
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
        Timer timer = new Timer(3000 ,taskPerformer);
        timer.setRepeats(false);
        timer.start();
        //gui.setVisible(false);
        


    }
    
}
