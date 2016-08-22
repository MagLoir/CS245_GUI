/***************************************************************
* file: Sudoku.java
* author: Joseph Gunderson & Magloire Pungi
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v1.0
* date last modified: 8/21/2016
*
* purpose: To Play Sudoku
*
****************************************************************/ 

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

class Soduku extends JPanel {
    
    //label
    private static JLabel label;
    //main panel
    private static JPanel panel;
    //panel of where the clock will be display
    private static JPanel clockPanel;
    //panel where everything will be display
    private static JPanel mainPanel;
    //submit button
    private static JButton submit;
    //the quit button
    private static JButton quit;
    //create frame name Soduku
    private static JFrame frame = new JFrame("Soduku");
    //to keep the score
    private static int score;
    //calling the clock class for printing the clock
    private Clock c = new Clock();
    //create a rectangle to display the board
    private Rectangle rec = new Rectangle();
    // current game board
    private int[][] board = new int[9][9];
    // correctly filled game board
    private int[][] answers = new int[9][9];
    // ensures incorrect answers only counted once
    private Boolean[][] wrongAnswer = new Boolean[9][9];
    // track sudo score seperately from cumulative score of all games
    int sudokuScore;
    // number of cells in sudoku board
    private static int size=81;
    // create a text format for inputing the integer
    private static JFormattedTextField[] tf;
    
    //index in the soduku
    private static int[] index={0,3,5,8,15,19,24,25,27,29,31,33,34,40,46,47,
                                49,51,53,55,56,61,65,72,75,77,80};
    private static int[] givenNumber={8,4,6,7,4,1,6,5,5,9,3,7,8,7,4,8,2,1,3,
                                      5,2,9,1,3,9,2,5};

    
    public void run() throws IOException{
        rec.setSize(30, 30);
        Soduku();
    }

    private void initVariables()
    {
        sudokuScore = 540; // total possible points for sudoku
        fillBoard();
        // initializes boolean 2D array to false
        for(Boolean[] row : wrongAnswer)
        {
            Arrays.fill(row, false);
        }
        

    }
    

    
    public void Soduku() {  
        // initialize all variables
        score = ColorGame.getScore();
        fillAnswers();
        initVariables();
        
        // create panels
        panel = new JPanel();
        mainPanel = new JPanel(new BorderLayout(3,3));
        clockPanel = new JPanel();
        
        // create buttons
        quit = new JButton("Quit");
        submit = new JButton("Submit");
        quit.setToolTipText("Click to end the game");
        submit.setToolTipText("Click to check solution");
        
        // create labels
        label= new JLabel("Soduku");
        label.setText("Soduku");
        label.setFont(new Font("Bradley Hand ITC", Font.BOLD,27));
        label.setBounds(30,10, 130, 30);
        label.setForeground(Color.white);
        panel.add(label);
        //label.setVisible(true);
        
        //set the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setVisible(true);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((screenSize.width-600)/2, (screenSize.height-400)/2, 600, 400);
        frame.getContentPane().setBackground(Color.BLACK);
        
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBorder(new EmptyBorder(1,1,1,1));
        
        panel.setPreferredSize(new Dimension(600,380));
        clockPanel.setFont(new Font("Arial", Font.PLAIN, 20));
        clockPanel.setForeground(Color.white);
        clockPanel.setPreferredSize(new Dimension(600,20));
        clockPanel.setBackground(Color.WHITE);
        
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.add(quit);
        panel.add(submit);
        
        clockPanel.add(c.time);
        c.startClock();
        
        panel.setVisible(true);
        clockPanel.setVisible(true); 
        mainPanel.add(panel,BorderLayout.CENTER);
        mainPanel.add(clockPanel, BorderLayout.NORTH);
        
        //this will help us to have the dialog box show up everytime
        //you press F1 or ESCAPE
        frame.add(mainPanel);
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
        
        // this is what happens when you press the quit button
         quit.setBounds(470,300,90,30);
         quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                quit(ev);
            }
             
         });
         // this is what happens when you press the submit button
         submit.setBounds(470,270,90,30);
         submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                submit(ev);
            }   
         });
         
         paint();
    }
    
    
    // returns true if not a default index
    private Boolean notDefault(int n)
    {

        for(int i=0; i<index.length; ++i)
        {
            if( n == index[i])
            {
                return false;
            }
        }
        return true;
    }
    
    // method that places red border around incorrect cells
    private void incorrectCells()
    {
        for(int i=0; i<board.length; ++i)
        {
            for(int j=0; j<board[i].length; ++j)
            {
                //convert 2D array index to 1D array index
                int index = (i*9)+j;
                
                if(notDefault(index))
                {
                    // if cell of current board does not equal cell in answer key
                    if(board[i][j] != answers[i][j])
                    {
                        tf[index].setBorder(BorderFactory.createLineBorder
                                            (Color.red));
                    }
                    // else border should not be red
                    else{
                        tf[index].setBorder(BorderFactory.createBevelBorder
                                            (BevelBorder.LOWERED));
                    }
                }
            }
        }
    }
    
    
    // returns false if game board does not match answer key
    private Boolean notWin()
    {
        for(int i=0; i<board.length; ++i)
        {
            for(int j=0; j<board[i].length; ++j)
            {
                // if cell of current board does not equel cell in answer key
                if(board[i][j] != answers[i][j])
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    // opens a dialog box with score {incorrect cells only calculated once)
    // if correct, navigate to End Screen
    // if incorrect, show which cells are wrong
    private void submit(java.awt.event.ActionEvent evt) {                      

        evaluate();        
        incorrectCells();
        
        // if you didn't complete sudoku board, display message
        if(notWin())
        {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, 
                    "Your solution is incorrect. "+
                    "Please, try again or quit the game", "Submit",
                    JOptionPane.PLAIN_MESSAGE);
        }
        // if you did complete the sudoku board, display winning message && exit
        else{
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, 
                    "Your solution is correct !! ", "Submit",
                    JOptionPane.PLAIN_MESSAGE);
            
            gameOver();
        }
    }  
    
    // method that ends game
    private void gameOver()
    {
        // add sudoku score to total score
        score = score + sudokuScore;
        
        // dispose of current frame and move to end
        frame.dispose();
        JFrame f = new JFrame("THE END?");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new EndScreen());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        // set back to defaults before leaving
        initVariables();
        
    }
    
    
    // disposes of main menu (current screen) and navigates to end page
    private void quit(java.awt.event.ActionEvent evt) { 
        // evaluate sudoku score
        evaluate();
        // end game shtuff
        gameOver();
        
    }  

    
    // method that calculates score of submitted sudoku board vs solution board
    private void evaluate()
    {   
        // get text from text field && fill current board
        for(int index=0; index<size; ++index)
        {
            String s = tf[index].getText();
            // if content in text field
            if( s.length() > 0 )
            {
                // convert 1D index into 2D index
                int i = index/9;
                int j = index - (i*9);
                board[i][j] = Integer.parseInt( s );
            }
        }
        
        // check current board vs solution board
        for(int i=0; i<board.length; ++i)
        {
            for(int j=0; j<board[i].length; ++j)
            {
                // if cell of current board does not equal cell in answer key
                if(board[i][j] != answers[i][j])
                {
                    // && it hasn't already been incorrectly guessed before
                    if(wrongAnswer[i][j] != true)
                    {
                        sudokuScore -= 10;
                        wrongAnswer[i][j] = true;
                    }
                }
            }
        }
        
    }
   
    
    //method: getScore()
    //purpose: method that retrieves score from outside java file
    public static int getScore()
    {
        return score;
    }
        
        
    // method that initializes Sudoku 2D array with starting numbers
    private void fillBoard()
    {
        try{
            BufferedReader in = new BufferedReader(new FileReader("Default.txt"));
            
            int i=0;
            int j=0;
            // .read() reads by each char, returns -1 when reaches end
            int c = in.read();
            while( c != -1 )
            {
                // if char is not newLine character or carriage return
                if( c != 10 && c != 13)
                {
                    // cast back to integer && insert into 2D array
                    board[i][j] = Character.getNumericValue(c);
                    
                    // go to next row if counter reaches end of column
                    if(j == 8)
                    {
                        j = 0;
                        ++i;
                    }
                    else{
                        ++j;
                    }
                }    
                
                // read next line
                c = in.read();
                
            }
            in.close();
        }catch (IOException ex) 
        {
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    // method that fill 2D array with all sudoku answers
    private void fillAnswers()
    {
        try{
            BufferedReader in = new BufferedReader(new FileReader("Solution.txt"));
            
            int i=0;
            int j=0;
            // .read() reads by each char, returns -1 when reaches end
            int c = in.read();
            while( c != -1 )

            {
                // if char is not newLine character or carriage return
                if( c != 10 && c != 13)
                {
                    // cast back to integer && insert into 2D array
                    answers[i][j] = Character.getNumericValue(c);
                    
                    // go to next row if counter reaches end of column
                    if(j == 8)
                    {
                        j = 0;
                        ++i;
                    }
                    else{
                        ++j;
                    }
                }    
                
                // read next line
                c = in.read();
                
            }
            in.close();
        }catch (IOException ex) 
        {
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, 
                                null, ex);
        } 
    }

    // displays the sudoku board
    private void paint() {
        
        //create the textfield which will only accept integers
        //it won't recognize the input incase it's not a single digit integer
        NumberFormat nf = NumberFormat.getInstance();
        tf = new JFormattedTextField[size];
        nf.setMaximumIntegerDigits(1);
        
         //make a textfield that is tempory and then store it 
            //in each index fot the original text field
        for(int i=0; i<size; i++){
            JFormattedTextField ftf= new JFormattedTextField(nf);
            ftf.setBounds(rec);
            tf[i]=ftf;
        }
        
        //set the location the board in x and y
        int x = 100;
        int y = 60;
        //count how many the boxes are they and help to input the number
        int count = 0;
        int pos=0;
        
        //this loop helps to display the given indexes and its location they are
        //in the loop and use the texfield format to let the user enter their
        //input.
        for(int i =0; i<9; i++){
            for(int j = 0;j<9;j++){
                
                if(count==index[pos]){
                    tf[count].setLocation(x,y);
                    tf[count].setText(Integer.toString(givenNumber[pos]));
                    tf[count].setEditable(false);
                    panel.add(tf[count]);
                    tf[count].setVisible(true);
                    x+=30;
                    pos++;
                    count++;
                }
                else{
                    tf[count].setLocation(x,y);
                    //tf[count].setText(null);
                    panel.add(tf[count]);
                    tf[count].setVisible(true);
                    x+=30;
                    count++;
                }
                
            }
            y+=30;
            x=100;
        }
        
    }
    
    
    // method that generically prints 2D array
    private <T> void print(T[][] array)
    {
        for(T[] row : array)
        {
            for(T i : row)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // method that prints integer 2D array
    private void print(int[][] array)
    {
        for(int[] row : array)
        {
            for(int i : row)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
}
