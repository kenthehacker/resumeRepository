package endOfYearGame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

////////////////////////////////////////////////////////
////												////
////	this actually turned into the apple class	////
////												////
////////////////////////////////////////////////////////

public class hobo{
	int x;			//top left corner
	int y;
	int width;
	int height;
	float alpha = 0.1F;
	AlphaComposite ac = AlphaComposite.getInstance(3, this.alpha);
	
	public hobo(int level) {
		this.y = 470;
		if (level ==1) {
			this.x = 10*level + 130;
		}
		else {
			this.x = 20*level + 130;
		}
		
		this.width = 13;
		this.height = 27;
	}
	public void draw(Graphics2D win) {
		win.setColor(Color.RED);
		win.fillRect(x, y, width, height);
		//System.out.println("x coord- "+x+" y coord - "+y);
	}
	
	public boolean isHit(int x, int y) {
		return true;
	}
	
	public int getTopY() {
		return this.y;	
	}
	public int getBottomY() {
		return this.y+this.height;
	}
	public int getXLeft() {
		return this.x;
	}
	public int getXRight() {
		return this.x+this.width;
	}
	
	
}
