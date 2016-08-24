/***************************************************************
* file: Music.java
* author: Joseph Gunderson & Magloire Pungi
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v1.2
* date last modified: 8/23/2016
*
* purpose: To play music while program running
*
****************************************************************/ 
import javax.sound.sampled.*;

public class Music {

	//getting the music file
	public static Music sound1 = new Music("/lost in.wav");
	
        private Clip clip;
	
        /**
         * method: Music()
         * purpose: create a constructor 
         * @param fileName 
         */
	public Music (String fileName) {
            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(Music.class.getResource(fileName));
                clip = AudioSystem.getClip();
                clip.open(ais);
            } catch (Exception e) {
                e.printStackTrace();
            }
	}
        
        /**
         * method: stop()
         * purpose: to stop the music
         */
	public void stop(){
            if(clip == null) return;
            clip.stop();
	}
	
        /**
         * mehtod: loop()
         * purpose: restart music when song ends
         */ 
         public void loop() {
            try {
                if (clip != null) {
                    new Thread() {
                        public void run() {
                            synchronized (clip) {
                                clip.stop();
                                clip.setFramePosition(0);
                                clip.loop(Clip.LOOP_CONTINUOUSLY);
                            }
                        }
                    }.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
	}
	
        /**
         * method: isAtcive()
         * purpose: return true if active
         */
	public boolean isActive(){
		return clip.isActive();
	}
}