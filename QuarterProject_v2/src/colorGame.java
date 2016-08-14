
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MagloireRaphaelo
 */
public class colorGame extends javax.swing.JPanel {

    int[] setColor = {1,2,3,4,5};
    private String randomWord;
    private String display;
    private static int round;
    private static int score;
            
    
    /**
     * Creates new form colorGame
     */
    public colorGame() {
        initComponents();
        
        // Display Clock
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // access system's calendar to get clock variables
                Calendar cal = new GregorianCalendar();
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DATE);
                int year = cal.get(Calendar.YEAR);
                int hour = cal.get(Calendar.HOUR);
                int min = cal.get(Calendar.MINUTE);
                int seconds = cal.get(Calendar.SECOND);
                String clock= month + "/" + day + "/" + year + " " + hour +":"+ min +":"+ seconds ;
                Clock.setText(clock);
                
            }
        };
         // set timer to continuously update the clock
        javax.swing.Timer timer = new javax.swing.Timer(100, taskPerformer);
        timer.setRepeats(true);
        timer.start();
        
        //define the color words
        String[] words = {"RED", "YELLOW", "GREEN", "BLUE","PURPLE"};
        
        //create random word generator
        Random r = new Random();
        randomWord = words[r.nextInt(words.length)];
        //set the loop for randomise words
        for(int i= 0; i <randomWord.length(); i++){
            
            int ranPosition = r.nextInt(words.length);
            String t = words[i];
            words[i]= words[ranPosition];
           words[ranPosition]=t;
        } 
        
        //this will assign the word with a randomize color
        display = words[0];
        wordColor.setText(display);
        
        for (int i =0; i<setColor.length; i++){
        int ranPosition = r.nextInt(setColor.length);
        int t = setColor[i];
        setColor[i]= setColor[ranPosition];
        setColor[ranPosition]= t;
        }
        
        switch(setColor[0]){
            case 1:
                display = words[0];
                wordColor.setText(display);
                wordColor.setForeground(Color.RED);
                break;
            case 2:
                display = words[0];
                wordColor.setText(display);
                wordColor.setForeground(Color.YELLOW);
                break;
            case 3:
                display = words[0];
                wordColor.setText(display);
                wordColor.setForeground(Color.GREEN);
                break;
            case 4:
                display = words[0];
                wordColor.setText(display);
                wordColor.setForeground(Color.BLUE);
                break;
            case 5:
                //getting purple
               display = words[0];
                wordColor.setText(display);
                //wordColor.setForeground(new Color(255,0,255));
               wordColor.setForeground(Color.MAGENTA);
               break;
        }
        updatePosition();   
        
//        //get the action perform for each button
//        round=0;
//        
//        redButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//               round++;
//               wordColor.setVisible(false);
//               if(setColor[0] == 1){
//                   score = score + 100;}
//               endGame();
//           } 
//        });
//        yellowButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//               round++;
//               wordColor.setVisible(false);
//               if(setColor[0] == 1){
//                   score = score + 100;}
//               endGame();
//           } 
//        });
//        greenButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//               round++;
//               wordColor.setVisible(false);
//               if(setColor[0] == 1){
//                   score = score + 100;}
//               endGame();
//           } 
//        });
//        blueButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//               round++;
//               wordColor.setVisible(false);
//               if(setColor[0] == 1){
//                   score = score + 100;}
//               endGame();
//           } 
//        });
//        purpleButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//               round++;
//               wordColor.setVisible(false);
//               if(setColor[0] == 1){
//                   score = score + 100;}
//               endGame();
//           } 
//        });
        
    }
    
    //this method will be update the positon of the button everytime
    //a new round start
    public void updatePosition(){
        Random ran = new Random();
        int[] array = {1,2,3,4,5};
        int size =5;
        for(int i = 0; i< array.length; i++){
            int ranPosition = ran.nextInt(array.length);
            int t= array[i];
            array[i]= array[ranPosition];
            array[ranPosition]= t;
        }
        for(int i = 0; i<array.length; i++){
            switch(array[i]){
                case 1:
                    button();
                    break;
                case 2:
                    button();
                    break;
                case 3:
                    button();
                    break;
                case 4:
                    button();
                    break;
                case 5:
                    button();
                    break;                    
            }
            size--;
        }
        
    }

    //this method is will identifying the button click
    //this method will identify the button and set bounds for them. 
    //it is called by updatePosition()
    public void button(){
        //int[] array = {1,2,3,4,5};
        int size =5; 
        switch(size){
                case 5:
                    redButton.setBounds(10,100,100,100);
                    break;
                case 4:
                    yellowButton.setBounds(10,100,100,100);
                    break;
                case 3:
                    greenButton.setBounds(10,100,100,100);
                    break;
                case 2:
                    blueButton.setBounds(10,100,100,100);
                    break;
                case 1:
                    purpleButton.setBounds(10,100,100,100);
                    break;               
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Clock = new javax.swing.JLabel();
        wordColor = new javax.swing.JLabel();
        blueButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        purpleButton = new javax.swing.JButton();
        redButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        Clock.setBackground(new java.awt.Color(0, 153, 255));
        Clock.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setName("clock"); // NOI18N

        wordColor.setBackground(new java.awt.Color(255, 255, 255));
        wordColor.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        wordColor.setText("text");
        wordColor.setName("word"); // NOI18N

        blueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.png"))); // NOI18N
        blueButton.setName("blue"); // NOI18N
        blueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blueButtonMouseClicked(evt);
            }
        });
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        yellowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yellow.png"))); // NOI18N
        yellowButton.setName("yellow"); // NOI18N
        yellowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yellowButtonMouseClicked(evt);
            }
        });
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        greenButton.setBackground(new java.awt.Color(0, 0, 0));
        greenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/green.png"))); // NOI18N
        greenButton.setName("green"); // NOI18N
        greenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                greenButtonMouseClicked(evt);
            }
        });
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        purpleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/purple.png"))); // NOI18N
        purpleButton.setName("purple"); // NOI18N
        purpleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purpleButtonMouseClicked(evt);
            }
        });
        purpleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purpleButtonActionPerformed(evt);
            }
        });

        redButton.setBackground(new java.awt.Color(0, 0, 0));
        redButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.png"))); // NOI18N
        redButton.setName("red"); // NOI18N
        redButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redButtonMouseClicked(evt);
            }
        });
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wordColor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Clock, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(106, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(180, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 83, Short.MAX_VALUE)
                        .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Clock, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wordColor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))))))
        );

        Clock.getAccessibleContext().setAccessibleName("clock");
        wordColor.getAccessibleContext().setAccessibleName("");
        blueButton.getAccessibleContext().setAccessibleName("blue");
        yellowButton.getAccessibleContext().setAccessibleName("yellow");
        greenButton.getAccessibleContext().setAccessibleName("green");
        purpleButton.getAccessibleContext().setAccessibleName("purple");
        redButton.getAccessibleContext().setAccessibleName("red");
    }// </editor-fold>//GEN-END:initComponents

    private void blueButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blueButtonMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_blueButtonMouseClicked

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        // TODO add your handling code here:
        round = 0;
               round++;
               wordColor.setVisible(false);
               if(setColor[0] == 1){
                   score = score + 100;}
               endGame();
           
    }//GEN-LAST:event_blueButtonActionPerformed

    private void yellowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yellowButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_yellowButtonMouseClicked

    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowButtonActionPerformed
        // TODO add your handling code here:
        round = 0;
        round++;
               wordColor.setVisible(false);
               if(setColor[0] == 1){
                   score = score + 100;}
               endGame();
    }//GEN-LAST:event_yellowButtonActionPerformed

    private void greenButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_greenButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_greenButtonMouseClicked

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        // TODO add your handling code here:
        round = 0;
        round++;
               wordColor.setVisible(false);
               if(setColor[0] == 1){
                   score = score + 100;}
               endGame();
    }//GEN-LAST:event_greenButtonActionPerformed

    private void purpleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purpleButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_purpleButtonMouseClicked

    private void purpleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleButtonActionPerformed
        // TODO add your handling code here:
        round = 0;
        round++;
               wordColor.setVisible(false);
               if(setColor[0] == 1){
                   score = score + 100;}
               endGame();
    }//GEN-LAST:event_purpleButtonActionPerformed

    private void redButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_redButtonMouseClicked

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        // TODO add your handling code here:
        round = 0;
        round++;
               wordColor.setVisible(false);
               if(setColor[0] == 1){
                   score = score + 100;}
               endGame();
    }//GEN-LAST:event_redButtonActionPerformed

    public void endGame(){
//        if(round<5){
//            updatePosition();
//        }
//        else{
//            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
//        frame.dispose();
//        JFrame f = new JFrame("THE END?");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new HighScores());
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private static javax.swing.JButton blueButton;
    private static javax.swing.JButton greenButton;
    private static javax.swing.JButton purpleButton;
    private static javax.swing.JButton redButton;
    private static javax.swing.JLabel wordColor;
    private static javax.swing.JButton yellowButton;
    // End of variables declaration//GEN-END:variables
}
