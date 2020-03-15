package endOfYearGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class bloodParticle {
	//remember the blood has to squirt right since the arrow shoots left
	int dx;
	double dy;
	int x;
	int y;
	int height= 2;
	int width = height;
	Random rand = new Random();
	public bloodParticle(int x, int y) {
		this.x = x;
		this.y = y;
		this.dx = rand.nextInt(10);
		this.dy = rand.nextInt(20)*0.3;
		
	}
	public void shift() {
		this.x = this.x-this.dx;
		this.dy=this.dy+0.048;
		this.y = (int) (this.y+this.dy);
	}
	
	public void moveAndDrawBlood(Graphics2D win) {
		win.setColor(Color.RED);
		win.fillRect(this.x, this.y, 2*this.width, this.height);
		this.shift();
		//System.out.println("hi");
	}
	
}
