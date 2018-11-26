package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	Player player = new Player();
	World world = new World();
	long startTime;
	double estimatedTimeSeconds;
	Character testNPC = new Character();
	
	public enum GameState {
	    TITLE_STATE,
	    RUNNING;
	}
	
	public GamePanel() {
		addKeyListener(this);
		setBackground(new Color(64, 64, 64));
		setDoubleBuffered(true);
		setFocusable(true);
		
		repaint();
		
		gameSetup();
	}
	
	private void gameSetup() {
		startTime = System.nanoTime();
		world.addCharacter(player);
		world.addCharacter(testNPC);
	}
	
	public void gameManager(Graphics g) {
		world.drawCharacters(g);
		estimatedTimeSeconds = (System.nanoTime()-startTime)*Math.pow(10, -9);
		
		ViewWindowLogic.updateCollision(world);
		
		//System.out.println(estimatedTimeSeconds);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		gameManager(g);
		ViewWindowLogic.updateCollision(world);
		world.testDrawWorld(g);
	}

	@Override
	public void keyPressed(KeyEvent k) {
		player.keyEvent(k, world);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}
