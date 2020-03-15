package endOfYearGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;
import endOfYearGame.soundStuff;

//private int width = 800, height = 600;

public class Controller extends GameDriverV4 {
	int state = 0;
	int distance = 1;
	int numbah = 1;
	boolean canPlay = true;
	arrow a = new arrow();
	Font font = new Font("Helvetical Neue", Font.BOLD,24);
	ArrayList<arrow> quiver;
	ArrayList<hobo> man;
	ArrayList<appleParticle> applePart;
	ArrayList<man>dude;
	ArrayList<bloodParticle>bloodAndCrip;
	ArrayList<duck> berd;
	
	//blackbear sound = new blackbear();
	soundStuff microphone = new soundStuff();
	
	BufferedImage deadBerd;
	BufferedImage hobo;
	BufferedImage appl;
	BufferedImage vape;
	BufferedImage bigBerd;
	BufferedImage bow;
	BufferedImage person;
	BufferedImage marijuana;
	BufferedImage berddd;
	
	public Controller() {
		berddd = addImage("hqdefault.jpg");
		deadBerd = addImage("pigeon_shooting_in_flight1.jpg");
		bigBerd = addImage("Big Bird.png");
		hobo = addImage("Peter Griffin-3.png");
		appl = addImage("apple.png");
		vape = addImage("Cloud.png");
		bow = addImage("arrow.png");
		person = addImage("dude.png");
		marijuana = addImage("grass and shit.png");
		
		berd = new ArrayList<duck>();
		applePart = new ArrayList<appleParticle>();
		bloodAndCrip = new ArrayList<bloodParticle>();
		
		dude = new ArrayList<man>();
		
		quiver = new ArrayList<arrow>();
		arrow b = new arrow();
		quiver.add(b);
		
		
		man = new ArrayList<hobo>();
		hobo r = new hobo(distance);
		man.add(r);
	}
	
	
	public static void main(String[] args) {
		Controller h = new Controller();
		h.start();
																	//creates new controller and starts it 
	}


	@Override
	public void draw(Graphics2D win) {
		
		
		
		if (state == 0) {
			win.drawImage(deadBerd, null,0, 0);
			if(GameDriverV4.Keys[KeyEvent.VK_1]) {
				state =1;
			}
			win.setFont(font);
			win.setColor(Color.BLACK);
			win.drawString("IDK why i didn't join the bandwagon and resubmit my old game", 0,400);
			win.drawString("game name: 'I hate my life'", 0, 420);
			win.drawString("team name: ken", 0, 440);
			win.drawString("press H for help", 0, 460);
			win.drawString("press 1 to game", 0, 480);
			if (GameDriverV4.Keys[KeyEvent.VK_H]) {
				state =2;
			}
		}
		
		if (state == 2) {
			win.drawImage(berddd, null, 320, 220);
			win.setColor(Color.BLACK);
			win.setFont(font);
			win.drawString("left and right arrow keys to rotate arrow", 0, 200);
			win.drawString("press space to eject arrow", 0, 220);
			win.drawString("just don't kill that man", 0, 240);
			win.drawString("press r to return", 0, 260);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				state = 0;
			}
		}
		if (state ==3) {
			win.setFont(font);
			win.setColor(Color.BLACK);
			win.drawString("dude u want me to tell u the score?", 0, 200);
			win.drawString("you just killed a man", 0, 220);
			win.drawString("your score: 0", 0, 240);
			win.drawString("but im america we get second chances",0, 260);
			win.drawString("press enter for second chance", 0, 280);
			if (GameDriverV4.Keys[KeyEvent.VK_ENTER]) {
				distance = 1;
				numbah = 1;
				canPlay = true;
				quiver.clear();
				man.clear();
				applePart.clear();
				dude.clear();
				bloodAndCrip.clear();
				berd.clear();
				state = 0;
				
				hobo re = new hobo(distance);
				man.add(re);
				arrow dogshit = new arrow();
				quiver.add(dogshit);
				
				/*
				 * berd = new ArrayList<duck>();
		applePart = new ArrayList<appleParticle>();
		bloodAndCrip = new ArrayList<bloodParticle>();
		
		dude = new ArrayList<man>();
		
		quiver = new ArrayList<arrow>();
		arrow b = new arrow();
		quiver.add(b);
		
		
		man = new ArrayList<hobo>();
		hobo r = new hobo(distance);
		man.add(r);
				 */
			}
			
			/*
			 * 
			 * 	int state = 0;
	int distance = 1;
	int numbah = 1;
	boolean canPlay = true;
	arrow a = new arrow();
	Font font = new Font("Helvetical Neue", Font.BOLD,24);
	ArrayList<arrow> quiver;
	ArrayList<hobo> man;
	ArrayList<appleParticle> applePart;
	ArrayList<man>dude;
	ArrayList<bloodParticle>bloodAndCrip;
	ArrayList<duck> berd;
			 */
		}
		
		if (state == 1) {
			win.drawImage(bow, null, 20, 491);
			win.drawImage(person, null, 4, 489);
			int step = 75;
			//win.drawImage(marijuana, null, 0, 505);
			for (int weed = 0; weed <= 800/step; weed++) {
				win.drawImage(marijuana, null, weed*step, 505);
			}
			
			while(berd.size()<5) {
				berd.add(new duck());
			}
			for (int i = 0; i<berd.size(); i++) {
				berd.get(i).moveDuck(win);
			}
			
			win.drawImage(vape, null, 0, 0);
			win.drawImage(vape, null, 200, 50);
			win.drawImage(vape, null, 500, 20);
			//a.drawArrow(win);
			for (int i = 0; i<quiver.size(); i++) {
				quiver.get(i).drawArrow(win);
			}
			
			man.get(man.size()-1).draw(win);
			if (canPlay) {
				if (GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
					//a.flip();
					quiver.get(quiver.size()-1).flip();
					applePart.clear();
					bloodAndCrip.clear();
					this.microphone.playMoan();
				}
			}

			if (dude.size()==0) {
				man rick = new man(man.get(man.size()-1).x, man.get(man.size()-1).y);
				dude.add(rick);
			}
			dude.get(dude.size()-1).drawMan(win);
			
			
			win.setColor(Color.BLACK);
			win.setFont(font);
			win.drawString("scoring mechanism thing ="+ numbah, 40, 40);
			
			
			if (canPlay) {
				if (GameDriverV4.Keys[KeyEvent.VK_RIGHT]) {
					/*
					if (a.ejaculate == false) {
						a.rotateRight();	
					}
					*/
					if (quiver.get(quiver.size()-1).ejaculate == false){
						quiver.get(quiver.size()-1).rotateRight();
					}
					
				}
			}

			
			
			if (quiver.get(quiver.size()-1).getTRY()>568) {											//fix this part when you aim the arrow down	
				quiver.get(quiver.size()-1).flip2();												//the fuckin shit just gets stuck
				quiver.add(new arrow());
			}
			//intersect the apple
			if (quiver.get(quiver.size()-1).getTRY()>=man.get(man.size()-1).getTopY()) {
				if (quiver.get(quiver.size()-1).getTRY()<=man.get(man.size()-1).getBottomY()) {
					if (quiver.get(quiver.size()-1).getTRX()>=man.get(man.size()-1).getXLeft()) {
						if (quiver.get(quiver.size()-1).getTRX()<=man.get(man.size()-1).getXRight()) {
							quiver.add(new arrow());
							for (int i = 0 ; i<20; i++) {
								if (applePart.size()<20) {
									applePart.add(new appleParticle(quiver.get(quiver.size()-2).getTRX(),quiver.get(quiver.size()-2).getTRY()));
								}
							}
							quiver.remove(quiver.size()-2);
							//quiver.get(quiver.size()-1).flip2();
							man.clear();
							distance++;
							man.add(new hobo(distance));
							dude.clear();
							man rick = new man(man.get(man.size()-1).x, man.get(man.size()-1).y);
							dude.add(rick);
							numbah ++;
						}
					}
				}
			}
			//intersect the dude
			if (quiver.get(quiver.size()-1).getTRY()>=dude.get(dude.size()-1).getTLy()) {
				if (quiver.get(quiver.size()-1).getTRY()<=dude.get(dude.size()-1).getBLy()) {
					if(quiver.get(quiver.size()-1).getTRX()>=dude.get(dude.size()-1).getTLx()) {
						if (quiver.get(quiver.size()-1).getTRX()<=dude.get(dude.size()-1).getTRx()) {
							quiver.get(quiver.size()-1).flip2();
							quiver.add(new arrow());
							for (int i = 0; i<100; i++) {
								if (bloodAndCrip.size()<100) {
									bloodAndCrip.add(new bloodParticle(quiver.get(quiver.size()-2).getTRX(),quiver.get(quiver.size()-2).getTRY()));
								}
							}
							this.microphone.playPeter();
							canPlay = false;
							
							
							
						}
					}
				}
			}
			
			if (!canPlay) {
				win.setColor(Color.red);
				win.drawString("GAME OVER", 300, 320);
				win.drawString("press e to exit", 300, 340);
				win.setColor(Color.black);
				if (GameDriverV4.Keys[KeyEvent.VK_E]) {
					state = 3;
				}
			}
			//intersect the mf birds
			for (int i= 0; i<berd.size(); i++) {
				if (quiver.get(quiver.size()-1).getTRY()>=berd.get(i).getY()) {
					if (quiver.get(quiver.size()-1).getTRY()<=(berd.get(i).getY()+berd.get(i).getHeight())){
						if(quiver.get(quiver.size()-1).getTRX()>=berd.get(i).getX()) {
							if(quiver.get(quiver.size()-1).getTRX()<=(berd.get(i).getX()+berd.get(i).getWidth())) {
								berd.get(i).bleed(win);
								quiver.add(new arrow());
								this.microphone.playRhee();
							}
						}
					}
				}
			}
			
			
			//gotta reset the apple particles 
			win.drawImage(hobo,null,dude.get(dude.size()-1).getTLx()-5,dude.get(dude.size()-1).getTLy());
			//win.drawImage(appl, null, 100, 100);
			win.drawImage(appl, null, man.get(man.size()-1).getXLeft()-10, man.get(man.size()-1).getTopY()-10);
			if (applePart.size() > 0) {
				for (int i= 0; i<applePart.size()-1; i++) {
					applePart.get(i).moveAndDrawApple(win);
				}
			}
			if (bloodAndCrip.size()>0) {
				for(int i = 0; i<bloodAndCrip.size()-1; i++) {
					bloodAndCrip.get(i).moveAndDrawBlood(win);
				}
			}
			if (canPlay) {
				if (GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
					if (quiver.get(quiver.size()-1).ejaculate == false) {
						quiver.get(quiver.size()-1).rotateLeft();
					}	
				}
			
			}
			for (int i=0; i<berd.size(); i++) {
				win.drawImage(bigBerd, null, berd.get(i).getX(), berd.get(i).getY());
			}
			for (int i=0; i<berd.size(); i++) {
				if (berd.get(i).getX()>=800) {
					berd.remove(i);
					berd.add(new duck());
				}
			}
			
			//shoot the berd and they fucking die and clear the object when they fall to the ground
			
		}
		
	}
}
