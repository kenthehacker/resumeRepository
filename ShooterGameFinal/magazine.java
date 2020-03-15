import java.util.LinkedList;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class magazine {
	LinkedList<tryone> m = new LinkedList<tryone>();
	LinkedList<tryone> ken = new LinkedList<tryone>();
	tryone ammunition;
	tryone rocket;
	finalshooter f;
	public magazine() {
		
	}
	public void tick() {
		for (int i = 0; i<m.size(); i++) {
			ammunition = m.get(i);
			ammunition.tick();
			if (ammunition.getY()<=-500) {
				remover(ammunition);
			}
		}
	}
	public void tick2() {
		for (int w = 0 ; w<ken.size(); w++) {
			rocket = ken.get(w);
			rocket.tick();
			if (rocket.getY()<=-500) {
				remover(rocket);
			}
		}
	}
	public void drawer(Graphics2D win) {
		for (int i = 0; i<m.size(); i++) {
			ammunition = m.get(i);
			ammunition.move(win);
		}
	}
	
	public void drawer2(Graphics2D win) {
		for (int r = 0; r<ken.size(); r++) {
			rocket = ken.get(r);
			rocket.move2(win);
		}
	}
	
	public void collision() {
		//loop through every single missile box and in your controller
		//loop throughe very single enemy and see if it is gucci
		
	}
	
	public void memorymanagement() {
		for (int i = 0; i<m.size(); i++) {
			ammunition = m.get(i);
			if (ammunition.getY()<0) {
				remover(ammunition);
			}
		}
		for (int j = 0; j<ken.size(); j++) {
			rocket = ken.get(j);
			if (rocket.getY()<0) {
				remover(rocket);
			}
		}
	}
	
	
	public int getlaserx(int a) {
		try {
			if (m.get(a)!=null) {
				ammunition = m.get(a);
				return ammunition.laserx();
			}
			else {
				return 9999;
			}
		}
		catch(Exception e) {
			return 9999;
		}	
	}
	public int getrocketx(int a) {
		try {
			if (ken.get(a)!=null) {
				rocket = ken.get(a);
				return rocket.missilex();
			}
			else {
				return 9999;
			}
		}
		catch(Exception e) {
			return 99999;
		}
	}
	
	public int getlasery(int a) {
		try {
			ammunition = m.get(a);
			return ammunition.lasery();
		}
		catch (Exception e) {
			return 9999;
		}
		
	}
	public int getrockety(int a) {
		try {
			rocket = ken.get(a);
			return rocket.missiley();
		}
		catch(Exception e) {
			return 9999;
		}
	}
	public void dellaser(int a) {
		try {
			ammunition = m.get(a);
			remover(ammunition);
		}
		catch(Exception e) {
			System.out.println("you got fucked");
		}
	}
	public void delrocket(int a) {
		try {
			rocket = ken.get(a);
			remover(rocket);
		}
		catch(Exception e) {
			System.out.println("You got cucked");
		}
	}
	public int listsizelaser() {
		return m.size();
	}
	public int listsizerocket() {
		return ken.size();
	}
	public void remover(tryone a) {
		m.remove(a);
	}
	public void remover2(tryone a) {
		ken.remove(a);
	}
	public void adder(tryone a) {
		m.add(a);
	}
	public void adder2(tryone a) {
		ken.add(a);
	}
	
}
