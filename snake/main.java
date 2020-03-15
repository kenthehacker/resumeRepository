
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import com.sun.glass.events.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;
public class main {
	static ArrayList<apple> magazineApple = new ArrayList<apple>();static ArrayList<body> magazineBody = new ArrayList<body>();
	static int boxSize=10;
	public static void main(String[]args) {
		StdDraw.setYscale(0,10);StdDraw.setXscale(0,10);	//v & h
		System.out.println("LOG- MAIN STATEMENT LAUNCHES DRAW METHOD");
		splashScreen();
	}public static void draw() {
		System.out.println("LOG-DRAW METHOD LAUNCHED");magazineBody.add(new body(5,5,1,0));
		int ticker = 0;boolean notDead = true;
		while(notDead) {
			StdDraw.clear();StdDraw.enableDoubleBuffering();
			if (ticker>=25) {
				if (magazineBody.get(0).getX()==magazineApple.get(0).getColX() && magazineBody.get(0).getY()==magazineApple.get(0).getColY()) {
					int lastX = magazineBody.get(magazineBody.size()-1).getX();int lastY = magazineBody.get(magazineBody.size()-1).getY();
					if (magazineBody.get(0).getUpAndDown()==0) {
						if (magazineBody.get(0).getRightAndLeft()==1) {
							magazineBody.add(new body(lastX-1, lastY, magazineBody.get(magazineBody.size()-1).getUpAndDown(),magazineBody.get(magazineBody.size()-1).getRightAndLeft()));
						}else {
							magazineBody.add(new body(lastX+1, lastY, magazineBody.get(magazineBody.size()-1).getUpAndDown(),magazineBody.get(magazineBody.size()-1).getRightAndLeft()));
						}}else {
						if(magazineBody.get(0).getUpAndDown()==1) {
							magazineBody.add(new body(lastX, lastY-1, magazineBody.get(magazineBody.size()-1).getUpAndDown(),magazineBody.get(magazineBody.size()-1).getRightAndLeft()));
						}else {
							magazineBody.add(new body(lastX, lastY+1, magazineBody.get(magazineBody.size()-1).getUpAndDown(),magazineBody.get(magazineBody.size()-1).getRightAndLeft()));
						}
					}magazineApple.remove(0);
				}int v = magazineBody.get(0).getUpAndDown();int h = magazineBody.get(0).getRightAndLeft();int x = magazineBody.get(0).getX();int y = magazineBody.get(0).getY();
				x = x+h*boxSize/10;y = y+v*boxSize/10;
				magazineBody.remove(magazineBody.size()-1);magazineBody.add(0,new body(x,y,v,h));ticker = 0;
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && magazineBody.get(0).getUpAndDown()==0) {magazineBody.get(0).changeDirHandV(0, -1);}
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && magazineBody.get(0).getUpAndDown()==0) {magazineBody.get(0).changeDirHandV(0, 1);}
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && magazineBody.get(0).getRightAndLeft()==0) {magazineBody.get(0).changeDirHandV(1, 0);}
			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && magazineBody.get(0).getRightAndLeft()==0) {magazineBody.get(0).changeDirHandV(-1, 0);}
			if (magazineApple.size()<=0) {magazineApple.add(new apple());}
			for (int i =0; i<magazineApple.size(); i++) {magazineApple.get(i).moveAndDraw();}
			for (int i =0; i<magazineBody.size(); i++) {magazineBody.get(i).moveAndDraw();}
			if(magazineBody.get(0).getX()>10 || magazineBody.get(0).getX()<0 || magazineBody.get(0).getY()>10 || magazineBody.get(0).getY()<0) {
				notDead = false;
				deathScreen();
			}
			if (magazineBody.size()>=2) {
				for (int i = 1; i<magazineBody.size(); i++) {
					if (magazineBody.get(0).getX()==magazineBody.get(i).getX() && magazineBody.get(0).getY()==magazineBody.get(i).getY()) {
						notDead =false;
						deathScreen();
					}
				}	
			}

			ticker++;
			StdDraw.pause(1); StdDraw.show();
		}
	}
	public static void splashScreen() {
		System.out.println("LOG- splashScreen METHOD LAUNCHED");
		while (true) {
			StdDraw.clear();StdDraw.enableDoubleBuffering();Font font = new Font("Bradley Hand", Font.BOLD, 40);StdDraw.setFont(font);StdDraw.setPenColor(Color.RED);
			StdDraw.picture(5, 4, "demonPainting.jpg", 9, 7);
			StdDraw.text(5, 8.5, "Press Space To Play");
			StdDraw.pause(5);StdDraw.show();
			StdDraw.pause(95);
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				StdDraw.clear();
				draw();
				break;
			}
			StdDraw.pause(0);StdDraw.show();
		}
	}
	public static void deathScreen() {
		while (true) {
			StdDraw.clear();StdDraw.enableDoubleBuffering();
			int yloc = 7;
			StdDraw.setPenColor(Color.RED);
			Font font = new Font("Bradley Hand", Font.BOLD, 20);
			StdDraw.setFont(font);
			StdDraw.text(5, yloc, "Satan Reaped Your Soul");
			StdDraw.picture(5, yloc-2, "satan.png", 3, 3);
			StdDraw.text(5, yloc-4, "Press SPACE to return to menu");
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				magazineBody.clear();
				magazineApple.clear();
				StdDraw.clear();
				splashScreen();
			}	
			StdDraw.pause(5);StdDraw.show();
		}
		
	}
}
