import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class enemies2 extends GameDriverV4{
	double theta = 1.562;
	double deltatheta = -0.0055;
	int x;
	int y;
	int buffer =0;
	int bufferofbuffer =100;
	BufferedImage jick;
	
	public enemies2(int x, int y) {
		this.x=x;
		this.y = y;
		this.setLocation(x, y);
		this.deltatheta=deltatheta;
		this.theta=theta;
		jick = this.addImage("minion.png");
	}
	
	public void spin() {
		//this.setLocation(((int)Math.cos(theta)*100), (int)Math.sin(theta));
		theta = theta+0.05;
		//this.x = (int)(Math.cos(theta)*400);
		//this.y = (int)(Math.sin(theta)*100);
		this.x = (int) ((300*Math.cos(theta))/(1+Math.sin(theta)*Math.sin(theta)));
		this.y = (int) ((150*Math.sin(theta))/(1+Math.cos(theta)*Math.cos(theta)));
		
		
		//x = 300cos(t)/(1+sin(t)^2)
		//y = 150*sin(t)*cos(t)/(1+sin(t)^2)
		
		
		
		//System.out.println((int)(Math.cos(theta)*100));
	}
	public void spin2() {
		theta = theta+0.05;
		
		this.x = (int) (400*Math.cos(theta));
		this.y = (int) (200*Math.sin(theta));
		//System.out.println("x loc is"+ this.x);
		//System.out.println("Y loc is "+this.y);
	}
	
	public void  move(Graphics2D win) {
		//do the translate stufff
		this.spin();
		//System.out.println("x is"+this.x);
		//System.out.println("y is "+this.y);
		win.drawImage(jick, x,y,null);
	}
	public void move2(Graphics2D win) {
		this.spin2();
		this.y = this.y+ bufferofbuffer;
		buffer = buffer+1;
		if (buffer>700) {
			bufferofbuffer = bufferofbuffer*-1;
			buffer = 0;
		}
		
		win.drawImage(jick, x-60,y,null);
		//System.out.println(y);
		//System.out.println(this.getLocation());
		//System.out.println(buffer);
		//System.out.println(bufferofbuffer);
	}
	public int getya() {
		return this.y;
	}
	public int getxa() {
		return this.x;
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
