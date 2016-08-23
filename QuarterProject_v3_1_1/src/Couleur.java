/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MagloireRaphaelo
 */
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;


public class Couleur extends JPanel{
    private String display;
    private static int round;
    private static int score;
    private static final String[] words = {"RED", "YELLOW", "GREEN", "BLUE","PURPLE"};
    private static String wordColor;
    private final JButton[] buttons = new JButton[5];
    private static JPanel clockPanel;
    private Clock c = new Clock();
    private static JPanel panel;
    private static JPanel mainPanel;
    private static JFrame frame= new JFrame("Color Game");
    static JPanel sodukuPanel;
    private static javax.swing.Timer gameTimer;
    static JLabel displayWord;
    private int[][] buttonPos = new int[5][2];

    //creating the button and its images
    static ImageIcon red = new ImageIcon("src\\images\\red1.png");
    static JButton redButton = new JButton (red);
    
    static ImageIcon yellow = new ImageIcon("src\\images\\yellow1.png");
    static JButton yellowButton = new JButton (yellow);
    
    static ImageIcon green = new ImageIcon("src\\images\\green1.png");
    static JButton greenButton = new JButton (green);
    static ImageIcon blue = new ImageIcon("src\\images\\blue1.png");
    static JButton blueButton = new JButton (blue);
    static ImageIcon purple = new ImageIcon("src\\images\\purple1.png");
    static JButton purpleButton = new JButton (purple);
    
    //make button to not have border
    Border emptyBorder = BorderFactory.createEmptyBorder();
    
    
    public void run(){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try {
                    Couleur();
                } catch (IOException ex) {
                    Logger.getLogger(Couleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }
    
    void Couleur() throws IOException{
        score = Play.getScore();
        // create panels
        panel = new JPanel();
        mainPanel = new JPanel(new BorderLayout(3,3));
        clockPanel = new JPanel();

        //set the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setVisible(true);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((screenSize.width-600)/2, (screenSize.height-400)/2, 600, 400);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBorder(new EmptyBorder(1,1,1,1));
        
        panel.setPreferredSize(new Dimension(600,380));
        clockPanel.setPreferredSize(new Dimension(100,20));
        clockPanel.setFont(new Font("Arial", Font.PLAIN, 20));
        clockPanel.setForeground(Color.white);
        clockPanel.setBackground(Color.WHITE);
        clockPanel.add(c.time);
        c.startClock();
        
        
        panel.setBackground(Color.BLACK);
        panel.setVisible(true);
        clockPanel.setVisible(true); 
        mainPanel.add(panel,BorderLayout.CENTER);
        mainPanel.add(clockPanel, BorderLayout.NORTH);
        frame.add(mainPanel);
        
        panel.setLayout(null);
                
        //this will help us to have the dialog box show up everytime
        //you press F1 or ESCAPE
        mainPanel.getInputMap().put(KeyStroke.getKeyStroke("F1"),"About");
        mainPanel.getActionMap().put("About",new AbstractAction() {
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
        mainPanel.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),"Escape");
        mainPanel.getActionMap().put("Escape",new AbstractAction() {
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
                if( round > 4 )
                {
                    try {
                        endGame();
                    } catch (IOException ex) {
                        Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        gameTimer = new javax.swing.Timer(100, gameLoop);
        gameTimer.setRepeats(true);
        gameTimer.start();
        
        initComponents();
        
        fillArrays();
        
        randomize();
    }
    
    void endGame() throws IOException{
        
        gameTimer.stop();
        
        JFrame f = (JFrame) SwingUtilities.getWindowAncestor(this);
        Soduku start = new Soduku();
          start.run();
          
          f.dispose();
    }

    void initComponents(){
          
        //to display the word
        displayWord= new JLabel("word");
        displayWord.setFont(new Font("Arial",Font.PLAIN, 36));
        displayWord.setBounds(30,10, 200, 30);
        displayWord.setForeground(Color.white);
        panel.add(displayWord);
       
        //initializing the button with an action listener
        redButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                round++;
                if( "RED".equals(wordColor)){
                    score += 100;
                }
                randomize();
            }
        });
        yellowButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                round++;
                if( "YELLOW".equals(wordColor)){
                    score += 100;
                }
                randomize();
            }
        });
        greenButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                round++;
                if( "GREEN".equals(wordColor)){
                    score += 100;
                }
                randomize();
            }
        });
        blueButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                round++;
                if( "BLUE".equals(wordColor)){
                    score += 100;
                }
                randomize();
            }
        });
        purpleButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                round++;
                if( "PURPLE".equals(wordColor)){
                    score += 100;
                }
                randomize();
            }
        });
             
    }
    
    //method: getScore()
    //purpose: method that retrieves score from outside java file
    public static int getScore(){
        return score;
    }
    
    //method:randomize()
    //purpose:randomize stuff
    void randomize(){
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
        
        int randX = r.nextInt(600 - 100);
        int randY = r.nextInt(200 - 23) + 23;
        
        // place first button
        panel.add(buttons[0]);
        buttons[0].setBounds(randX,randY,100,100);
        buttons[0].setBorder(emptyBorder);
        
        // save cooridinates
        buttonPos[0][0] = randX; buttonPos[0][1] = randY;
        
       // start placing buttons from next index
       for( int i=1; i<buttons.length; ++i)
       {
            randX = r.nextInt(600 - 100);
            randY = r.nextInt(200 - 23) + 23;
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
                    randY = r.nextInt(200 - 23) + 23;
                    buttonPos[i][0] = randX; buttonPos[i][1] = randY;
                }
            }
            
            // finally you can add the button
            panel.add(buttons[i]);
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
 
      
}
