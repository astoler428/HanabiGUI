import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

//this class stores the center of the gamePanel containing the play area, discard area, tracker area and take action areas.
//Since border layout regions have no layout manager, I create a box layout container for each object to get the desired layout
public class DisplayPanel extends JPanel {

	private PlayPanel playPanel;
	private DiscardPanel discardPanel;
	private CluePanel cluePanel;
	private JPanel boxPanelEast, boxPanelNorth, boxPanelCenter;
	private JPanel cardPanel;
	private CardLayout cl;
	
	public DisplayPanel(PlayPanel playPan, DiscardPanel discardPan, CluePanel cluePan) {
		this.playPanel = playPan;
		this.discardPanel = discardPan;
		this.cluePanel = cluePan;

		this.setLayout(new BorderLayout());		
	
		//putting discard into box Layout to lower it
		
		boxPanelEast = new JPanel();
		boxPanelEast.setLayout(new BoxLayout(boxPanelEast,BoxLayout.Y_AXIS));
		boxPanelEast.add(Box.createVerticalGlue());
		boxPanelEast.add(discardPanel);
		this.add(boxPanelEast, BorderLayout.EAST);
		
		//putting play area into box Layout to raise it
		
		boxPanelNorth = new JPanel();
		boxPanelNorth.setLayout(new BoxLayout(boxPanelNorth,BoxLayout.Y_AXIS));
		boxPanelNorth.add(Box.createRigidArea(new Dimension(0, 20)));
		boxPanelNorth.add(playPanel);
		
		this.add(boxPanelNorth, BorderLayout.NORTH);
		
		
		//creating the cardPanel that will hold the two center items - cluePanel and GameOverPanel
		
		cardPanel = new JPanel();
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		//putting clue area into box Layout to center it

		boxPanelCenter = new JPanel();
		boxPanelCenter.setLayout(new BoxLayout(boxPanelCenter,BoxLayout.X_AXIS));
		boxPanelCenter.add(Box.createHorizontalGlue());
		boxPanelCenter.add(cluePanel);
		
		//loading up cardPanel with 2 items
		
		cardPanel.add(boxPanelCenter, "clue");
		cardPanel.add(new GameOverPanel(), "gameOver");
		cl.show(cardPanel, "clue");
		
		this.add(cardPanel, BorderLayout.CENTER);
	}
	
	public void paintComponent(Graphics g) {				//place these in their respective classes' paintComponents
		super.paintComponent(g);
//		playPanel.repaint();
//		discardPanel.repaint();
		cluePanel.updateCluePanelVisibility();
	}
	
	public CluePanel getCluePanel() {
		return cluePanel;
	}
	
	public void displayGameOver() {
		cl.show(cardPanel, "gameOver");

	}
}
