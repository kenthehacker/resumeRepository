/**
 * @(#)GameDriverV4.java
 *
 *
 * updates:  jframe included, keylistener included, switch to render, game loop
 *    from tasktimer to thread  - needs more testing sorry
 * 
 * 
 * @version 4.0 9/13/2018
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
											//i did import in actionlistener and mouselistener
//this is for the simon one

public abstract class GameDriverV4 extends Canvas implements Runnable, KeyListener, ActionListener, MouseListener  {
	
	private int FramesPerSecond;
	private Color backGroundColor = Color.WHITE;
	protected static boolean[] Keys;
	private JFrame frame;
	private String title = "$$$ BLAST THOSE ALIEN SCUMZ $$$";
	private int width = 800, height = 800;
	
	public GameDriverV4(int frames) {
		// set up all variables related to the game
		FramesPerSecond = frames;
		
		this.addKeyListener(this);
		

		
		
		
		// key setup
		Keys = new boolean[KeyEvent.KEY_LAST];
		
		
		
		
	}
	public void changecolorto(Color a) {
		backGroundColor = a;
	}
	public GameDriverV4() {
		// default setting (60 frames per second)
		this(60);
		
		
		
		
	}
	
	public void start() {
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(this);
		frame.setVisible(true);
		frame.addMouseListener(this);					// we did add in the mouselister stuff here
		this.startThread();
		
	}
	
	private synchronized void  startThread() {
		Thread t1 = new Thread(this);
		t1.start(); // calls run method after paint 
		
		
		
		
		
	}
	
	
	public void setFrames(int num) {
		this.FramesPerSecond = num;
	}
	
	
	
	
	
	private void render() {
		
		BufferStrategy buffs = this.getBufferStrategy();
		if (buffs == null) {
			this.createBufferStrategy(3);
			buffs = this.getBufferStrategy();
		}
		
		
		Graphics g = buffs.getDrawGraphics();
		
		g.setColor(this.backGroundColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		draw((Graphics2D) g);
		
		
		g.dispose();
		
		buffs.show();
		
	}
	
	public abstract void draw(Graphics2D win);

	
	 public void run() {
		 
		
		 	this.setFocusable(true);

	        long beforeTime, timeDiff, sleep;

	        beforeTime = System.currentTimeMillis();

	        while (true) {

	            
	            

	            timeDiff = System.currentTimeMillis() - beforeTime;
	            
	            sleep = 1000 / this.FramesPerSecond - timeDiff;

	            if (sleep < 0) {
	                sleep = 2;
	            }

	            try {
	                Thread.sleep(sleep);
	            } catch (InterruptedException e) {
	                
	                String msg = String.format("Thread interrupted: %s", e.getMessage());
	                System.out.println(msg);
	              
	            }
	            
	            render();
	            beforeTime = System.currentTimeMillis();
	        }
	    }
	
	
	public BufferedImage addImage(String name)  {

		BufferedImage img = null;
		try {
		
			img = ImageIO.read(this.getClass().getResource(name));
			
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return img;

	}
	public Color getBackGroundColor() {
		return backGroundColor;
	}
	public void setBackGroundColor(Color backGroundColor) {
		this.backGroundColor = backGroundColor;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Keys[e.getKeyCode()] = true;
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Keys[e.getKeyCode()] = false;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
