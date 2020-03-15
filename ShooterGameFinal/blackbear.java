import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
public class blackbear extends GameDriverV4{
	SoundDriver blackbear;
	boolean isplay = true;
	int whichsong = 0;
	public blackbear() {
		String[] AP = new String[6];
		AP[0] = "Troll_Song-gkTb9GP9lVI.wav";
		AP[1] = "Punch_Sound_Effect-Tp7sDYEq5vI.wav";
		AP[2] = "blackbear_-_Chateau-Ess0tB2obZo.wav";
		AP[3] = "Logic_-_Fade_Away_Official_Audio-Uf7nGBJOR9I.wav";
		AP[4] = "Machine_Gun_Sound_Effects_3-1yM_CqT-Nvk.wav";
		AP[5] = "fortnite.wav";
		blackbear = new SoundDriver(AP);
		if (isplay == true) {
			blackbear.loop(0);
		}
	}
	public void firstone() {
										//plays the punch soud for now
										//must replace with new sound
		blackbear.play(1);
		
	}
	public void reverse() {
										//pauses and stops the song
		if(isplay == true) {
			isplay = false;
			blackbear.stop(whichsong);
		}
		else {
			isplay = true;
			blackbear.loop(whichsong);
		}
		
	}
	public void soundfive() {
		blackbear.play(5);
	}
	public void soundfour() {
		blackbear.play(4);
	}
	public void soundthree() {
		blackbear.stop(whichsong);
		blackbear.loop(3);
		whichsong = 3;
	}
	public void soundtwo() {
										//stops the og sound and plays the new one
		blackbear.stop(whichsong);
		blackbear.loop(2);
		whichsong = 2;
	}
	public void soundone() {
		blackbear.stop(whichsong);				//plays the og sound
		blackbear.loop(0);
		whichsong = 0;
	}
	
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
