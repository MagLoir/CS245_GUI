
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MagloireRaphaelo
 */
public class Draw extends JPanel{
        Play control;
        public Draw(Play control) {
            this.control = control;
            Border rb = BorderFactory.createRaisedBevelBorder();
            Border lb = BorderFactory.createLoweredBevelBorder();
            Border cmpd = BorderFactory.createCompoundBorder(rb,lb);
            setBorder(cmpd);
            
        }
        
        //drawing different part of the body
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            g.setColor(Color.black);
            g.drawRect(120,100, 10, 180);
            g.drawRect(120, 100, 100, 10);
            g.drawRect(40, 250, 250, 5);
            
            g.setColor(Color.black);
            g.fillRect( 121, 100, 10, 180);
            g.fillRect(121,100, 100, 10);
            g.fillRect(41,250, 250, 5);

            //Draw the head and nose
            if( control.headDrawn ){
                g.setColor(Color.black);
                g.fillRect(215,110,6,15);
                g.setColor(Color.black);
                g.fillOval(200, 120, 30, 30);
            }

            //Draw the body
            if( control.bodyDrawn ){
                g.setColor(Color.black);
                g.drawRect(214, 144, 5, 70);
                g.fillRect(215, 145, 5, 70);
            }

            //Draw the left arm
            if( control.leftArm ){
                g.setColor(Color.black);
                g.drawRect(214, 150, 10, 40);
                g.fillRect(215, 150, 10, 40);
                
            }

            //Draw the right arm
            if( control.rightArm ){
                g.setColor(Color.black);
                g.drawRect(209, 150, 10, 40);
                g.fillRect(210, 150, 10, 40);
            }

            //Draw the left leg
            if( control.leftleg){
                g.setColor(Color.black);
                g.drawRect(209, 170, 10, 50);
                g.fillRect(210, 170, 10, 50);
            }

            //Draw the right leg 
            if( control.rightleg ){
                g.setColor(Color.black);
                g.drawRect(214, 170, 10, 50);
                g.fillRect(215, 170, 10, 50);
            }
        }
}
