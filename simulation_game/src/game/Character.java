package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Character {
	
	private BufferedImage sprite=null;
	Point position;
	private String name;
	
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
}
