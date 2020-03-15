import java.util.LinkedList;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class enemylist {
	LinkedList<downmissile> miss = new LinkedList<downmissile>();
	LinkedList<enemies2> zika = new LinkedList<enemies2>();
	LinkedList<enemies2overlay> rectangle = new LinkedList<enemies2overlay>();
	enemies2 zika2;
	enemies2overlay pine;
	downmissile drugs;
	public enemylist() {
		
	}
	public void spiral() {
		for (int a = 0; a<zika.size(); a++) {
			zika2 = zika.get(a);
			zika2.spin();
			pine = rectangle.get(a);
			pine.spin();
		}
	}
	
	public void drawthisbitch(Graphics2D win) {
		for (int i = 0; i<zika.size(); i++) {
			zika2 = zika.get(i);
			zika2.move(win);
			//pine = rectangle.get(i);
			//pine.move(win);
			
		}
	}
	public void drawthishoe(Graphics2D win) {
		for (int i = 0; i<zika.size(); i++) {
			zika2 = zika.get(i);
			zika2.move2(win);
			System.out.println(zika2.getxa());
			
			
		}
	}
	public void drawoverlay(Graphics2D win) {
		
		for (int i = 0; i<rectangle.size(); i++) {
			pine = rectangle.get(i);
			pine.move(win);
			
		}
	
	}
	
	public void delete(enemies2 a) {
		zika.remove(a);
	}
	public void add(enemies2 a) {
		zika.add(a);
	}
	public void addoverlay(enemies2overlay a) {
		rectangle.add(a);
	}
	public void deleteoverlay(enemies2overlay a) {
		rectangle.remove(a);
	}
	
}
