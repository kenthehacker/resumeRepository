package endOfYearGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class duck {
	int x;
	int y;
	int size = 50;
	int speedX;
	double speedY;
	int start;
	int dir = 1;
	//range of speedY should be 10
	Random rand = new Random();
	ArrayList<duckBlood> bloodyHell;
	public duck() {
		this.x = 0-rand.nextInt(1000);
		this.y = 10+rand.nextInt(280);
		this.start = this.y;
		this.speedX = 1;
		bloodyHell = new ArrayList<duckBlood>();
	}
	public void shift() {
		this.x = this.x+this.speedX;
	}
	
	public void moveDuck(Graphics2D win) {
		win.setColor(Color.black);
		//win.fillRect(this.x, this.y, 2*this.size, this.size);
		for (int i = 0; i<bloodyHell.size(); i++) {
			bloodyHell.get(i).sliceAndDice(win);
			if (bloodyHell.get(i).getY()>=600) {
				bloodyHell.remove(i);
				i--;
				System.out.println(i);
			}
			
		}
		this.shift();
	}
	public int getX() {
		return (int)this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getHeight() {
		return this.size;
	}
	public int getWidth() {
		return 2*this.size;
	}
	public void bleed(Graphics2D win) {
		for (int i = 0; i<80; i++) {
			bloodyHell.add(new duckBlood(this.x+this.size, this.y));
		}
	}
}
