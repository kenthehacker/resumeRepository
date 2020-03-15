import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.AlphaComposite;
public class Lazers extends Rectangle{
	int speedy = -5;
	float alpha = 0.6f;
	AlphaComposite hue = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	public Lazers() {
		
	}
	public Lazers(int x, int y) {
		this.setSize(7,35);
		this.setLocation(x,y);
		//this.setLocation(x,y);
	}
	/*
	public Lazers (int x, int y) {
		this.setSize(5,15);
		this.setLocation(x, y);
	}
	*/
	
	public void shooter(Graphics2D win) {
		win.setColor(Color.BLUE);
		win.setComposite(hue);
		win.fill(this);
		this.translate(0, speedy);
		
	}
	public void fire(Graphics2D win, int x, int y) {
		win.setColor(Color.RED);
		win.setComposite(hue);
		Rectangle ken = new Rectangle(x,y,15,35);
		win.fillRect(ken.x, ken.y, ken.width, ken.height);
		ken.translate(0, -5);
		//xy width and height
	}
}
