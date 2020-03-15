////////////////////////
//shit to do here
//Make the spaceship bounce off the edges in gamemode 1
////////////////////////
import java.awt.Graphics2D;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.sun.javafx.tk.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
public class finalshooter extends GameDriverV4 implements ActionListener, MouseListener{
	float alpha = 0.1f;
	float alpha2 = 1.0f;
	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	AlphaComposite bc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);
	int bosshealth=100;
	int health = 100;
	int score = 0;
	int killcount = 0;
	int powerup = 0;
	boolean lockedandloaded=false;
	polygon poly = new polygon();
	double theta = 0;
	int score1 = 0;
	int score2 = 0;
	int score3 = 0;
	int scoreboard = 0;
	int firstplace = 0;
	int secondplace = 0;
	int thirdplace=0;
	
	
	//
	bossmagazine sideshoot = new bossmagazine();
	bossmagazine sideshootr = new bossmagazine();
	bossmagazine sideshootrr = new bossmagazine();
	magazine mag = new magazine();
	enemylist mo = new enemylist();
	enemylist kenny = new enemylist();
	enemies2 tesst = new enemies2(100,100);
	magazinerain rain = new magazinerain();
	Rectangle bru = new Rectangle (300,-400,200,200);
	boolean bruexist = false;
	int initboss = 5; //if kill count is greater than this then create boss
					//also keep in mind that if it is greater than that score it will keep on drawing
					//new bosses 
					//to fix this only draw if boss class is null
	//
	
	int level=1;											//useless atm
	int gamestate = 0;										//dafuq
	int counter = 0;
	int bouncespeedx;
	int bouncespeedy;
	int speedo = 5;
	int spacex = 25;
	int spacex_ = 25;
	int spacey = 480;
	int spacey_=480;
	int particlecount = 200;
	int sidetranslator = 7;
	int verttrasnslator = 5;
	int angle = 0;
	int whichone = 0;
	double rotationRequired = Math.toRadians (angle);
	
	boolean test = false;
	blackbear apr = new blackbear();						
	BufferedImage shooter;
	BufferedImage bck;
	BufferedImage intro;
	BufferedImage intro2;
	BufferedImage bossface;
	
	Random ken = new Random();
	Lazers[] arr = new Lazers[10];
	topdownparticles[] test1 = new topdownparticles[particlecount];
	topdownparticles[] test2 = new topdownparticles[particlecount/2];
	topdownparticles[] bulletz = new topdownparticles[50];
	bullet[] ammunition = new bullet[50];
	Rectangle f = new Rectangle(spacex+454,spacey+220,7,35);
	Rectangle ammo = new Rectangle();
	int spaceoverlayx = 0;
	int spaceoverlayy = 0;
	Rectangle spaceoverlay = new Rectangle (spaceoverlayx,spaceoverlayy,40,40);
	Lazers shit = new Lazers();
	public finalshooter() {									//adds random digit from 1-4 to the arrays to store 
		shooter = this.addImage("bigger.png");
		bck = this.addImage("20180814-4lPZtkgNJYAiRLfucz6O.jpeg");
		intro = this.addImage("intropage.png");
		intro2 = this.addImage("intropage-2.png");
		bossface = this.addImage("realface.png");
		for (int apr = 0; apr<=particlecount-1; apr++) {
			Random shit = new Random();
			int randoy = shit.nextInt(800);
			test1[apr]=new topdownparticles(randoy);
		}

		for (int var = 0; var<50; var++) {
			ammunition[var]=new bullet();
		}
		
		
	}
	public static void main(String[] args) {
		finalshooter john = new finalshooter();
		john.start();
	}
	
	public void Splash(Graphics2D win) {
		
		
	}
	/*
	public void lyn(MouseListener e) {
		
	}
	*/
	public void kenalyn(MouseEvent e) {
		
	}
	
	
	@Override
														//this is where all of the coding happens
	
	
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
		if (gamestate ==2) {
			//help page
			this.Splash(win);
			
			Font font2 = new Font("Trattatello", Font.BOLD, 80);
			win.setFont(font2);
			win.setColor(Color.YELLOW);
			win.drawString("Instruction:", 250, 150);
			Font font3 = new Font("Luminari", Font.BOLD,20);
			win.setFont(font3);

			if (GameDriverV4.Keys[KeyEvent.VK_M]) {							//goes to menu
				gamestate = 0;
			}
			
		}
		
		if (gamestate == 3) {
			//sound option page
			this.Splash(win);
			this.setBackGroundColor(Color.cyan);
			win.setColor(Color.BLACK);
			Font font4 = new Font("Herculanum",Font.BOLD,60);
			win.setFont(font4);
			win.drawString("Audio Options", 215, 200);
			Font font  = new Font("Herculanum", Font.BOLD,30);
			Font fontsmall = new Font("Herculanum", Font.BOLD, 15);
			win.setFont(font);
			win.drawString("-Press '1' to stop/start music", 210, 250);
			win.drawString("-Press '2' to change to music 2", 210, 300);
			win.drawString("-Press '3' to change to music 3", 210, 350);
			win.drawString("-Press '4' to change to music 1", 210, 400);
			win.setFont(fontsmall);
			win.drawString("The reason why i have these songs is cuz as I was developing", 210, 450);
			win.drawString("I grew sick and tired of listening to the game music so I wanted to",210,500);
			win.drawString("listen to logic and stuff", 210,550);
			win.setFont(font);
			win.drawString("-Press 'm' to return to menu", 210, 600);
			if (GameDriverV4.Keys[KeyEvent.VK_1]) {
				apr.reverse();											//pause the music
			}
			if (GameDriverV4.Keys[KeyEvent.VK_2]) {
				apr.soundtwo();											//switch to music two
			}
			if (GameDriverV4.Keys[KeyEvent.VK_3]) {
				apr.soundthree();										//switch to music three
			}
			if (GameDriverV4.Keys[KeyEvent.VK_4]) {
				apr.soundone();											//switch to music one
			}
			if (GameDriverV4.Keys[KeyEvent.VK_M]) {
				gamestate = 0;											//go to main menu
			}
			//have them choose what kind of press sounds they want
			
		}
		if (gamestate == 1) {
			//poly.draw(win);
			this.Splash(win);
			
			
			win.setColor(Color.white);
			Font font4 = new Font("Futura Medium",Font.BOLD,20);
			win.setFont(font4);
			win.drawString("Health "+health, 50, 700);
			win.drawString("Score "+score, 50, 720);
			//testing if the mag works
			if (GameDriverV4.Keys[KeyEvent.VK_T]) {
				mo.add(new enemies2(100,100));
				kenny.addoverlay(new enemies2overlay(400,100));
			}
			
			if (level==1) {
				if (Math.random() > 0.99) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==2) {
				if (Math.random() > 0.98) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==3) {
				if (Math.random() > 0.97) {
					rain.insert(new rainingenemies());
				}
			}
			
			if (level ==4) {
				if (Math.random() > 0.96) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==5) {
				if (Math.random() > 0.95) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==6) {
				if (Math.random() > 0.90) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==7) {
				if (Math.random() > 0.85) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==8) {
				if (Math.random() > 0.80) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==9) {
				if (Math.random() > 0.75) {
					rain.insert(new rainingenemies());
				}
			}
			if (level ==10) {
				if (Math.random() > 0.50) {
					rain.insert(new rainingenemies());
				}
			}
			if (level >=11) {
				if (Math.random() > 0.10) {
					rain.insert(new rainingenemies());
				}
			}
			if (GameDriverV4.Keys[KeyEvent.VK_8]) {
				level = 10;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_0]) {
				level = 11;
			}
			if (bruexist == false) {
				win.setComposite(ac);
				win.setColor(Color.RED);
				win.fillRect(bru.x, bru.y, bru.width, bru.height);
				win.setComposite(bc);
				//bruexist = true;
				if (killcount%5==0 && killcount!=0) {
					if (bru.y<300) {
						bru.translate(0, 5);
					}	
				}
				
				if(bru.y>=300) {
					if(Math.random()>0.80) {
						sideshoot.insert(new boss(300,300));
					}
					if (Math.random()>0.80) {
						sideshootr.insert(new boss(500,300));
					}
					/*
					if (Math.random()>0.05) {
						sideshootrr.insert(new boss(300,500));
					}
					*/
				}
			}
			
			if (bosshealth<=0) {
				bosshealth = 100;
				bru.y = -400;
				level = level+1;
			}
			if (bru.y+200>=10) {
				lockedandloaded = true;
			}
			else {
				lockedandloaded = false;
			}
			

			//System.out.println(lockedandloaded);
			sideshoot.leftshift(win);
			sideshootr.rightshift(win);
			//sideshootrr.downshift(win);
			
			
			//gets rid of unecessary blocks out of scope
			rain.memorymanagement();
			mag.memorymanagement();
			sideshoot.memorymanagement();
			sideshootr.memorymanagement();
			
			//aww jeez u have no idea
			if (rain.checkintersects(spaceoverlayx, spaceoverlayy)) {
				health = health-10;
			}
			if (sideshootr.checkintersects(spaceoverlayx, spaceoverlayy)) {
				health = health-5;
			}
			
			//spaceoverlay intersect with  Rectangle bru = new Rectangle (300,-100,200,200);
			if ((bru.x-5<spaceoverlayx) &&(spaceoverlayx<bru.x+205)) {
				if ((bru.y-5<spaceoverlayy)&&(spaceoverlayy<bru.y+205)) {
					health = health-1;
				}
			}
			
			win.drawImage(bossface, -60, bru.y-270, null);
			
			//health damage 
			
			int size = rain.listsize();
			int sizelaser = mag.listsizelaser();
			int sizerocket = mag.listsizerocket();
			int bufferx = 50;
			int buffery = 50;
			boolean hascount = false;
			if (lockedandloaded) {
				//holy fuckerson
				for (int i = 0; i<20; i++) {
					if ((mag.getlaserx(i)>=bru.x-5) && (mag.getlaserx(i)<=bru.x+205)) {
						if ((bru.y-5<=mag.getlasery(i)) &&(bru.y+205>=mag.getlasery(i))) {
							if (hascount == false) {
								score = score+10;
								killcount = killcount+1;
								mag.dellaser(i);
								bosshealth = bosshealth-5;
								if (bosshealth<=0) {
									bosshealth = 100;
									bru.y = -400;
									level = level+1;
								}
							}
							hascount = true;
						}
					}
				}
				for (int j = 0; j<20; j++) {
					if ((mag.getrocketx(j)>=bru.x-5) && (mag.getrocketx(j)<=bru.x+205)) {
						if ((bru.y-5<=mag.getrockety(j)) &&(bru.y+205>=mag.getrockety(j))) {
							if (hascount == false) {
								score = score+10;
								killcount = killcount+1;
								bosshealth = bosshealth-10;
								mag.delrocket(j);
							}
							hascount = true;
							if (bosshealth<=0) {
								bosshealth = 100;
								bru.y = -400;
								level = level+1;
							}
						}
					}
				}
			}
			hascount = true;
			System.out.println("bosshealth= "+bosshealth+" level= "+level);

			for (int i = 0; i<20; i++) {
				for (int j = 0; j<20; j++) {
					if ((mag.getlaserx(j)>=rain.getxval(i)-10)&&(mag.getlaserx(j))<=rain.getxval(i)+50) {
						//System.out.println("x worked");
						if ((mag.getlasery(j)>=rain.getyval(i)-10)&&(mag.getlasery(j)<=rain.getyval(i)+50)){
							//System.out.println("intersected");
							//System.out.println(mag.getlasery(j));
							//System.out.println(rain.getyval(i));
							mag.dellaser(j);
							rain.killed(i);
							score = score+1;
							killcount = killcount+1;
							powerup = powerup+1;
							try {
								//System.out.println("enemy y" + rain.getyval(i)+" laser y"+ mag.getlasery(j));
							}
							catch(Exception e) {
								System.out.println("What the actual fuck how");
							}
							
						}
					}
				}
				
			}
			
			if (powerup==5) {
				for (int i = 0; i<20; i++) {
					for (int j = 0; j<20; j++) {
						if ((mag.getrocketx(j)>=rain.getxval(i)-10)&&(mag.getrocketx(j))<=rain.getxval(i)+50) {
							//System.out.println("x worked");
							if ((mag.getrockety(j)>=rain.getyval(i)-10)&&(mag.getrockety(j)<=rain.getyval(i)+50)){
								//System.out.println("intersected");
								//System.out.println(mag.getlasery(j));
								//System.out.println(rain.getyval(i));
								mag.delrocket(j);
								rain.killed(i);
								powerup = 0;
								score = score+1;
								
								killcount = killcount+1;
								try {
									//System.out.println("enemy y" + rain.getyval(i)+" laser y"+ mag.getlasery(j));
								}
								catch(Exception e) {
									System.out.println("What the actual fuck how");
								}
								
							}
						}
					}
					
				}
			}
			
			if (GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
				mag.adder(new tryone(spacex+430,spacey+210));
				apr.soundfour();
			}
			
			if (powerup==5) {
				if (GameDriverV4.Keys[KeyEvent.VK_X]) {
					apr.soundfive();
					mag.adder2(new tryone(spacex+430,spacey+210));
				}
				if (GameDriverV4.Keys[KeyEvent.VK_X]) {
					apr.soundfive();
				}	
			}
			mag.drawer(win);
			mag.drawer2(win);
			//mo.drawthishoe(win);
			kenny.drawoverlay(win);
			rain.draw(win);
			
			//rocket intersect enemy
			
			
			
			
			
			win.drawImage(shooter, null, spacex,spacey);
			spaceoverlayx = spacex+441;
			spaceoverlayy = spacey+248;
			win.setColor(Color.red);
			win.setComposite(ac);
			win.fillRect(spaceoverlayx, spaceoverlayy, spaceoverlay.width, spaceoverlay.height);
			win.setComposite(bc);
			if (GameDriverV4.Keys[KeyEvent.VK_1]) {
				spacex = spacex-2;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_1]) {
				spacex = spacex-2;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
				spacex = spacex-7;
			}
			if (spacex<=-450) {
				spacex = -445;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_2]) {
				spacex = spacex+2;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_2]) {
				spacex = spacex+2;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_RIGHT]) {	
				spacex = spacex+7;
			}
			if (spacex>= 321) {
				spacex = 320;
			}
			
			if (GameDriverV4.Keys[KeyEvent.VK_UP]) {
				spacey = spacey-4;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
				spacey = spacey+4;
			}
			if (spacey<=-233) {
				spacey = -232;

			}
			if (spacey>=480) {
				spacey = 479;
			}
			
			
			if (powerup>=6) {
				powerup=5;
			}
			win.setColor(Color.red);
			win.fillRect(10, 10, 201, 26);
			win.setColor(Color.blue);
			win.fillRect(13,13,200-5,20);
			
			if (powerup==0) {
				win.setColor(Color.yellow);
				win.fillRect(13, 13, (200-5)/5, 20);
				win.fillRect(13+((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+2*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+3*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+4*((200-5)/5), 13, (200-5)/5, 20);
			}
			if (powerup==1) {
				win.setColor(Color.yellow);
				win.fillRect(13, 13, (200-5)/5, 20);
				win.fillRect(13+((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+2*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+3*((200-5)/5), 13, (200-5)/5, 20);
				win.setColor(Color.blue);
				win.fillRect(13+4*((200-5)/5), 13, (200-5)/5, 20);
			}
			if (powerup==2) {
				win.setColor(Color.yellow);
				win.fillRect(13, 13, (200-5)/5, 20);
				win.fillRect(13+((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+2*((200-5)/5), 13, (200-5)/5, 20);
				win.setColor(Color.blue);
				win.fillRect(13+3*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+4*((200-5)/5), 13, (200-5)/5, 20);
			}
			if (powerup==3) {
				win.setColor(Color.yellow);
				win.fillRect(13, 13, (200-5)/5, 20);
				win.fillRect(13+((200-5)/5), 13, (200-5)/5, 20);
				win.setColor(Color.blue);
				win.fillRect(13+2*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+3*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+4*((200-5)/5), 13, (200-5)/5, 20);
			}
			if (powerup==4) {
				win.setColor(Color.yellow);
				win.fillRect(13, 13, (200-5)/5, 20);
				win.setColor(Color.blue);
				win.fillRect(13+((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+2*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+3*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+4*((200-5)/5), 13, (200-5)/5, 20);
			}
			if (powerup==5) {
				win.setColor(Color.blue);
				win.fillRect(13, 13, (200-5)/5, 20);
				win.fillRect(13+((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+2*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+3*((200-5)/5), 13, (200-5)/5, 20);
				win.fillRect(13+4*((200-5)/5), 13, (200-5)/5, 20);
			}
			
			//area 51
			//troll face offset x by 460 and y by 345
			//win.setColor(Color.yellow);
			//win.fillRect(460, 345, 40, 40);
			
			scoreboard = score;
			//don't touch the shit down below here
			for (int k= 0; k<=particlecount-1; k++) {
				test1[k].moveparticlefast(win,k);
			
			}
			for (int p = 0; p<50; p++) {
				if (ammunition[p].getY()<=-232) {
					
				}
			}
			
			//resets location of stars
			for (int e = 0; e<=particlecount-1; e++) {
				if (test1[e].getY()>=800) {
					Random variable = new Random();
					int newyloc = variable.nextInt(800);
					test1[e]= new topdownparticles(newyloc);
					test1[e].moveparticlefast(win, e);
				}
				
			}
			if (health <=0) {
				gamestate = 69;
			}
			if(GameDriverV4.Keys[KeyEvent.VK_9]) {
				gamestate= 69;
			}
			
			//game level stuff goes right here
			
			
			
			
			

		}
		if (gamestate == 69) {
			this.Splash(win);
			speedo = 5;
			spacex = 25;
			spacex_ = 25;
			spacey = 480;
			spacey_=480;
			particlecount = 200;
			sidetranslator = 7;
			verttrasnslator = 5;
			angle = 0;
			whichone = 0;
			//
			bru.y = -400;
			//
			
			level = 0;
			health = 100;
			killcount = 0;
			bosshealth = 100;
			powerup = 0;
			lockedandloaded = false;
			
			if (scoreboard>=firstplace) {
				thirdplace = secondplace;
				secondplace = firstplace;
				firstplace = scoreboard;
				System.out.println("Run1");
				System.out.println(firstplace);
				System.out.println(secondplace);
				scoreboard = 0;
				
			}
			else if (scoreboard>=secondplace) {
				thirdplace = secondplace;
				secondplace = scoreboard;
				System.out.println("Run2");
				scoreboard = 0;
			}
			else if(scoreboard >=thirdplace) {
				thirdplace = scoreboard;
				System.out.println("Run3");
				scoreboard = 0;
			}
			Font font4 = new Font("Kokonor Regular",Font.BOLD,40);
			win.setFont(font4);
			
			win.setColor(Color.YELLOW);
			win.drawString("That's my polygon get trolled", 90, 35);
			win.drawString("Firstplace score:"+firstplace, 265, 150);
			win.drawString("Secondplace score:"+secondplace, 265, 200);
			win.drawString("Thirdplace Score:"+thirdplace, 265,250);
			poly.draw(win);
			win.setColor(Color.YELLOW);
			
			win.drawString("Leaderboard", 265, 100);
			
			
			AffineTransform trans = win.getTransform();
			//win.rotate(this.getAngle(ms), this.getCenterX(), this.getCenterY());
			//win.setColor(col);
			//win.fill(this);
			win.setColor(Color.pink);
			theta = theta+0.1;
			win.rotate(theta,400,400);
			//win.fillRect(300, 300,200,200);
			win.drawImage(bossface, null, -50,30);
			win.setTransform(trans);
			if (GameDriverV4.Keys[KeyEvent.VK_E]) {
				gamestate = 0;
			}
			
			
		}
		
		if (gamestate == 0) {
			this.Splash(win);
			
			poly.draw(win);
			win.drawImage(bck, null, 0,0);
			win.drawImage(intro, null, -80, -150);
			win.drawImage(intro2, null, -70, 100);
			//this.kenalyn(e);
			//apr.playmain();
			/*
			Graphics g;
			FontMetrics metrics = g.getFontMetrics(getFont());
			*/
			this.setBackGroundColor(Color.BLACK);
			Font font = new Font("Trattatello", Font.BOLD, 40);
			Font font1 = new Font("Luminari", Font.BOLD,30);
			win.setFont(font);
			win.setColor(Color.yellow);
			//win.drawString("Blast those Alien Scums", 225, 200);
			win.setFont(font1);
			//win.drawString("Press Enter to start", 250, 350);
			//win.drawString("Press 'O' for Options", 250, 400);
			//win.drawString("Press 'H' for Help", 250, 450);
			if (GameDriverV4.Keys[KeyEvent.VK_O]) {						//goes to option oage
				gamestate = 3;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_H]) {						//goes to help page
				gamestate = 2;
			}
			if (GameDriverV4.Keys[KeyEvent.VK_ENTER]) {					//goes to the actual game
				gamestate = 1;
			}
			win.drawImage(shooter, null, spacex_ ,spacey_);
			//450 left
			//480 bottom
			//320 right
			//233 top
			
		
			spacex_ = spacex_+sidetranslator;
			spacey_ = spacey_+verttrasnslator;
			
			
			
			if (spacex_>=320) {
				spacex_ = 318;
				sidetranslator = -1*Math.abs(sidetranslator);
				
			}
			if (spacex_<=-450) {
				sidetranslator = Math.abs(sidetranslator);
			}
			if (spacey_>=480) {
				spacey_=479;
				verttrasnslator = -1*Math.abs(verttrasnslator);
				
			}
			if (spacey_<=-233) {
				spacey_ = -230;
				verttrasnslator = Math.abs(verttrasnslator);
			}
			
			tesst.move(win);
		}
		
		
		

		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
