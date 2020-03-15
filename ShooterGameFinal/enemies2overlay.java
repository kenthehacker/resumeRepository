import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class enemies2overlay extends GameDriverV4{
	Rectangle ken = new Rectangle(400,400,40,40);
	StackPane pane = new StackPane();
	Pane p = new Pane();
	BufferedImage mats;
	ImageView images = new ImageView();
	double theta = 1.562;
	double deltatheta = -0.0055;
	int x;
	int y;
	int buffer =0;
	int bufferofbuffer =100;
	
	public enemies2overlay(int x, int y) {
		this.x = x+200;
		this.y = y;
		
		ken.setLocation(x+200, y+170);
		this.deltatheta=deltatheta;
		this.theta=theta;
		
	}
	
	public void spin() {
		//this.setLocation(((int)Math.cos(theta)*100), (int)Math.sin(theta));
		theta = theta+0.05;
		//this.x = (int)(Math.cos(theta)*400);
		//this.y = (int)(Math.sin(theta)*100);
		
		//this.x = (int) ((300*Math.cos(theta))/(1+Math.sin(theta)*Math.sin(theta)));
		this.y = (int) ((150*Math.sin(theta))/(1+Math.cos(theta)*Math.cos(theta)));
		
		
		//x = 300cos(t)/(1+sin(t)^2)
		//y = 150*sin(t)*cos(t)/(1+sin(t)^2)
		
		
		
		//System.out.println((int)(Math.cos(theta)*100));
	}
	public void spin2() {
		theta = theta+0.05;
		
		ken.translate((int) ((20*Math.cos(theta))/(1+Math.sin(theta)*Math.sin(theta))), (int) ((10*Math.sin(theta))/(1+Math.cos(theta)*Math.cos(theta))));
	}
	
	public void  move(Graphics2D win) {
		//do the translate stufff
		this.spin2();
		//System.out.println("x is"+this.x);
		//System.out.println("y is "+this.y);
		win.setColor(Color.RED);
		win.fillRect(ken.x, ken.y, ken.width, ken.height);
	}
	public void move2(Graphics2D win) {
		this.spin2();
		this.y = this.y+ bufferofbuffer;
		buffer = buffer+1;
		if (buffer>700) {
			bufferofbuffer = bufferofbuffer*-1;
			buffer = 0;
		}
		win.setColor(Color.RED);
		win.fillRect(ken.x, ken.y, ken.width, ken.height);
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
