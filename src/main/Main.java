package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static JFrame window;
	
	public static void main(String[] args) {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Emoji Guy: Moon Field");
		new Main().setIcon();

		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);

		gamePanel.config.loadConfig();
		if (gamePanel.fullScreenOn == true) {
			window.setUndecorated(true);
		}
		
		window.pack();
		
		gamePanel.setUpGame();
		gamePanel.startGameThread();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public void setIcon() {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("player/EG_Down_1.png"));
		window.setIconImage(icon.getImage());
	}
	
}
