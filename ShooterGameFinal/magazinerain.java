import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class magazinerain extends GameDriverV4{
	LinkedList<rainingenemies> r = new LinkedList<rainingenemies>();
	rainingenemies variable;
	BufferedImage trollface;
	
	public magazinerain() {
		trollface = this.addImage("minion.png");
	}
	public void faller(Graphics2D win) {
		for (int i = 0; i<r.size(); i++) {
			variable=r.get(i);
			variable.fall(win);
			//System.out.println("this runs");
			if (variable.getY()>=800) {
				delete(variable);
			}
			
		}
	}
	
	public void draw(Graphics2D win) {
		int count = 0;
		//this is the random trollface 
		//win.drawImage(trollface, 0, 0,null);
		for (int i = 0; i < r.size(); i++) {
			variable = r.get(i);
			//System.out.println("no this runs");
			win.drawImage(trollface, (int) variable.getX()-460, (int) variable.getY()-345,null);
			variable.fall(win);
			//win.drawImage(trollface, (int) variable.getX(), (int) variable.getY(),null);
			//the images are not correctly centered on the screen
			//win.drawImage(trollface, 400, 400,null);
		}
	}
	public void memorymanagement() {
		for (int i = 0; i < r.size(); i++) {
			variable = r.get(i);
			//System.out.println(variable.getY());
			if (variable.getY()>=800) {
				r.remove(i);
				//System.out.println("Removed");
			}
			
		}
	}
	
	
	public int listsize() {
		return r.size();
	}
	
	public boolean checkintersects(int a, int b) {
		int buffer = 10;
		int buffery = 15;
		for (int i = 0; i< r.size(); i++) {
			variable  = r.get(i);
			//if (a>(variable.getX()-buffer) && (a<variable.getX()+buffer)) {
			if ((variable.getX()>a-buffer-10)&& (variable.getX()<a+buffer+30)) {
				//if ((b>variable.getY()-buffery) && (b<variable.getX()+buffery)) {
				if ((variable.getY()>b-buffery) && (variable.getY()<b+buffery)){
					r.remove(i);
					return true;
					//System.out.println("spacex="+a+"getx="+variable.getX());
					//System.out.println("spacey="+b+"gety="+variable.getY());
					
				}
			}
			
		}
		return false;
	}
	
	
	public int getxval(int a) {
		try {
			if (r.get(a) !=null) {
				variable  = r.get(a);
				return variable.ex();
			}
			else {
				return 78888;
			}
		}
		catch(Exception e) {
			return 6666;
		}
		
	}
	
	public int getyval(int a) {
		try {
			variable  = r.get(a);
			return variable.why();
		}
		catch(Exception e) {
			return -9999;
		}
		
	}
	
	public void killed(int a) {
		try {
			variable = r.get(a);
			delete(variable);
		}
		catch (Exception e) {
			System.out.println("You got fucked twice");
		}
		
		
	}
	
	public void delete(rainingenemies a) {
		r.remove(a);
	}
	public void insert(rainingenemies a) {
		r.add(a);
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
	
}