package endOfYearGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class man {
	int x;
	int y;
	int height;
	int width;
	public man (int x, int y) {
		this.x = x+6-10;
		this.y = y+13;
		this.width = 20;
		this.height = 65;
	}
	public void drawMan(Graphics2D win) {
		win.setColor(Color.BLACK);
		//win.fillRect(this.x, this.y, this.width, this.height);
	}
	public int getTLx() {
		return this.x;
	}
	public int getTRx() {
		return this.x+width;
	}
	public int getTLy() {
		return this.y;
	}
	public int getBLy() {
		return this.y+this.height;
	}

}
