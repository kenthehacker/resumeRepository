import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 * @author kenichimatsuo
 *
 */
public class body {
	private int lxSlot;
	private int lySlot;
	private int scale = 1;
	private int vertical = 0; //0 for nothing negative for down and positive for up 
	private int horizontal = 0; //0 for nothing negative for left and positive for right
	private int width = 1*scale;
	/**
	 * 
	 * @param x
	 * @param y
	 * @param upAndDown vertical
	 * @param rightAndLeft horizontal
	 */
	public body(int x, int y, int upAndDown, int rightAndLeft) {
		this.lxSlot = x*scale;
		this.lySlot = y*scale;
		this.vertical = upAndDown;
		this.horizontal=rightAndLeft;
	}
	public int getUpAndDown() {
		return this.vertical;
	}
	public int getRightAndLeft() {
		return this.horizontal;
	}
	public int getX() {
		return this.lxSlot;
	}
	public int getY() {
		return this.lySlot;
	}
	/**
	 * 
	 * @param x horizontal
	 * @param y	vertical
	 */
	public void changeDirHandV(int x, int y) {
		this.vertical=y;
		this.horizontal=x;
	}
	public void moveAndDraw() {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle((double)this.lxSlot-(double)width/2, (double)this.lySlot-(double)width/2, (double)width/2, (double)width/2);
	}
	/**
	 * @param x Xlocation of the apple
	 * @param y Ylocation of the apple 
	 * @return true if collided and false if not collided
	 */
	public boolean collision(int x, int y) {
		if (this.lxSlot==x && this.lySlot==y) {
			return true;
		}
		return false;
	}
	
	
}
