package game;

import javax.swing.JFrame;

public class Application extends JFrame {
	GamePanel game;
	
	public Application() {
		setSize(Settings.getWidth(), Settings.getHeight()+Settings.getBottomMenuHeight());
		setTitle("Game");
		
		game = new GamePanel();
		add(game);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		game.run();
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);
		while(true)
			app.run();
	}
}
