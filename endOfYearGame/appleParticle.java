package endOfYearGame;

import java.awt.Graphics2D;
import java.util.Random;
import java.awt.Color;

public class appleParticle {
	double dx;
	double dy;
	int x;
	int y;
	int height = 5;
	int width = height;
	Random rand = new Random();
	public appleParticle(int x, int y) {
		this.dx = 0;
		this.dy = 0.0 - rand.nextInt(4);
		this.x = x;
		this.y = y;
	}
	
	public void shift() {
		this.x = (int)(this.x-this.dx);
		if(this.dx<2) {
			this.dx = this.dx+1.0/rand.nextInt(50);
		}
		this.dy = this.dy+0.048;
		this.y = (int) (this.y+this.dy);
		//System.out.println("bye");
	}
	
	public void moveAndDrawApple(Graphics2D win) {
		Color col = new Color(255,218,185);
		win.setColor(col);
		win.fillRect(this.x, this.y, this.width, this.height);
		this.shift();
		//System.out.println("hi");
	}
	
}
