import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.AlphaComposite;
public class bullet extends Rectangle {
	boolean exists = false;
	public  bullet() {
		this.setSize(15,35);		
	}
	public void start(int x, int y) {
		this.setLocation(x,y);
		exists = true;
	}
	public boolean getexist() {
		return exists;
	}
	public void generate(Graphics2D win) {
		win.setColor(Color.red);
		win.fill(this);
		this.translate(0, -5);
	}
	public void death(Graphics2D win) {
		exists = false;
	}
}