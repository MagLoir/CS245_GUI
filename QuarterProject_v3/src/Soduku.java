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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

class Soduku extends JPanel {
    
    private static JLabel label;
    private static JPanel panel;
    private static JPanel clockPanel;
    private static JPanel mainPanel;
    private static JButton checkSolution;
    private static JButton end;
    private static JButton quit;
    private static JFrame frame = new JFrame("Soduku");
    private static int score = ColorGame.getScore();
    private Clock c = new Clock();
    private Rectangle rec = new Rectangle();
    private int count = 0;
    private int[][] board = new int[9][9];
    private int[][] answers = new int[9][9];
    int[] boardSolution = {8,3,5,4,1,6,9,2,7,2,9,6,8,5,7,4,3,1,4,1,7,2,9,3,6,5,8,
                           5,6,9,1,3,4,7,8,2,1,2,3,6,7,8,5,4,9,7,4,8,5,2,9,1,6,3,
                           6,5,2,7,8,1,3,9,4,9,8,1,3,4,5,2,7,6,3,7,4,9,6,2,8,1,5};

    private static int size=81;
    
    private static JPanel EndScreen;
    private static int rounds;
    
    public void run() throws IOException{
        rec.setSize(30, 30);
        Soduku();
    }

    public void Soduku() {
        
        EndScreen = new JPanel();
        EndScreen.setPreferredSize(new Dimension(600,20));
        
        fillBoard();
        fillAnswers();
        
        print(board);
        System.out.println();
        print(answers);
        evaluate();
        
        rounds = 0;
        panel = new JPanel();
        mainPanel = new JPanel(new BorderLayout(3,3));
        clockPanel = new JPanel();
        
        checkSolution = new JButton("Submit");
        quit = new JButton("Quit");
        end = new JButton("End");
        checkSolution.setToolTipText("Click to check solution");
        quit.setToolTipText("Click to end the game");
        end.setToolTipText("Click to go back to menu");
        
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
        panel.add(checkSolution);
        
        clockPanel.add(c.time);
        c.startClock();
        
        panel.setVisible(true);
        clockPanel.setVisible(true); 
        mainPanel.add(panel,BorderLayout.CENTER);
        mainPanel.add(clockPanel, BorderLayout.NORTH);
        
        //this will help us to have the dialog box show up everytime
        //you press F1 or ESCAPE
        frame.add(mainPanel);
        mainPanel.getInputMap().put(KeyStroke.getKeyStroke("F1"),
                            "doSomething");
        mainPanel.getActionMap().put("doSomething",
                             new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                    "Joseph Gunderson, Bronco # 010978760 \n Magloire Pungi, Bronco # 009947405" +
                    "\nQuarter Project \nSummer 2016 ",
                    "Info",
                    JOptionPane.PLAIN_MESSAGE);
            }
        });
        mainPanel.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),
                            "Escape");
        mainPanel.getActionMap().put("Escape",
                             new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        //need to add an action listner for both buttons
         quit.setBounds(420,300,130,30);
         quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                panel.setVisible (false);
                updateScore();
            }
             
         });
         checkSolution.setBounds(420,270,130,30);
         checkSolution.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                rounds++;
                if(/*verify()||*/ rounds==1){
                      panel.setVisible(false);
                      updateScore();
                }
                else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, 
                            "Your solution is incorrect. "+
                            "Please, try again or quit the game"+ 
                            JOptionPane.PLAIN_MESSAGE);
                }
            }   
         });
         
         piant();
    }
    
    void updateScore(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        JFrame f = new JFrame("THE END?");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new EndScreen());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
//    boolean verify(){
//        
//        return 
//    }
    // method that calculates score of submitted sudoku board vs solution board
    private void evaluate()
    {
        int sudokuScore = 540; // total possible points for sudoku
        for(int i=0; i<board.length; ++i)
        {
            for(int j=0; j<board[i].length; ++j)
            {
                if(board[i][j] != answers[i][j])
                {
                    sudokuScore -= 10;
                }
            }
        }
        
        System.out.println("Your Score is: " + sudokuScore);
    }
    
    // method that prints 2D array
    private void print(int[][] array)
    {
        //set the location
        int x = 170; int y =60;
        
        //int[] missing = {0,3,5,8,15,19,24,};
        
        fillBoard();
        for(int[] row : array)
        {
            for(int i : row)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    
    
    // method that initializes Sudoku 2D array with starting numbers
    private void fillBoard()
    {
        board[0][0] = 8;
        board[0][3] = 4;
        board[0][5] = 6;
        board[0][8] = 7;
        board[1][6] = 4;
        board[2][1] = 1;
        board[2][6] = 6;
        board[2][7] = 5;
        board[3][0] = 5;
        board[3][2] = 9;
        board[3][4] = 3;
        board[3][6] = 7;
        board[3][7] = 8;
        board[4][4] = 7;
        board[5][1] = 4;
        board[5][2] = 8;
        board[5][4] = 2;
        board[5][6] = 1;
        board[5][8] = 3;
        board[6][1] = 5;
        board[6][2] = 2;
        board[6][7] = 9;
        board[7][2] = 1;
        board[8][0] = 3;
        board[8][3] = 9;
        board[8][5] = 2;
        board[8][8] = 5;
        
        
        
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
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void piant() {
        
        //create the textfield
        NumberFormat nf = NumberFormat.getInstance();
        JFormattedTextField[] tf = new JFormattedTextField[size];
        nf.setMaximumIntegerDigits(1);
        for(int i=0; i<size; i++){
            JFormattedTextField ftf= new JFormattedTextField(nf);
            ftf.setBounds(rec);
            tf[i]=ftf;
        }
        
        int x = 100;
        int y = 60;
        int count = 0;
        int preCount=0;
        //index in the soduku
        int[] index={0,3,5,8,15,19,24,25,27,29,31,33,34,40,46,47,49,51,53,55,56,
                     61,65,72,75,77,80};
        int[] givenNumber={8,4,6,7,4,1,6,5,5,9,3,7,8,7,4,8,2,1,3,5,2,9,1,3,9,2,5};
        for(int i =0; i<9; i++){
            for(int j = 0;j<9;j++){
                if(count==index[preCount]){
                    tf[count].setLocation(x,y);
                    tf[count].setText(Integer.toString(givenNumber[preCount]));
                    tf[count].setEditable(false);
                    panel.add(tf[count]);
                    tf[count].setVisible(true);
                    x+=30;
                    preCount++;
                    count++;
                }
                else{
                    tf[count].setLocation(x,y);
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
    
}
