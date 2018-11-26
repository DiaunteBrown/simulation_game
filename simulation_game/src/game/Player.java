package game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Character {

	public Player(BufferedImage sprite) {
		super(sprite);
		setPosition(new Point(Settings.getWidth()/2, Settings.getHeight()/2));
	}
	
	public Player() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/pictures/character.png"));
		} catch (IOException e) {}
		setSprite(img);
		setPosition(new Point(Settings.getWidth()/2, Settings.getHeight()/2));
	}
	
	public void keyEvent(KeyEvent k) {
		
		int move=Settings.getMove();
		
		if((k.getKeyCode()==KeyEvent.VK_UP || k.getKeyChar()=='w') && (position.getY()-move>=0)) {
			setPosition(new Point((int)position.getX(), (int)(position.getY()-move)));
		}
		else if((k.getKeyCode()==KeyEvent.VK_DOWN || k.getKeyChar()=='s')&& (position.getY()+move<=800)) {
			setPosition(new Point((int)position.getX(), (int)(position.getY()+move)));
		}
		else if((k.getKeyCode()==KeyEvent.VK_LEFT || k.getKeyChar()=='a')&& (position.getX()-move>=0)) {
			setPosition(new Point((int)position.getX()-move, (int)(position.getY())));
		}
		else if((k.getKeyCode()==KeyEvent.VK_RIGHT || k.getKeyChar()=='d')&& (position.getX()-move<=800)) {
			setPosition(new Point((int)position.getX()+move, (int)(position.getY())));
		}
	}
	
}
