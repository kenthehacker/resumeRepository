import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class bossmagazine extends GameDriverV4{
	LinkedList<boss> b = new LinkedList<boss>();
	boss right;
	boss left;
	boss down;
	BufferedImage bigtroll;
	public bossmagazine() {
		bigtroll = this.addImage("minion.png");
	}
	public void rightshift(Graphics2D win) {
		for (int i = 0; i < b.size(); i++) {
			right = b.get(i);
			right.rightshoot(win);
			win.drawImage(bigtroll, (int) right.getX()-460, (int) right.getY()-345,null);
		}
	}
	public void leftshift(Graphics2D win) {
		for (int i = 0; i < b.size(); i++) {
			left = b.get(i);
			left.leftshoot(win);
			win.drawImage(bigtroll, (int) left.getX()-460, (int) left.getY()-345,null);
		} 
	}
	public void downshift(Graphics2D win) {
		for (int i = 0; i<b.size(); i++) {
			down = b.get(i);
			down.downshoot(win);
		}
	}
	
	
	public boolean checkintersects(int a, int c) {
		int bufferx =15;
		int buffery =20;
		for (int i = 0; i<b.size(); i++) {
			right = b.get(i);
			if ((right.getX()>a-bufferx-10)&&(right.getX()<a+bufferx+30)) {
				if ((right.getY()>c-buffery)&&(right.getY()<c+buffery)) {
					b.remove(i);
					System.out.println("right intersect");
					return true;
				}
			}
		}
		return false;
	}
	public void memorymanagement() {
		for (int i = 0; i<b.size(); i++) {
			right = b.get(i);
			if (right.getX()>=805) {
				//System.out.println("deleted right at "+right.getX());
				delete(right);
			}
		}
		for (int z = 0; z<b.size(); z++) {
			left = b.get(z);
			if (left.getX()<=-5) {
				//System.out.println("deleted left at "+left.getX());
				delete(left);
				
			}
		}
	}
	
	public void delete(boss a) {
		b.remove(a);
	}
	public void insert(boss a) {
		b.add(a);
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

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}
	
}
