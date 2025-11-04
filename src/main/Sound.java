package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30]; 
	FloatControl fc;
	int volumeScale = 3;
	float volume; 
	
	public Sound() {
		soundURL[0] = getClass().getResource("/sound/MoonField.wav");
		soundURL[1] = getClass().getResource("/sound/Coin.wav");
		soundURL[2] = getClass().getResource("/sound/Powerup.wav");
		soundURL[3] = getClass().getResource("/sound/Unlock.wav");
		soundURL[4] = getClass().getResource("/sound/Fanfare.wav");
		soundURL[5] = getClass().getResource("/sound/HitMonster.wav");
		soundURL[6] = getClass().getResource("/sound/ReceiveDamage.wav");
		soundURL[7] = getClass().getResource("/sound/Parry.wav");
		soundURL[8] = getClass().getResource("/sound/LevelUp.wav");
		soundURL[9] = getClass().getResource("/sound/Cursor.wav");
		soundURL[10] = getClass().getResource("/sound/Plasmaball.wav");
		soundURL[11] = getClass().getResource("/sound/CutTree.wav");
		soundURL[12] = getClass().getResource("/sound/GameOver.wav");
		soundURL[13] = getClass().getResource("/sound/Stairs.wav");
		soundURL[14] = getClass().getResource("/sound/Sleep.wav");
		soundURL[15] = getClass().getResource("/sound/Blocked.wav");
		soundURL[16] = getClass().getResource("/sound/Speak.wav");
		soundURL[17] = getClass().getResource("/sound/Bell.wav");
		soundURL[18] = getClass().getResource("/sound/Dungeon.wav");
		soundURL[19] = getClass().getResource("/sound/Chip_Wall.wav");
		soundURL[20] = getClass().getResource("/sound/Door_Open.wav");
		soundURL[21] = getClass().getResource("/sound/Boss.wav");
		soundURL[22] = getClass().getResource("/sound/Trader.wav");
		soundURL[23] = getClass().getResource("/sound/Snow.wav");
		soundURL[24] = getClass().getResource("/sound/Birds.wav");
		soundURL[25] = getClass().getResource("/sound/Valley.wav");
	}
	
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			checkVolume();
		} catch(Exception e) {
			
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void checkVolume() {
		switch (volumeScale) {
		case 0: volume = -80f; break;
		case 1: volume = -20f; break;
		case 2: volume = -12f; break;
		case 3: volume = -5f; break;
		case 4: volume = 1f; break;
		case 5: volume = 6f; break;
		}
		fc.setValue(volume);
	}
}
