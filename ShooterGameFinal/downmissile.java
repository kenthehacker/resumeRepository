import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class downmissile extends GameDriverV4{
	BufferedImage ken;
	int x;
	int y;
	public downmissile(int x, int y) {
		ken = this.addImage("downshooterpng.png");
		this.x = x;
		this.y = y;
	}
	public void down() {
		this.y = this.y+5;
	}
	public void move(Graphics2D win) {
		this.down();
		win.drawImage(ken, x,y,null);
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
