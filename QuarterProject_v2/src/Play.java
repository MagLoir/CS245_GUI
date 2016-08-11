
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/***************************************************************
* file: Play.java
* author: Joseph Gunderson & Magloire Pungi
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v1.0
* date last modified: 8/10/2016
*
* purpose: To Play Hangman
*
****************************************************************/ 

public class Play extends javax.swing.JPanel {

    // randomly generated word to be guessed
    private String randomWord;
    // the string displayed with current successful guesses and unguessed chars
    private String displayWord = "_";
    // a string containing only successfully guessed chars
    private ArrayList<Character> correctChars = new ArrayList<>();
    // keeps track of score
    private static int score;
    // timer for game loop
    private javax.swing.Timer gameTimer;

    /**
     * Creates new form Play
     */
    public Play() {
        
        String[] words = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
        
        initComponents();
        
        // initialize score to 100 at beginning of each play
        score = 100;
       
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
                jLabel2.setText(clock);
                
            }
        };
        
        // set timer to continuously update the clock
        javax.swing.Timer timer = new javax.swing.Timer(100, taskPerformer);
        timer.setRepeats(true);
        timer.start();
        
        // randomly generate word to guess
        Random r = new Random();
        randomWord = words[r.nextInt(words.length)];
        
        // displays blank spaces for word to be guessed
        for(int i=0; i<randomWord.length()-1; ++i)
        {
            displayWord = displayWord + ' ' + '_';
        }

        // updates all display variables
        updateDisplay();
        
        // Game Loop
        ActionListener gameLoop = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //put the switch case here for the picture to update
                switch (score) {
                    case 90:
                    {
                        try {
                            jLabel3.setIcon(new ImageIcon(ImageIO.read( new File("src/images/2.png") ) ));
                        } catch (IOException ex) {
                            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }break;
                    case 80:
                    {
                        try {
                            jLabel3.setIcon(new ImageIcon(ImageIO.read( new File("src/images/3.png") ) ));
                        } catch (IOException ex) {
                            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }break;
                    case 70:
                    {
                        try {
                            jLabel3.setIcon(new ImageIcon(ImageIO.read( new File("src/images/4.png") ) ));
                        } catch (IOException ex) {
                            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }break;
                    case 60:
                    {
                        try {
                            jLabel3.setIcon(new ImageIcon(ImageIO.read( new File("src/images/5.png") ) ));
                        } catch (IOException ex) {
                           Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }break;
                    case 50:
                    {
                        try {
                            jLabel3.setIcon(new ImageIcon(ImageIO.read( new File("src/images/6.png") ) ));
                        } catch (IOException ex) {
                           Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }break;
                    case 40:
                    {
                        try {
                            jLabel3.setIcon(new ImageIcon(ImageIO.read( new File("src/images/7.png") ) ));
                        } catch (IOException ex) {
                            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }break;
                }
                
                // checks for end game scenarios
                if( score <= 40  || didWin())
                {
                    secondGame();
                }
            }
        };
        // set timer to continuously update
        gameTimer = new javax.swing.Timer(100, gameLoop);
        gameTimer.setRepeats(true);
        gameTimer.start();
        
        
        
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
        skip = new javax.swing.JButton();
        c = new javax.swing.JButton();
        b = new javax.swing.JButton();
        a = new javax.swing.JButton();
        e = new javax.swing.JButton();
        f = new javax.swing.JButton();
        g = new javax.swing.JButton();
        h = new javax.swing.JButton();
        i = new javax.swing.JButton();
        l = new javax.swing.JButton();
        v = new javax.swing.JButton();
        w = new javax.swing.JButton();
        u = new javax.swing.JButton();
        k = new javax.swing.JButton();
        j = new javax.swing.JButton();
        d = new javax.swing.JButton();
        m = new javax.swing.JButton();
        n = new javax.swing.JButton();
        o = new javax.swing.JButton();
        p = new javax.swing.JButton();
        q = new javax.swing.JButton();
        r = new javax.swing.JButton();
        x = new javax.swing.JButton();
        y = new javax.swing.JButton();
        s = new javax.swing.JButton();
        t = new javax.swing.JButton();
        z = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        word = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Pristina", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HANGMAN");

        skip.setText("Skip");
        skip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Skip(evt);
            }
        });

        c.setText("C");
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c(evt);
            }
        });

        b.setText("B");
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b(evt);
            }
        });

        a.setText("A");
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a(evt);
            }
        });

        e.setText("E");
        e.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                e(evt);
            }
        });

        f.setText("F");
        f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f(evt);
            }
        });

        g.setText("G");
        g.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                g(evt);
            }
        });

        h.setText("H");
        h.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                h(evt);
            }
        });

        i.setText("I");
        i.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                i(evt);
            }
        });

        l.setText("L");
        l.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l(evt);
            }
        });

        v.setText("V");
        v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                v(evt);
            }
        });

        w.setText("W");
        w.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                w(evt);
            }
        });

        u.setText("U");
        u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                u(evt);
            }
        });

        k.setText("K");
        k.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                k(evt);
            }
        });

        j.setText("J");
        j.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j(evt);
            }
        });

        d.setText("D");
        d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d(evt);
            }
        });

        m.setText("M");
        m.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                M(evt);
            }
        });

        n.setText("N");
        n.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n(evt);
            }
        });

        o.setText("O");
        o.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                o(evt);
            }
        });

        p.setText("P");
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p(evt);
            }
        });

        q.setText("Q");
        q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                q(evt);
            }
        });

        r.setText("R");
        r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r(evt);
            }
        });

        x.setText("X");
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                x(evt);
            }
        });

        y.setText("Y");
        y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                y(evt);
            }
        });

        s.setText("S");
        s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s(evt);
            }
        });

        t.setText("T");
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t(evt);
            }
        });

        z.setText("Z");
        z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Z(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        Score.setBackground(new java.awt.Color(0, 0, 0));
        Score.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Score.setForeground(new java.awt.Color(255, 255, 255));
        Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Score.setText("100");
        Score.setToolTipText("");

        word.setBackground(new java.awt.Color(0, 0, 0));
        word.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        word.setForeground(new java.awt.Color(255, 255, 255));
        word.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(k)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(u)
                                                .addGap(18, 18, 18)
                                                .addComponent(v)
                                                .addGap(18, 18, 18)
                                                .addComponent(w)
                                                .addGap(18, 18, 18)
                                                .addComponent(x)
                                                .addGap(18, 18, 18)
                                                .addComponent(y)
                                                .addGap(18, 18, 18)
                                                .addComponent(z))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(l)
                                                .addGap(18, 18, 18)
                                                .addComponent(m)
                                                .addGap(18, 18, 18)
                                                .addComponent(n)
                                                .addGap(18, 18, 18)
                                                .addComponent(o)
                                                .addGap(18, 18, 18)
                                                .addComponent(p)
                                                .addGap(18, 18, 18)
                                                .addComponent(q)
                                                .addGap(18, 18, 18)
                                                .addComponent(r)
                                                .addGap(10, 10, 10)
                                                .addComponent(s)
                                                .addGap(18, 18, 18)
                                                .addComponent(t))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(word, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(a)
                                            .addGap(18, 18, 18)
                                            .addComponent(b)
                                            .addGap(18, 18, 18)
                                            .addComponent(c)
                                            .addGap(18, 18, 18)
                                            .addComponent(d)
                                            .addGap(18, 18, 18)
                                            .addComponent(e)
                                            .addGap(18, 18, 18)
                                            .addComponent(f)
                                            .addGap(18, 18, 18)
                                            .addComponent(g)
                                            .addGap(18, 18, 18)
                                            .addComponent(h)
                                            .addGap(18, 18, 18)
                                            .addComponent(i)
                                            .addGap(18, 18, 18)
                                            .addComponent(j)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(133, 133, 133)))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 321, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(skip)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(skip))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(word, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a)
                    .addComponent(b)
                    .addComponent(c)
                    .addComponent(d)
                    .addComponent(e)
                    .addComponent(f)
                    .addComponent(g)
                    .addComponent(h)
                    .addComponent(i)
                    .addComponent(j))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l)
                    .addComponent(m)
                    .addComponent(n)
                    .addComponent(o)
                    .addComponent(p)
                    .addComponent(q)
                    .addComponent(r)
                    .addComponent(s)
                    .addComponent(k)
                    .addComponent(t))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u)
                    .addComponent(v)
                    .addComponent(w)
                    .addComponent(x)
                    .addComponent(y)
                    .addComponent(z))
                .addContainerGap())
        );

        Score.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents
    
    
    // updates all display variables
    private void updateDisplay()
    {
        word.setText(displayWord);
        Score.setText(String.valueOf(score));   
    }
    
    // getter for End Screen
    public static int getScore()
    {
        return score;
    }
    
    // returns true if char in randomWord
    private boolean checkWord(char c)
    {
        for(int i=0; i<randomWord.length(); ++i)
        {
            if(c == randomWord.charAt(i))
            {
                return true;
            }
        }
        return false;
    }
    
    // updates display word with correctly guessed character
    private void updateDisplayWord(char c)
    {
        for(int i=0; i<randomWord.length(); ++i)
        {
            if(randomWord.charAt(i) == c)
            {
                // if the last index in the word, insert char at end
                if( i==randomWord.length()-1 )
                {
                    displayWord = displayWord.substring(0,i*2) + c;
                // else insert char in middle of display 
                }else{
                    displayWord = displayWord.substring(0,i*2) + c + " " + displayWord.substring((i+1)*2,displayWord.length());
                }
                
                // add correctly guessed characters to an array
                correctChars.add(c);
            }
        } 
    }
    
    // if parsed string length == randomWord length -> YOU WIN!
    private boolean didWin()
    {
        if(correctChars.size() == randomWord.length())
        {
            return true;
        }
        return false;
    }
    
    //method for the second game
    private void secondGame(){
      
        // stop game loop timer from continuously updating
        gameTimer.stop();
        
        // close current screen and open end game screen
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        JFrame f = new JFrame("Color Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new colorGame());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    // method that ends game
//    private void endGame() {
//        // stop game loop timer from continuously updating
//        gameTimer.stop();
//   
//        // close current screen and open end game screen
//        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
//        frame.dispose();
//        JFrame f = new JFrame("THE END?");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new EndScreen());
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//    }    
    
    
    // if skip button pressed...
    private void Skip(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Skip
        // set score to 0
        score = 0;
    }//GEN-LAST:event_Skip

    private void a(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a
        // disables button after being pressed
        a.setEnabled(false);

        // checks if letter in word
        if ( checkWord('a') )
        {
            updateDisplayWord( 'a' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();        
       
    }//GEN-LAST:event_a

    private void b(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b
        // disables button after being pressed
        b.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('b') )
        {
            updateDisplayWord( 'b' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_b

    private void c(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c
        // disables button after being pressed
        c.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('c') )
        {
            updateDisplayWord( 'c' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_c

    private void d(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d
        // disables button after being pressed
        d.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('d') )
        {
            updateDisplayWord( 'd' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_d

    private void e(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e
        // disables button after being pressed
        e.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('e') )
        {
            updateDisplayWord( 'e' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_e

    private void f(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f
        // disables button after being pressed
        f.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('f') )
        {
            updateDisplayWord( 'f' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_f

    private void g(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_g
        // disables button after being pressed
        g.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('g') )
        {
            updateDisplayWord( 'g' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_g

    private void h(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_h
        // disables button after being pressed
        h.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('h') )
        {
            updateDisplayWord( 'h' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_h

    private void i(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i
        // disables button after being pressed
        i.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('i') )
        {
            updateDisplayWord( 'i' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_i

    private void j(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j
        // disables button after being pressed
        j.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('j') )
        {
            updateDisplayWord( 'j' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_j

    private void k(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_k
        // disables button after being pressed
        k.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('k') )
        {
            updateDisplayWord( 'k' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_k

    private void l(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l
        // disables button after being pressed
        l.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('l') )
        {
            updateDisplayWord( 'l' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_l

    private void n(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n
        // disables button after being pressed
        n.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('n') )
        {
            updateDisplayWord( 'n' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_n

    private void o(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o
        // disables button after being pressed
        o.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('o') )
        {
            updateDisplayWord( 'o' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_o

    private void p(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p
        // disables button after being pressed
        p.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('p') )
        {
            updateDisplayWord( 'p' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_p

    private void q(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_q
        // disables button after being pressed
        q.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('q') )
        {
            updateDisplayWord( 'q' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_q

    private void r(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r
        // disables button after being pressed
        r.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('r') )
        {
            updateDisplayWord( 'r' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_r

    private void s(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s
        // disables button after being pressed
        s.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('s') )
        {
            updateDisplayWord( 's' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_s

    private void t(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t
        // disables button after being pressed
        t.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('t') )
        {
            updateDisplayWord( 't' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_t

    private void u(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_u
        // disables button after being pressed
        u.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('u') )
        {
            updateDisplayWord( 'u' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_u

    private void v(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_v
        // disables button after being pressed
        v.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('v') )
        {
            updateDisplayWord( 'v' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_v

    private void w(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w
        // disables button after being pressed
        w.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('w') )
        {
            updateDisplayWord( 'w' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_w

    private void x(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x
        // disables button after being pressed
        x.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('x') )
        {
            updateDisplayWord( 'x' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_x

    private void y(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_y
        // disables button after being pressed
        y.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('y') )
        {
            updateDisplayWord( 'y' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_y

    private void Z(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Z
        // disables button after being pressed
        z.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('z') )
        {
            updateDisplayWord( 'z' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
    }//GEN-LAST:event_Z

    private void M(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M
        // disables button after being pressed
        m.setEnabled(false);
        
        // checks if letter in word
        if ( checkWord('m') )
        {
            updateDisplayWord( 'm' );
        }
        else{
            score -= 10;
        }
        // updates dispaly variables
        updateDisplay();  
        
    }//GEN-LAST:event_M
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Score;
    private javax.swing.JButton a;
    private javax.swing.JButton b;
    private javax.swing.JButton c;
    private javax.swing.JButton d;
    private javax.swing.JButton e;
    private javax.swing.JButton f;
    private javax.swing.JButton g;
    private javax.swing.JButton h;
    private javax.swing.JButton i;
    private javax.swing.JButton j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton k;
    private javax.swing.JButton l;
    private javax.swing.JButton m;
    private javax.swing.JButton n;
    private javax.swing.JButton o;
    private javax.swing.JButton p;
    private javax.swing.JButton q;
    private javax.swing.JButton r;
    private javax.swing.JButton s;
    private javax.swing.JButton skip;
    private javax.swing.JButton t;
    private javax.swing.JButton u;
    private javax.swing.JButton v;
    private javax.swing.JButton w;
    private javax.swing.JLabel word;
    private javax.swing.JButton x;
    private javax.swing.JButton y;
    private javax.swing.JButton z;
    // End of variables declaration//GEN-END:variables

}





