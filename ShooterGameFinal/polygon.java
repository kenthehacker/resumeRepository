import java.awt.Color;
import java.awt.Graphics2D;

public class polygon {
	public polygon() {
		
	}
	public void draw(Graphics2D win) {
		int[] boxx = {0,100,100,0};
		int[] boxy = {0,0,100,100};
		win.setColor(Color.red);
		win.fillPolygon(boxx,boxy,boxx.length);
		
	}

}
