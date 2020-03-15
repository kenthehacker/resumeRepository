import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class boss extends Rectangle{
	int hard = 0;
	int x = 0;
	float alpha = 0.1f;
	float alpha2 = 1.0f;
	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	AlphaComposite bc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);

	public boss(int a, int b) {
		this.setSize(50, 50);
		Random ken = new Random();
		int yloc = ken.nextInt(200);
		hard = b;
		x = a;
		//basically this is the horiztonal shot gun spreads
		this.setLocation(a, b+yloc);
		
	}
	public void rightshoot(Graphics2D win) {
		this.translate(15, 0);
		win.setComposite(ac);
		win.setColor(Color.pink);
		win.fill(this);
		win.setComposite(bc);
		
	}
	public void leftshoot(Graphics2D win) {
		this.translate(-15, 0);
		win.setComposite(ac);
		win.setColor(Color.pink);
		win.fill(this);
		win.setComposite(bc);
	}
	public void downshoot(Graphics2D win) {
		Random shit = new Random();
		int shiz = shit.nextInt(200);
		this.translate(0,10);
		win.setComposite(ac);
		win.setColor(Color.pink);
		win.fill(this);
		win.setComposite(bc);
	}
}