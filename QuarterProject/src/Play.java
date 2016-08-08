
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
import java.awt.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MagloireRaphaelo
 */
public class Play extends javax.swing.JPanel {

    /**
     * Creates new form Play
     */
    public Play() {
        
        String[] words = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
        
        initComponents();
       
        // Display Clock
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
                Calendar cal = new GregorianCalendar();
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DATE);
                int year = cal.get(Calendar.YEAR);
                int hour = cal.get(Calendar.HOUR);
                int min = cal.get(Calendar.MINUTE);
                int seconds = cal.get(Calendar.SECOND);
                String clock= month + "/" + day + "/" + year + " " + hour +":"+ min +":"+ seconds ;
                //String clock= hour +":"+ min +":"+ seconds;
                jLabel2.setText(clock);
            }
        };
        
        // set timer to continuously update
        javax.swing.Timer timer = new javax.swing.Timer(0,taskPerformer);
        timer.setRepeats(true);
        timer.start();
        
        // randomly generate word to guess
        Random r = new Random();
        String randomWord = words[r.nextInt(words.length)];
        word.setText(randomWord);
        
        
        
        
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        word = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Pristina", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HANGMAN");

        jButton1.setText("Skip");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Skip(evt);
            }
        });

        jButton2.setText("C");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C(evt);
            }
        });

        jButton3.setText("B");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B(evt);
            }
        });

        jButton4.setText("A");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A(evt);
            }
        });

        jButton5.setText("E");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E(evt);
            }
        });

        jButton6.setText("F");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F(evt);
            }
        });

        jButton7.setText("G");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G(evt);
            }
        });

        jButton8.setText("H");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H(evt);
            }
        });

        jButton9.setText("I");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                I(evt);
            }
        });

        jButton10.setText("L");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L(evt);
            }
        });

        jButton11.setText("V");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                V(evt);
            }
        });

        jButton12.setText("W");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                W(evt);
            }
        });

        jButton13.setText("U");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                U(evt);
            }
        });

        jButton14.setText("K");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                K(evt);
            }
        });

        jButton15.setText("J");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                J(evt);
            }
        });

        jButton16.setText("D");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D(evt);
            }
        });

        jButton17.setText("M");

        jButton18.setText("N");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                N(evt);
            }
        });

        jButton19.setText("O");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                O(evt);
            }
        });

        jButton20.setText("P");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P(evt);
            }
        });

        jButton21.setText("Q");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q(evt);
            }
        });

        jButton22.setText("R");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                R(evt);
            }
        });

        jButton23.setText("X");
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                X(evt);
            }
        });

        jButton24.setText("Y");
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Y(evt);
            }
        });

        jButton25.setText("S");
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S(evt);
            }
        });

        jButton26.setText("T");
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T(evt);
            }
        });

        jButton27.setText("Z");
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton14)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(jButton13)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton11)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton12)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton23)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton24)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton27))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton10)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton17)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton18)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton19)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton20)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton21)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton22)
                                                .addGap(10, 10, 10)
                                                .addComponent(jButton25)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton26))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(word, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton4)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton3)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton16)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton5)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton6)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton7)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton8)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton9)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton15)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(word, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton16)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(jButton20)
                    .addComponent(jButton21)
                    .addComponent(jButton22)
                    .addComponent(jButton25)
                    .addComponent(jButton14)
                    .addComponent(jButton26))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton23)
                    .addComponent(jButton24)
                    .addComponent(jButton27))
                .addContainerGap())
        );

        Score.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void Skip(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Skip
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        JFrame f = new JFrame("Hangman");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new HighScores());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_Skip

    private void A(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A
        // TODO add your handling code here:
    }//GEN-LAST:event_A

    private void B(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B
        // TODO add your handling code here:
    }//GEN-LAST:event_B

    private void C(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C
        // TODO add your handling code here:
    }//GEN-LAST:event_C

    private void D(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D
        // TODO add your handling code here:
    }//GEN-LAST:event_D

    private void E(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E
        // TODO add your handling code here:
    }//GEN-LAST:event_E

    private void F(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F
        // TODO add your handling code here:
    }//GEN-LAST:event_F

    private void G(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G
        // TODO add your handling code here:
    }//GEN-LAST:event_G

    private void H(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H
        // TODO add your handling code here:
    }//GEN-LAST:event_H

    private void I(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_I
        // TODO add your handling code here:
    }//GEN-LAST:event_I

    private void J(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_J
        // TODO add your handling code here:
    }//GEN-LAST:event_J

    private void K(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_K
        // TODO add your handling code here:
    }//GEN-LAST:event_K

    private void L(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L
        // TODO add your handling code here:
    }//GEN-LAST:event_L

    private void N(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N
        // TODO add your handling code here:
    }//GEN-LAST:event_N

    private void O(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_O
        // TODO add your handling code here:
    }//GEN-LAST:event_O

    private void P(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P
        // TODO add your handling code here:
    }//GEN-LAST:event_P

    private void Q(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q
        // TODO add your handling code here:
    }//GEN-LAST:event_Q

    private void R(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R
        // TODO add your handling code here:
    }//GEN-LAST:event_R

    private void S(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S
        // TODO add your handling code here:
    }//GEN-LAST:event_S

    private void T(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T
        // TODO add your handling code here:
    }//GEN-LAST:event_T

    private void U(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_U
        // TODO add your handling code here:
    }//GEN-LAST:event_U

    private void V(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_V
        // TODO add your handling code here:
    }//GEN-LAST:event_V

    private void W(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_W
        // TODO add your handling code here:
    }//GEN-LAST:event_W

    private void X(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_X
        // TODO add your handling code here:
    }//GEN-LAST:event_X

    private void Y(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Y
        // TODO add your handling code here:
    }//GEN-LAST:event_Y

    private void Z(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Z
        // TODO add your handling code here:
    }//GEN-LAST:event_Z
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Score;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel word;
    // End of variables declaration//GEN-END:variables
}