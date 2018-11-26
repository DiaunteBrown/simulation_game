package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class World {
	Tile tiles[][];
	List<Character> characters = new ArrayList<Character>();
	int width=Settings.getWidth()/Settings.getTileSize();
	int height=Settings.getHeight()/Settings.getTileSize();
	public World() {
		tiles = new Tile[width][height];
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				tiles[x][y] = new Tile();
			}
		}
	}
	
	public void drawCharacters(Graphics g) {
		for(int i=0; i<characters.size(); i++)
			characters.get(i).drawCharacter(g);
	}
	
	public void addCharacter(Character character) {
		characters.add(character);
	}
	
	public List<Character> getCharacters(){return characters;}
	
	public Tile[][] getTiles(){return tiles;}
	
	public boolean isEmpty(Point position) {
		
		return tiles[(int) position.getX()][(int) position.getY()].isEmpty();
	}
	
	public void testDrawWorld() {
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				if(tiles[x][y].isEmpty())
					System.out.print("-");
				else
					System.out.print("X");
			}
			System.out.println("");
		}
	}
	
	public void testDrawWorld(Graphics g) {
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				if(tiles[x][y].isEmpty())
					g.setColor(Color.blue);
				else
					g.setColor(Color.RED);
				
				g.drawRect(x*Settings.getTileSize(), y*Settings.getTileSize(), Settings.getTileSize(), Settings.getTileSize());
			}
		}
	}
}
