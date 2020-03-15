package bouncingballs;


import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;

public class BouncingBalls {

	public static void main(String[] args) {
		
		ArgsProcessor a = new ArgsProcessor(args);
		int n = a.nextInt("how many balls do you want?");
		balls[] ballz=new balls[n];
		for (int i =0; i<n; i++) {
			ballz[i]= new balls();
		}
		drawShit(ballz);
	}
	public static void drawShit(balls[] ball) {

		while(true) {
			double radius =0.03;
			StdDraw.clear();
			StdDraw.enableDoubleBuffering(); 
			for (int i=0; i< ball.length; i++) {
				if (ball[i].getXloc()+radius>=1) {
					ball[i].newDX(-1*Math.abs(ball[i].getDX()));
				}
				if (ball[i].getXloc()-radius<=0) {
					ball[i].newDX(Math.abs(ball[i].getDX()));
				}
				if (ball[i].getYloc()+radius>=1) {
					ball[i].newDY(-1*Math.abs(ball[i].getDY()));
				}
				if (ball[i].getYloc()-radius<=0) {
					ball[i].newDY(Math.abs(ball[i].getDY()));
				}
				ball[i].moveAndDraw();
			}
			for (int j =0; j<ball.length; j++) {
				if (ball.length>=2) {
					for (int m = j+1; m<ball.length; m++) {
						double distance = Math.sqrt(Math.pow((ball[j].getXloc()-ball[m].getXloc()), 2)+Math.pow((ball[j].getYloc()-ball[m].getYloc()), 2))-2*radius;
						if (distance<=0.001) {
							double v1fX = (ball[j].getDX()*((ball[j].getRadius()-ball[m].getRadius())/(ball[j].getRadius()+ball[m].getRadius())))+(2*ball[m].getDX()*ball[m].getRadius()/(ball[j].getRadius()+ball[m].getRadius()));
							double v1fY = (ball[j].getDY()*((ball[j].getRadius()-ball[m].getRadius())/(ball[j].getRadius()+ball[m].getRadius())))+(2*ball[m].getDY()*ball[m].getRadius()/(ball[j].getRadius()+ball[m].getRadius()));
							double v2fX = (2*ball[j].getDX()*ball[m].getRadius()/(ball[j].getRadius()+ball[m].getRadius()))+(ball[m].getDX()*((ball[j].getRadius()-ball[m].getRadius())/(ball[j].getRadius()+ball[m].getRadius())));
							double v2fY = (2*ball[j].getDY()*ball[m].getRadius()/(ball[j].getRadius()+ball[m].getRadius()))+(ball[m].getDY()*((ball[j].getRadius()-ball[m].getRadius())/(ball[j].getRadius()+ball[m].getRadius())));
							ball[j].newDX(v1fX); ball[j].newDY(v1fY);							
							ball[m].newDX(v2fX); ball[m].newDY(v2fY);
						}
					}	
				}
			}
			StdDraw.pause(10);
			StdDraw.show();
		}
	}
}
