import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

//This border layout container holds a few components
//1. The gamePanel, which takes up most of the board
//2. The log and tracker, which is on the East border stacked vertically

public class HanabiGameFrame extends JFrame {
	
	String title;
	GamePanel gamePanel;
	LogPanel log;
	TrackerPanel trackerPanel;
	JPanel eastPanel;
	
	public HanabiGameFrame(String title, GamePanel gamePanel, LogPanel log, TrackerPanel trackerPanel) {
		
		this.setTitle(title);
		this.gamePanel = gamePanel;
		this.log = log;
		this.trackerPanel = trackerPanel;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new FlowLayout());
		eastPanel.setPreferredSize(new Dimension(200, 600));
		eastPanel.add(log);
		eastPanel.add(trackerPanel);
		
		this.add(eastPanel, BorderLayout.EAST);
		this.add(gamePanel, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
}
