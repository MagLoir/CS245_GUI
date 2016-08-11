/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author MagloireRaphaelo
 */
public class colorGame extends javax.swing.JPanel {

    // timer for game loop
    private javax.swing.Timer gameTimer;
    
     // keeps track of score
    private static int score;
    
    //number of the round
    private static int round;

    
    // randomly generated word to be guessed
    private String randomWord;
    
    // the string displayed with current successful guesses and unguessed chars
    private String displayWord;
    
    //this is for the button and it color
    private static ImageIcon red = new ImageIcon("/*get a picture */");
    private static JButton redButton = new JButton(red);
    private static ImageIcon yellow = new ImageIcon("/*get a picture */");
    private static JButton yellowButton = new JButton(yellow);
    private static ImageIcon green = new ImageIcon("/*get a picture */");
    private static JButton greenButton = new JButton(green);
    private static ImageIcon purple = new ImageIcon("/*get a picture */");
    private static JButton purpleButton = new JButton(purple);
    
    private static String c;
    private static JLabel w = null;
    private static JPanel p;
    
    /**
     * Creates new form colorGame
     */
    public colorGame() {
        
        //string of the color
        String[] words = {"RED", "YELLOW", "GREEN", "PURPLE"};
        
        initComponents();
        
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.add(redButton);
        p.add(yellowButton);
        p.add(greenButton);
        p.add(purpleButton);
        p.setVisible(true);
        
        Random r = new Random();
        randomWord = words[r.nextInt(words.length)];
        
        //set the loop for randomise words
        for(int i= 0; i <randomWord.length(); i++){
            
            int ranPosition = r.nextInt(words.length);
            String t = words[i];
            words[i]= words[ranPosition];
            words[ranPosition]=t;
        }   
        //the index of the wanted color and assign to c
        c = words[0];
        col = new JLabel(c);
        col.setFont(new Font("Arial", Font.PLAIN, 28));
        
        
        
//////        //score
//////        score = 0;
//////        
//////        //number of the round allowed to play
//////        round = 5;
//////        
//////        // randomly generate word to guess
//////        Random r = new Random();
//////        randomWord = words[r.nextInt(words.length)];
//////        
//////        // displays blank spaces for word to be guessed
//////        for(int i=0; i<randomWord.length()-1; ++i)
//////        {
//////            displayWord += ' ';
//////        }
//////        // updates all display variables
//////        updateDisplay();
//////        
//////        //listen to the action and perform a task
//////        ActionListener taskPerformer = new ActionListener() {
//////            @Override
//////            public void actionPerformed(ActionEvent evt) {
//////                // access system's calendar to get clock variables
//////                Calendar cal = new GregorianCalendar();
//////                int month = cal.get(Calendar.MONTH);
//////                int day = cal.get(Calendar.DATE);
//////                int year = cal.get(Calendar.YEAR);
//////                int hour = cal.get(Calendar.HOUR);
//////                int min = cal.get(Calendar.MINUTE);
//////                int seconds = cal.get(Calendar.SECOND);
//////                String clock= month + "/" + day + "/" + year + " " + hour +":"+ min +":"+ seconds ;
//////                clk.setText(clock);
//////                
//////            }
//////        };
//////        
//////        // set timer to continuously update the clock
//////        javax.swing.Timer timer = new javax.swing.Timer(100, taskPerformer);
//////        timer.setRepeats(true);
//////        timer.start();
//////        
//////        
//////        // Game Loop
//////        ActionListener gameLoop = new ActionListener() {
//////            @Override
//////            public void actionPerformed(ActionEvent evt) {
//////                //put the switch case here for the picture to update
//////                switch (round) {
//////                    case 1:
//////                    //implement the game logic here 
//////                    break;
//////                    case 2:
//////                    //implement the game logic here
//////                        break;
//////                    case 3:
//////                    //implement the game logic here
//////                        break;
//////                    case 4:
//////                    //implement the game logic here
//////                        break;
//////                    case 5:
//////                    //implement the game logic here
//////                        break;
//////                    
//////                }
//////                
//////                // checks for end game scenarios
//////                if( round <= 6 )
//////                {
//////                    endGame();
//////                }
//////            }
//////        };
//////        // set timer to continuously update
//////        gameTimer = new javax.swing.Timer(100, gameLoop);
//////        gameTimer.setRepeats(true);
//////        gameTimer.start();
//////        
    }
//////
//////    /**
//////     * This method is called from within the constructor to initialize the form.
//////     * WARNING: Do NOT modify this code. The content of this method is always
//////     * regenerated by the Form Editor.
//////     */
//////    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clk = new javax.swing.JLabel();
        col = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        clk.setBackground(new java.awt.Color(0, 204, 255));
        clk.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        clk.setForeground(new java.awt.Color(255, 255, 255));
        clk.setName("clk"); // NOI18N

        col.setBackground(new java.awt.Color(255, 255, 255));
        col.setForeground(new java.awt.Color(255, 255, 255));
        col.setText("this is where the color will go");
        col.setName("col"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addComponent(clk, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(col, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(col, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        clk.getAccessibleContext().setAccessibleName("clk");
        col.getAccessibleContext().setAccessibleName("col");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clk;
    private javax.swing.JLabel col;
    // End of variables declaration//GEN-END:variables


//    private void endGame() {
////        // stop game loop timer from continuously updating
//        gameTimer.stop();
////   
////        // close current screen and open end game screen
//       JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
//        frame.dispose();
//        JFrame f = new JFrame("THE END?");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new EndScreen());
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//    }    

//   private void updateDisplay()
//    {
//        col.setText(displayWord);
//        //Score.setText(String.valueOf(score));   
//    }
//    


}
