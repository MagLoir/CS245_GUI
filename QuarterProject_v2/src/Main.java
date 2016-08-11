
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

/***************************************************************
* file: Main.java
* author: Joseph Gunderson & Magloire Pungi
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v1.0
* date last modified: 8/10/2016
*
* purpose: To run this GUI game
*
****************************************************************/ 

public class Main extends JFrame{


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // opens the first page
        final JFrame gui = new JFrame("CS245 Quarter Project");
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
                JFrame second = new JFrame("Main Menu");
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
        


    }
    
}
