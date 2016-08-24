/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MagloireRaphaelo
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.text.SimpleDateFormat;

class Clock {
    final JLabel time = new JLabel();

     // method: start
    //Purpose: Starts the timer
    public void startClock(){
     

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
                time.setText(clock);
                
            }
        };
         // set timer to continuously update the clock
        javax.swing.Timer timer = new javax.swing.Timer(100, taskPerformer);
        timer.setRepeats(true);
        timer.start();
    }
}