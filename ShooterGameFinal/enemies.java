import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class enemies extends GameDriverV4{
	private int x;
	private int y;
	private double t=1;
	private double degree;
	BufferedImage minion;
	BufferedImage boss;
	
	public  enemies(int a ,int b) {
		this.t = 0;
		this.x=a;
		this.y=b;
		this.setLocation(a, b);
		minion = this.addImage("minion.png");
		boss =this.addImage("boss.png");
	}
	public double t() {
		t = t+1;
		degree = t*(Math.PI/180);
		return degree;
	}
	public void rotate() {
		//x=32cost(t)
		//y=7sin(t)
		this.x = (int) ((int)32*Math.cos(this.degree));
		this.y = (int)(6*Math.sin(this.degree));
		
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
