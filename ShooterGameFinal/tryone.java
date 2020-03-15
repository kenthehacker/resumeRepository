import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class tryone extends GameDriverV4{
	float alpha = 0.1f;
	float alpha2 = 1.0f;
	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	AlphaComposite bc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);

	private int x;
	private int y;
	BufferedImage missile;
	Rectangle m;
	
	BufferedImage laser;
	Rectangle l;
	public tryone(int a, int b) {
		this.x = a;
		this.y = b;
		missile = this.addImage("nuke.png");
		laser  = this.addImage("pine.png");
		m= new Rectangle(a+15,b,25,25);
		l = new Rectangle(a+15,b,25,25);
		
	}
	public void tick() {
		y = y-10;
		
	}
	public void move(Graphics2D win) {
		win.drawImage(laser, x,y,null);
		win.setComposite(ac);
		win.setColor(Color.RED);
		win.fillRect(l.x, l.y, l.width, l.height);
		win.setComposite(bc);
		//System.out.println(l.getY());
		//System.out.println(l.y);
		l.translate(0, -10);
		this.tick();
	}
	public void move2(Graphics2D win) {
		win.drawImage(missile, x,y,null);
		win.setComposite(ac);
		win.setColor(Color.BLUE);
		win.fillRect(m.x, m.y, m.width, m.height);
		win.setComposite(bc);
		m.translate(0, -10);
		this.tick();
	}
	
	public int laserx() {
		return l.x;
	}
	public int lasery() {
		return l.y;
	}
	public int missilex() {
		return m.x;
	}
	public int missiley() {
		return m.y;
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
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}
}
