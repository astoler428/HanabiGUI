import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

//this class stores the center of the gamePanel containing the play area, discard area, tracker area and take action areas.
public class DisplayPanel extends JPanel {

	private PlayPanel playPanel;
	private DiscardPanel discardPanel;
	private CluePanel cluePanel;
	
	private JPanel boxPanelEast, boxPanelNorth, boxPanelCenter;
	
	public DisplayPanel(PlayPanel playPan, DiscardPanel discardPan, CluePanel cluePan) {
		playPanel = playPan;
		discardPanel = discardPan;
		cluePanel = cluePan;

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
		
		//putting clue area into box Layout to center it

		boxPanelCenter = new JPanel();
		boxPanelCenter.setLayout(new BoxLayout(boxPanelCenter,BoxLayout.X_AXIS));
		boxPanelCenter.add(Box.createHorizontalGlue());
		boxPanelCenter.add(cluePanel);
		
		this.add(boxPanelCenter, BorderLayout.CENTER);
		
	}
}
