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
import javax.swing.*;
import javax.swing.border.*;

class Soduku extends JPanel {
      
    private static JPanel panel;
    static JPanel clockPanel;
    static JPanel mainPanel;
    static JButton checkSolution;
    static JButton end;
    static JButton quit;
    static JFrame frame = new JFrame("Soduku");
    static int score = ColorGame.getScore();
    Clock c = new Clock();
    Rectangle r = new Rectangle();
    int count = 0;
    
    static int rounds;
    
    public void run() throws IOException{
        r.setSize(30, 30);
        Soduku();
    }

    public void Soduku() {
        rounds = 0;
        panel = new JPanel();
        mainPanel = new JPanel(new BorderLayout(3,3));
        clockPanel = new JPanel();
        
        checkSolution = new JButton("Solution");
        quit = new JButton("Quit");
        end = new JButton("End");
        checkSolution.setToolTipText("Click to check solution");
        quit.setToolTipText("Click to end the game");
        end.setToolTipText("Click to go back to menu");
        
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
                    "\nQuarter Project \n Summer 2016 ",
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
         quit.setBounds(10,300,130,30);
         checkSolution.setBounds(10,270,130,30);
    }
    
}
