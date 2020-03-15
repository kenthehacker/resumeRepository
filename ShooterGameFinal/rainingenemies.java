import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class rainingenemies extends Rectangle{
	float alpha = 0.1f;
	float alpha2 = 1.0f;
	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	AlphaComposite bc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);
	Rectangle rain;
	int lives = 1;
	Random ken = new Random();
	int xloc = ken.nextInt(800);
	int yloc = 0;
	public rainingenemies() {
		this.setSize(50,50);
		Random ken = new Random();
		int xloc = ken.nextInt(800);
		this.setLocation(xloc, yloc);
	}
	
	public void fall(Graphics2D win) {
		Random randospeed = new Random();
		int yspeed = randospeed.nextInt(10);
		
		this.translate(0, yspeed);
		win.setComposite(ac);
		win.setColor(Color.pink);
		win.fill(this);
		win.setComposite(bc);
	}
	public void tick() {
		yloc = yloc+10;
	}
	
	
	
	public int ex() {
		return this.x;
	}
	public int why() {
		return this.y;
	}
	
	
	
	
	public boolean checkintersect(Rectangle a) {
		if (this.intersects(a)) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
