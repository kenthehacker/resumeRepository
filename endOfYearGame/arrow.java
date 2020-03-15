package endOfYearGame;

import java.awt.Color;
import java.awt.Graphics2D;

import sun.nio.cs.ext.TIS_620;

public class arrow {
	double theta;
	double og = Math.PI/4.0;
	int x;
	int y;
	int horizontal = 40;
	int vertical = 2;
	int originalX = 30;
	int originalY = 800-280;
	Color col = new Color(135,206,250);
	int blue = 0;
	//theoretically 2 seconds to travel from left to right on screen 
	int speed = 375;
	int time = 0;
	double dx = (Math.cos(og)*speed)/60.0;
	double dy = -(Math.sin(og)*speed)/60.0;
	
	
	boolean ejaculate = false;
	
	
	public arrow() {
		this.theta = og;
		this.x = originalX;
		this.y = originalY;
	}
	
	public void rotateRight() {
		this.theta = this.theta - 0.01;
		dx = (Math.cos(this.theta)*speed)/60.0;
		dy = -(Math.sin(this.theta)*speed)/60.0;
	}
	
	/**
	 * ez
	 */
	public void rotateLeft() {
		this.theta = this.theta + 0.01;
		dx = (Math.cos(this.theta)*speed)/60.0;
		dy = -(Math.sin(this.theta)*speed)/60.0;
	}
	
	/**
	 *controller calls on this and makes it possible to ejaculate if it is true then
	 *draw funct calls on ejaculate function
	 */
	public void flip() {
		this.ejaculate=true;
	}
	public void flip2() {
		this.ejaculate = false;
	}
	/**
	 * sends the arrow into space with y acceleration set at 0.06 idk man don't even ask why its 0.06
	 */
	public void ejaculate() {
		time++;
		this.x = (int) (this.x+dx);
		this.y = (int) (this.y+dy);
		dy = dy+0.06;
		
	}
	
	public void thetaFix() {
		//changing the angle here is only cosmetics since the dx and dy was already predetermined from 
		//the start of the ejaculation based on the theta at that point
		//yet the theta changes following the ejaculation won't change the projectile motion
		//rather only the cosmetics
		
		this.theta = theta-0.01;
	}
	
	public void colorChange() {
		this.blue = 1;
	}
	
	/**
	 * 
	 * @param win
	 */
	public void drawArrow(Graphics2D win) {
		if (this.blue ==0) {
			win.setColor(Color.BLACK);
		}
		else {
			win.setColor(col);
		}
		
		//x's of the rectangular arrows
		int bottomRightX = (int)(this.x+horizontal*Math.cos(theta));
		int topRightX = (int)(bottomRightX-Math.sin(this.theta)*vertical);
		int topLeftX = (int)(this.x-Math.sin(this.theta)*vertical);
		
		//y's of the rectangular arrows
		int bottomRightY = (int)(this.y-Math.sin(this.theta)*horizontal);
		int topRightY =  (int)(bottomRightY-vertical*Math.cos(this.theta)) ;
		int topLeftY = (int)(this.y-vertical*Math.cos(this.theta));
		int Xs[] = {this.x, bottomRightX, topRightX, topLeftX};
		int Ys[] = {this.y, bottomRightY, topRightY, topLeftY};
		
		if (this.ejaculate) {
			this.ejaculate();
			this.thetaFix();
		}
		
		
		
		
		win.setColor(Color.RED);
		win.fillPolygon(Xs,Ys,4);
		
	}
	
	public int getTRX() {
		int bottomRightX = (int)(this.x+horizontal*Math.cos(theta));
		int TRx = (int)(bottomRightX-Math.sin(this.theta)*vertical);
		return TRx;
	}
	public int getTRY() {
		int bottomRightY = (int)(this.y-Math.sin(this.theta)*horizontal);
		int TRy = (int)(bottomRightY-vertical*Math.cos(this.theta)) ;
		return TRy;
	}
	
}




