package endOfYearGame;

import java.awt.Graphics2D;

public class soundStuff extends GameDriverV4{
	SoundDriver soundStuff;
	boolean isplay = true;
	int whichsong = 0;
	public soundStuff() {
		String[] vinylRecord = new String[3];
		vinylRecord[0] = "REEEEEE_Sound_Effect--HtNaVFpw4Q.wav";
		vinylRecord[1] = "Peter_Griffin_hits_his_knee_Family_Guy_Season_2_Episode_20-TEZQ2rg-Rlg.3.wav";
		vinylRecord[2] = "Big_Smoke_Moan_-_SOUND_EFFECT-00Fwk5az_sY.wav";
		soundStuff = new SoundDriver(vinylRecord);
	}
	public void playRhee() {
		this.soundStuff.play(0);
	}
	public void playPeter() {
		this.soundStuff.play(1);
	}
	public void playMoan() {
		this.soundStuff.play(2);
	}
	
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}
	
}
