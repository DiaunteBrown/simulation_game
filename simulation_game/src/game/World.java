package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class World {
	List<Room> rooms = new ArrayList<Room>();
	int index;
	
	public World() {
		BufferedImage img = null;

		rooms.add(new Room("src/pictures/room1.png", new Point(200, 200), new Point(490, 65)));
		rooms.add(new Room("src/pictures/room2.png", new Point(514, 570), new Point(500, 60)));
		
		index=0;
	}
	
	public Room getRoom() {
		return rooms.get(index);
	}
	
	public void drawRoom(Graphics g) {
		g.drawImage(rooms.get(index).getImage(), 0, 0, 600, 600, null);
	}
	
	public Boolean checkExit(Point playerPosition) {
		if((playerPosition.getX()>=rooms.get(index).getExit().getX()-50)&&(playerPosition.getX()<=rooms.get(index).getExit().getX()+50)){
			if((playerPosition.getY()>=rooms.get(index).getExit().getY()-25)&&(playerPosition.getY()<=rooms.get(index).getExit().getY()+25)){
				return true;
			}
		}
		
		return false;
	}
	
	public void nextRoom() {
		if(index<(rooms.size()-1))
			index++;
		else
			index=0;
	}
}
