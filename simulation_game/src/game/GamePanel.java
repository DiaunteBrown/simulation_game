package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	Player player = new Player();
	World world;
	
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
		
	}
	
	public void gameManager(Graphics g) {
		player.drawCharacter(g);
		testNPC.drawCharacter(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		gameManager(g);
	}

	@Override
	public void keyPressed(KeyEvent k) {
		player.keyEvent(k);

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}
