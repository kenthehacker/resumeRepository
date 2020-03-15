package bouncingballs;
import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class balls {
	private double xloc;
	private double yloc;
	private double dx;
	private double dy;
	private double radius;
	public balls() {
		this.xloc=Math.random();
		this.yloc=Math.random();
		this.dx=Math.random()/100.0;
		this.dy = Math.random()/100.0;
		this.radius = 0.03;
	}
	public double getRadius() {
		return this.radius;
	}
	public double getDX() {
		return this.dx;
	}
	public double getDY() {
		return this.dy;
	}
	public double getXloc() {
		return this.xloc;
	}
	public double getYloc() {
		return this.yloc;
	}
	public void newDX(double n) {
		this.dx=n;
	}
	public void newDY(double n) {
		this.dy=n;
	}
	public void moveAndDraw() {
		this.xloc=this.xloc+this.dx;
		this.yloc=this.yloc+this.dy;
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledCircle(this.xloc, this.yloc, radius);
	}
	

}
