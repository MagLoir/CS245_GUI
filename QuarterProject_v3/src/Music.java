//package Magloire.sound;

import javax.sound.sampled.*;

public class Music {
	
	private Clip clip;
	
	// Change file name to match yours, of course
	public static Music sound1 = new Music("/lost in.wav");
	//public static Sound sound2 = new Sound("/sound2.wav");
	//public static Sound sound3 = new Sound("/sound3.wav");
	
	public Music (String fileName) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(Music.class.getResource(fileName));
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.setFramePosition(0);
							clip.start();
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		if(clip == null) return;
		clip.stop();
	}
	
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
	
	public boolean isActive(){
		return clip.isActive();
	}
}