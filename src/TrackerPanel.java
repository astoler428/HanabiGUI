import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrackerPanel extends JPanel {
	
	Tracker tracker;
	JLabel clues, points, strikes;
	
	public TrackerPanel(Tracker tracker) {
		this.tracker = tracker;
		
		clues = new JLabel("Clues: " + tracker.getClues());
		clues.setFont(new Font("Ariel", Font.BOLD, 20));
		clues.setHorizontalAlignment(JLabel.CENTER);
		points = new JLabel("Points: " + tracker.getPoints());
		points.setFont(new Font("Ariel", Font.BOLD, 20));
		points.setHorizontalAlignment(JLabel.CENTER);
		strikes = new JLabel("Strikes: " + tracker.getStrikes());
		strikes.setFont(new Font("Ariel", Font.BOLD, 20));
		strikes.setHorizontalAlignment(JLabel.CENTER);
		
		this.setLayout(new GridLayout(3,1));
		this.setPreferredSize(new Dimension(150, 150));
		//this.setSize(getPreferredSize()); //don't use set size since it's going into a flow layout...east panel
		this.setBackground(Color.blue);
		
		this.add(clues);
		this.add(points);
		this.add(strikes);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		clues.setText("Clues: " + tracker.getClues());
		points.setText("Points: " + tracker.getPoints());
		strikes.setText("Strikes: " + tracker.getStrikes());
		
	}
	
	public static void main(String[] args) {
		
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1400, 750);
			TrackerPanel tp = new TrackerPanel(new Tracker());
			frame.add(tp);
			frame.pack();
			frame.setVisible(true);
			
		}

}
