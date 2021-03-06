
/***************************************************************
* file: ColorGame.java
* author: Joseph Gunderson & Magloire Pungi
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v2.0
* date last modified: 8/22/2016
*
* purpose: To Play Color Match Game
*
****************************************************************/ 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ColorGame extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    private String display;
    private static int round;
    private static int score;
    private static final String[] words = {"RED", "YELLOW", "GREEN", "BLUE","PURPLE"};
    private static String wordColor;
    private final JPanel[] panels = new JPanel[15];
    private final JButton[] buttons = new JButton[5];
    private final javax.swing.Timer gameTimer;
    private final JPanel panel =new JPanel();
    private int[][] buttonPos = new int[5][2];

    //create a panel for the soduku game
    static JPanel sodukuPanel;

     //make button to not have border
    Border emptyBorder = BorderFactory.createEmptyBorder();
    
    /**
     * method: ColorGame()
     * purpose: Creates new form NewJPanel
     */
    public ColorGame() {
        initComponents();
        
        sodukuPanel = new JPanel();
        sodukuPanel.setPreferredSize(new Dimension(600,20));
        
        fillArrays();
        
        // these variables need to get reinitialized with every new game
        round = 1;
        score = Play.getScore();
        
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
        
        Clock.getInputMap().put(KeyStroke.getKeyStroke("F1"),"About");
        Clock.getActionMap().put("About",new AbstractAction() {
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
        Clock.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),"Escape");
        Clock.getActionMap().put("Escape",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Game Loop
        ActionListener gameLoop = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                // checks for end game scenarios
                if( round > 5 )
                {
                    try {
                        endGame();
                    } catch (IOException ex) {
                        Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        // set timer to continuously update
        gameTimer = new javax.swing.Timer(100, gameLoop);
        gameTimer.setRepeats(true);
        gameTimer.start();
        
        // randomize word, word color & button location
        randomize();
        
       this.setLayout(null);
       displayWord.setBounds(0, 0, 190, 43);
       Clock.setBounds(400, 0, 190, 43);
    }

    /**
     * method: initComponents()
     * purpose: This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Clock = new javax.swing.JLabel();
        displayWord = new javax.swing.JLabel();
        yellowButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        redButton = new javax.swing.JButton();
        purpleButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setName("gameColor"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 400));

        Clock.setBackground(new java.awt.Color(153, 204, 255));
        Clock.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("12/32/2088 88:88:88");

        displayWord.setBackground(new java.awt.Color(255, 255, 255));
        displayWord.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        displayWord.setForeground(new java.awt.Color(255, 255, 255));
        displayWord.setText("COLOR");
        displayWord.setName("word"); // NOI18N

        yellowButton.setBackground(new java.awt.Color(0, 0, 0));
        yellowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yellow.png"))); // NOI18N
        yellowButton.setMaximumSize(new java.awt.Dimension(100, 100));
        yellowButton.setMinimumSize(new java.awt.Dimension(100, 100));
        yellowButton.setName("yellow"); // NOI18N
        yellowButton.setPreferredSize(new java.awt.Dimension(100, 100));
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        blueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.png"))); // NOI18N
        blueButton.setMaximumSize(new java.awt.Dimension(100, 100));
        blueButton.setMinimumSize(new java.awt.Dimension(100, 100));
        blueButton.setName("blue"); // NOI18N
        blueButton.setPreferredSize(new java.awt.Dimension(100, 100));
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        redButton.setBackground(new java.awt.Color(0, 0, 0));
        redButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.png"))); // NOI18N
        redButton.setMaximumSize(new java.awt.Dimension(100, 100));
        redButton.setMinimumSize(new java.awt.Dimension(100, 100));
        redButton.setName("red"); // NOI18N
        redButton.setPreferredSize(new java.awt.Dimension(100, 100));
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        purpleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/purple.png"))); // NOI18N
        purpleButton.setMaximumSize(new java.awt.Dimension(100, 100));
        purpleButton.setMinimumSize(new java.awt.Dimension(100, 100));
        purpleButton.setName("purple"); // NOI18N
        purpleButton.setPreferredSize(new java.awt.Dimension(100, 100));
        purpleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purpleButtonActionPerformed(evt);
            }
        });

        greenButton.setBackground(new java.awt.Color(0, 0, 0));
        greenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/green.png"))); // NOI18N
        greenButton.setMaximumSize(new java.awt.Dimension(100, 100));
        greenButton.setMinimumSize(new java.awt.Dimension(100, 100));
        greenButton.setName("green"); // NOI18N
        greenButton.setPreferredSize(new java.awt.Dimension(100, 100));
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayWord, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Clock, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Clock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(68, Short.MAX_VALUE))))
        );

        getAccessibleContext().setAccessibleName("gameColor");
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    //method:greenButtonActionPerfomed(...)
    //purpose: get the action perfomed once the green button is clicked
    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        round++;
        if( "GREEN".equals(wordColor)){
            score += 100;
        }
        randomize();
    }//GEN-LAST:event_greenButtonActionPerformed

    //method:blueButtonActionPerfomed(...)
    //purpose: get the action perfomed once the blue button is clicked
    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        round++;
        if( "BLUE".equals(wordColor)){
            score += 100;
        }
        randomize();
    }//GEN-LAST:event_blueButtonActionPerformed

    //method:redButtonActionPerfomed(...)
    //purpose: get the action perfomed once the red button is clicked
    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        round++;
        if( "RED".equals(wordColor)){
            score += 100;
        }
        randomize();
    }//GEN-LAST:event_redButtonActionPerformed

   //method:yellowButtonActionPerfomed(...)
    //purpose: get the action perfomed once the yellow button is clicked
    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowButtonActionPerformed
        round++;
        if( "YELLOW".equals(wordColor)){
            score += 100;
        }
        randomize();
    }//GEN-LAST:event_yellowButtonActionPerformed

    //method:purpleButtonActionPerfomed(...)
    //purpose: get the action perfomed once the purple button is clicked
    private void purpleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleButtonActionPerformed
        round++;
        if( "MAGENTA".equals(wordColor)){
            score += 100;
        }
        randomize();
    }//GEN-LAST:event_purpleButtonActionPerformed

    //method:endGame()
    //purpose: method that ends game
    private void endGame() throws IOException {
        // stop game loop timer from continuously updating
        gameTimer.stop();
        
        // close current screen and open end game screen
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        //frame.add(panel);
       
        Soduku start = new Soduku();
          start.run();
          frame.dispose();
          
//        JFrame f = new JFrame("Sudoku");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new Soduku());
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
    }    
    //method: getScore()
    //purpose: method that retrieves score from outside java file
    public static int getScore()
    {
        return score;
    }
 
    //method:randomize()
    //purpose:randomize stuff
    public void randomize()
    {
        Random r = new Random();
        display = words[r.nextInt(words.length)];
        displayWord.setText(display);
        
        switch(r.nextInt(words.length)){
            case 0:
                displayWord.setForeground(Color.RED);
                wordColor = "RED";
                break;
            case 1:
                displayWord.setForeground(Color.YELLOW);
                wordColor = "YELLOW";
                break;
            case 2:
                displayWord.setForeground(Color.GREEN);
                wordColor = "GREEN";
                break;
            case 3:
                displayWord.setForeground(Color.BLUE);
                wordColor = "BLUE";
                break;
            case 4:
               displayWord.setForeground(Color.MAGENTA);
               wordColor = "MAGENTA";
               break;
        }
        
        // min X = 0, max X = 600, minY = word.height(), maxY = 400 - 100
        int randX = r.nextInt(600 - 100);
        int randY = r.nextInt(300 - 43) + 43;
        
        // place first button
        this.add(buttons[0]);
        buttons[0].setBounds(randX,randY,100,100);
        buttons[0].setBorder(emptyBorder); 
        
        // save cooridinates
        buttonPos[0][0] = randX; buttonPos[0][1] = randY;
        
       // start placing buttons from next index
       for( int i=1; i<buttons.length; ++i)
       {
            randX = r.nextInt(600 - 100);
            randY = r.nextInt(300 - 43) + 43;
            buttonPos[i][0] = randX; buttonPos[i][1] = randY;
                    
            // check against all buttons already placed
            for( int j=i-1; j>=0; --j )
            {
                // continue pulling numbers while collision with any button
                while(collision(i,j))
                {
                    // if it has collided with another button after already clearing
                    // a previous button -> recheck all other numbers
                    if( j<i+1 )
                    {
                        j = i-1;
                    }
                    
                    randX = r.nextInt(600 - 100);
                    randY = r.nextInt(300 - 43) + 43;
                    buttonPos[i][0] = randX; buttonPos[i][1] = randY;
                }
            }
            
            // finally you can add the button
            this.add(buttons[i]);
            buttons[i].setBounds(randX,randY,100,100);
            buttons[i].setBorder(emptyBorder);       
       }
       
    }
    
    // checks for collision
    private Boolean collision(int i, int j)
    {   
        // if they share the same x its okay, but same x & y means overlap
        if( (Math.abs(buttonPos[i][0]-buttonPos[j][0]) < buttons[j].getWidth()+10) 
                && (Math.abs(buttonPos[i][1]-buttonPos[j][1]) < buttons[j].getHeight()+10) )
        {
            return true;
        }
        return false;
    }
    
    
    //method:fillArrays()
    //purpose: fills arays with respective panels and buttons
    private void fillArrays()
    {   
        buttons[0] = blueButton;
        buttons[1] = yellowButton;
        buttons[2] = purpleButton;
        buttons[3] = greenButton;
        buttons[4] = redButton;
        
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JButton blueButton;
    private static javax.swing.JLabel displayWord;
    private javax.swing.JButton greenButton;
    private javax.swing.JButton purpleButton;
    private javax.swing.JButton redButton;
    private javax.swing.JButton yellowButton;
    // End of variables declaration//GEN-END:variables
}
