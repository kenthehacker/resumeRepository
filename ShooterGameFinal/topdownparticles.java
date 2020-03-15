import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.AlphaComposite;

public class topdownparticles extends Rectangle{
	int speedy1 = 5;
	int speedy2 = 3;
	float alpha = 0.8f;
	float alpha2 = 1.0f;
	//g.setComposite(ac);
	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	AlphaComposite dc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);
	
	public topdownparticles  (int init) {
		this.setSize(2, 10);
		Random ken = new Random();
		int yloc = ken.nextInt(800);
		this.setLocation(yloc, init);
		
	}
	
	public void moveparticleslow(Graphics2D win) {
		Random spring = new Random();
		int yspeed = spring.nextInt(3);
		this.translate(0, yspeed);
		win.setColor(Color.WHITE);
		win.fill(this);
	}
	public void moveparticlefast(Graphics2D win, int a) {
		Random spring = new Random();
		int yspeed;
		if (a%2==0) {
			yspeed = spring.nextInt(15);
			win.setColor(Color.YELLOW);
			win.setComposite(ac);
			win.fill(this);
		}										
		else {
			yspeed = spring.nextInt(10);
			win.setColor(Color.YELLOW);
			win.setComposite(dc);
			win.fill(this);
			//System.out.println(yspeed);s
		}
		this.translate(0, yspeed);
		//win.setComposite(ac);
		//win.fill(this);
	}
	public void ammo(Graphics2D win, int x, int y) {
		this.setLocation(x, y);
		this.setSize(15,35);
		win.setColor(Color.RED);
		win.fill(this);
		this.translate(0, -5);
	}
	public void intro(Graphics2D win, int b) {
		Random number = new Random();
		int ys;
		if (b%2==0) {
			ys = number.nextInt(8);
			win.setColor(Color.WHITE);
			win.setComposite(ac);
		}
		else {
			ys = number.nextInt(8);
			win.setColor(Color.WHITE);
			win.setComposite(dc);
		}
	}
	
}
