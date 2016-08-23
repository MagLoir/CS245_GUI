
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/***************************************************************
* file: HighScores.java
* author: Joseph Gunderson & Magloire Pungi
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v1.0
* date last modified: 8/11/2016
*
* purpose: Lists highest 5 scores
*
****************************************************************/ 

public class HighScores extends javax.swing.JPanel {

    /**
     * Creates new form HighScores
     */
    public HighScores() {
        
        initComponents();
        
        // Store High Scores in an Array of Arrays
        ArrayList<ArrayList<String>> highScores = loadHighScores();
        
        // Display High Scores as long as there are high scores to read
        if(highScores != null)
        {
            displayHighScores(highScores);
        }
        
        jLabel1.getInputMap().put(KeyStroke.getKeyStroke("F1"),"About");
        jLabel1.getActionMap().put("About",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                    "Joseph Gunderson, Bronco # 010978760 \n Magloire Pungi, "
                            + "Bronco # 009947405" +"\nQuarter Project "
                            + "\nSummer 2016 ", "Info",
                            JOptionPane.PLAIN_MESSAGE);
            }
        });
        // this is what happens when you press escape
        jLabel1.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),"Escape");
        jLabel1.getActionMap().put("Escape",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        jButton1.setToolTipText("Back to main Menu");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstPlace = new javax.swing.JLabel();
        secondPlace = new javax.swing.JLabel();
        thirdPlace = new javax.swing.JLabel();
        fourthPlace = new javax.swing.JLabel();
        fifthPlace = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        firstPlaceScore = new javax.swing.JLabel();
        secondPlaceScore = new javax.swing.JLabel();
        thirdPlaceScore = new javax.swing.JLabel();
        fourthPlaceScore = new javax.swing.JLabel();
        fifthPlaceScore = new javax.swing.JLabel();
        firstPlaceScore1 = new javax.swing.JLabel();
        firstPlaceScore2 = new javax.swing.JLabel();
        firstPlaceScore3 = new javax.swing.JLabel();
        firstPlaceScore4 = new javax.swing.JLabel();
        firstPlaceScore5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HIGHSCORES");

        firstPlace.setBackground(new java.awt.Color(255, 255, 255));
        firstPlace.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        firstPlace.setForeground(new java.awt.Color(255, 255, 255));
        firstPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstPlace.setText("ABC");

        secondPlace.setBackground(new java.awt.Color(255, 255, 255));
        secondPlace.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        secondPlace.setForeground(new java.awt.Color(255, 255, 255));
        secondPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondPlace.setText("ABC");

        thirdPlace.setBackground(new java.awt.Color(255, 255, 255));
        thirdPlace.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        thirdPlace.setForeground(new java.awt.Color(255, 255, 255));
        thirdPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirdPlace.setText("ABC");

        fourthPlace.setBackground(new java.awt.Color(255, 255, 255));
        fourthPlace.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        fourthPlace.setForeground(new java.awt.Color(255, 255, 255));
        fourthPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourthPlace.setText("ABC");

        fifthPlace.setBackground(new java.awt.Color(255, 255, 255));
        fifthPlace.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        fifthPlace.setForeground(new java.awt.Color(255, 255, 255));
        fifthPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifthPlace.setText("ABC");

        jButton1.setFont(new java.awt.Font("Algerian", 2, 11)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back(evt);
            }
        });

        firstPlaceScore.setBackground(new java.awt.Color(255, 255, 255));
        firstPlaceScore.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        firstPlaceScore.setForeground(new java.awt.Color(255, 255, 255));
        firstPlaceScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        firstPlaceScore.setText("00000");

        secondPlaceScore.setBackground(new java.awt.Color(255, 255, 255));
        secondPlaceScore.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        secondPlaceScore.setForeground(new java.awt.Color(255, 255, 255));
        secondPlaceScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        secondPlaceScore.setText("00000");

        thirdPlaceScore.setBackground(new java.awt.Color(255, 255, 255));
        thirdPlaceScore.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        thirdPlaceScore.setForeground(new java.awt.Color(255, 255, 255));
        thirdPlaceScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        thirdPlaceScore.setText("00000");

        fourthPlaceScore.setBackground(new java.awt.Color(255, 255, 255));
        fourthPlaceScore.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        fourthPlaceScore.setForeground(new java.awt.Color(255, 255, 255));
        fourthPlaceScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fourthPlaceScore.setText("00000");

        fifthPlaceScore.setBackground(new java.awt.Color(255, 255, 255));
        fifthPlaceScore.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        fifthPlaceScore.setForeground(new java.awt.Color(255, 255, 255));
        fifthPlaceScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fifthPlaceScore.setText("00000");

        firstPlaceScore1.setBackground(new java.awt.Color(255, 255, 255));
        firstPlaceScore1.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        firstPlaceScore1.setForeground(new java.awt.Color(255, 255, 255));
        firstPlaceScore1.setText("....................................");

        firstPlaceScore2.setBackground(new java.awt.Color(255, 255, 255));
        firstPlaceScore2.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        firstPlaceScore2.setForeground(new java.awt.Color(255, 255, 255));
        firstPlaceScore2.setText("....................................");

        firstPlaceScore3.setBackground(new java.awt.Color(255, 255, 255));
        firstPlaceScore3.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        firstPlaceScore3.setForeground(new java.awt.Color(255, 255, 255));
        firstPlaceScore3.setText("....................................");

        firstPlaceScore4.setBackground(new java.awt.Color(255, 255, 255));
        firstPlaceScore4.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        firstPlaceScore4.setForeground(new java.awt.Color(255, 255, 255));
        firstPlaceScore4.setText("....................................");

        firstPlaceScore5.setBackground(new java.awt.Color(255, 255, 255));
        firstPlaceScore5.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        firstPlaceScore5.setForeground(new java.awt.Color(255, 255, 255));
        firstPlaceScore5.setText("....................................");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(secondPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thirdPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fifthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fourthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstPlaceScore1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstPlaceScore2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(firstPlaceScore3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstPlaceScore4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(firstPlaceScore5, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fifthPlaceScore, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(fourthPlaceScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thirdPlaceScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(secondPlaceScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstPlaceScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(148, 148, 148))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstPlace)
                            .addComponent(firstPlaceScore1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thirdPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourthPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fifthPlace))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstPlaceScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(secondPlaceScore)
                                    .addComponent(firstPlaceScore2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirdPlaceScore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fourthPlaceScore))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(firstPlaceScore3)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(firstPlaceScore4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fifthPlaceScore)
                            .addComponent(firstPlaceScore5))))
                .addGap(62, 62, 62)
                .addComponent(jButton1)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // reads from a file and returns a 2D array
    private ArrayList<ArrayList<String>> loadHighScores()
    {
        ArrayList<ArrayList<String>> highScores = new ArrayList<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader("Top5.txt"));
            String s = in.readLine();
            
            // check if file empty
            if(s == null)
            {
                System.out.println("FILE EMPTY");
                
            }
            else{
                int i=0;
                while(s != null)
                {   
                    // parse string by space and add to 2D Array
                    String[] str = s.split("\\s+"); 
                    highScores.add(new ArrayList<String>());
                    highScores.get(i).add(str[0]);
                    highScores.get(i).add(str[1]);
                    
                    // read next line
                    s = in.readLine();
                    ++i;
                }
            }
            in.close();
        }catch (IOException ex) 
        {
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
        return highScores;
    }
    
    
    // Sets text of high scores into their appropriate JLabels
    private void displayHighScores(ArrayList<ArrayList<String>> aa)
    {
        firstPlace.setText(aa.get(0).get(0));
        firstPlaceScore.setText(aa.get(0).get(1));
        secondPlace.setText(aa.get(1).get(0));
        secondPlaceScore.setText(aa.get(1).get(1));
        thirdPlace.setText(aa.get(2).get(0));
        thirdPlaceScore.setText(aa.get(2).get(1));
        fourthPlace.setText(aa.get(3).get(0));
        fourthPlaceScore.setText(aa.get(3).get(1));
        fifthPlace.setText(aa.get(4).get(0));
        fifthPlaceScore.setText(aa.get(4).get(1));
    }
    
    
    private void Back(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back
        // Dispose of current screen and open hangman main menu
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        JFrame f = new JFrame("Main Menu");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new SecondPage());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_Back


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fifthPlace;
    private javax.swing.JLabel fifthPlaceScore;
    private javax.swing.JLabel firstPlace;
    private javax.swing.JLabel firstPlaceScore;
    private javax.swing.JLabel firstPlaceScore1;
    private javax.swing.JLabel firstPlaceScore2;
    private javax.swing.JLabel firstPlaceScore3;
    private javax.swing.JLabel firstPlaceScore4;
    private javax.swing.JLabel firstPlaceScore5;
    private javax.swing.JLabel fourthPlace;
    private javax.swing.JLabel fourthPlaceScore;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel secondPlace;
    private javax.swing.JLabel secondPlaceScore;
    private javax.swing.JLabel thirdPlace;
    private javax.swing.JLabel thirdPlaceScore;
    // End of variables declaration//GEN-END:variables
}
