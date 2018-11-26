package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Character {
	
	private BufferedImage sprite=null;
	Point position;
	private String name;
	Random rand = new Random();
	
	public Character() {
		position=new Point(0, 0);
	}
	
	public Character(Point position, String name) {
		this.position=new Point(position);
		this.name=name;
	}
	
	public Character(BufferedImage sprite) {
		this.sprite=sprite;
		position=new Point(0, 0);
	}
	
	public void drawCharacter(Graphics g) {

		if(sprite!=null)
			g.drawImage(sprite, (int)position.getX(), (int)position.getY(), Settings.getCharacterWidth(), Settings.getCharacterHeight(), null );
		else
			g.drawRoundRect((int)position.getX(), (int)position.getY(), Settings.getCharacterWidth(), Settings.getCharacterHeight(), 10, 10);
	}
	
	public void setPosition(Point position) {
		this.position=new Point(position);
	}
	
	public Point getPosition() {return position;}
	
	public void setSprite(BufferedImage sprite) {
		this.sprite=sprite;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public void setName(String nmae) {this.name=name;}
	
	public void moveRandomly(World world) {
		int direction = rand.nextInt(4);
		int move=Settings.getMove();
		int tileSize=Settings.getTileSize();
		Point dimensions = new Point(Settings.getCharacterWidth(), Settings.getCharacterHeight());
		
		if(position.getY()-move>=0 && direction==0) {
			if(world.isEmpty(new Point((int)position.getX()/tileSize, (int)(position.getY()-move)/tileSize), dimensions))
				setPosition(new Point((int)position.getX(), (int)(position.getY()-move)));
		}else if(position.getY()+move<=Settings.getHeight() && direction ==1) {
			if(world.isEmpty(new Point((int)position.getX()/tileSize, (int)(position.getY()+Settings.getCharacterHeight()+move)/tileSize), dimensions))
				setPosition(new Point((int)position.getX(), (int)(position.getY()+move)));
		}
		else if(position.getX()-move>=0 && direction ==2) {
			if(world.isEmpty(new Point((int)(position.getX()-move)/tileSize, (int)(position.getY()/tileSize)), dimensions))
				setPosition(new Point((int)position.getX()-move, (int)(position.getY())));
		}
		else if(position.getX()-move<=Settings.getWidth() && direction == 3) {
			if(world.isEmpty(new Point((int)(position.getX()+Settings.getCharacterWidth()+move)/tileSize, (int)(position.getY()/tileSize)), dimensions))
				setPosition(new Point((int)position.getX()+move, (int)(position.getY())));
		}
	}
}
