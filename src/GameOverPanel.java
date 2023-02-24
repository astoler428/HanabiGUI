import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {

	//this needs to be boxlayout 
	//add horizontal glue
	//then add gameOVerPanel
	//matches cluePanel
	
	JPanel gameOverPanel;
	JLabel gameOverLabel;
	
	public GameOverPanel() {
		
		this.setLayout(new  BoxLayout(this,BoxLayout.X_AXIS));
		this.add(Box.createHorizontalGlue());
		
		gameOverLabel = new JLabel("Game Over");
		gameOverLabel.setPreferredSize(new Dimension(350, 250));
		gameOverLabel.setFont(new Font("Ariel", Font.BOLD, 60));
		gameOverLabel.setForeground(Color.yellow);
		
		gameOverPanel = new JPanel();
		gameOverPanel.setBackground(Color.black);
		gameOverPanel.add(gameOverLabel);
		
		this.add(gameOverPanel);
	}
	
}
