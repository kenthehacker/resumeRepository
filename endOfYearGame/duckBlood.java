package endOfYearGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class duckBlood {
	int size = 3;
	int x;
	int y;
	double dx;
	double dy;
	Random rand = new Random();
	public duckBlood(int x, int y) {
		double speedX = 0.001;
		int troll = rand.nextInt(10);
		this.x = x+rand.nextInt(40);
		this.dx = speedX;
		this.y = (y + rand.nextInt(50));
		this.dy = 0;
	}
	
	public void spillBlood() {
		this.y = (int)(this.y+this.dy);
		this.dy = this.dy+0.04;
		this.x = (int) (this.dx+this.x);
		/*
		if (Math.abs(this.dx)<0.5) {
			if(this.dx>0) {
				this.dx = this.dx+1.0/rand.nextInt(80);
			}
			else {
				this.dx = this.dx-1.0/rand.nextInt(80);
			}
			
		}
		*/
		
	}
	public void sliceAndDice(Graphics2D win) {
		win.setColor(Color.RED);
		win.fillRect(this.x, this.y, this.size, this.size);
		this.spillBlood();
	}
	public int getY() {
		return this.y;
	}
	
}
