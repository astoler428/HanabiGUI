import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

//this class takes in a display panel, which is a complex object on it's own and places it at the center
//it then builds the hands for all the players, starting with yourself

public class GamePanel extends JPanel {

	private SouthHandPanel southHandPanel;
	private WestHandPanel westHandPanel;
	private NorthHandPanel northHandPanel;
	private EastHandPanel eastHandPanel;
	private List<HandPanel> listOfHandPanels;
	private Player selfPlayer;
	private Player[] listOfPlayers;
	private DisplayPanel displayPanel;
	private JPopupMenu popMenu;
	private MouseListener clickListener;

	public GamePanel(DisplayPanel displayPanel, Player selfPlayer, Player[] listPlayers, JPopupMenu popMenu, MouseListener clickListener) {
		this.displayPanel = displayPanel;
		this.selfPlayer = selfPlayer;
		this.popMenu = popMenu;
		this.clickListener = clickListener;	//takes in clickListener and passes it into southHandPanel
		
		this.setLayout(new BorderLayout(10, 5));
		this.setPreferredSize(new Dimension(1100, 800));
		this.add(displayPanel, BorderLayout.CENTER);

		makeListOfPlayers(listPlayers); // takes the list and reorders it so self is first
		setHandLocations();
	}

	private void makeListOfPlayers(Player[] listPlayers) {	//this method makes a new list of players that begins with self
	
		listOfPlayers = new Player[listPlayers.length];

		int start = selfPlayer.getID();
		int numPlayers = listPlayers.length;

		for (int idx = 0; idx < numPlayers; idx++) 
			 listOfPlayers[idx] = listPlayers[(idx + start) % numPlayers];
	}

	private void setHandLocations() {	//sets the hands in the correct location based on the number of players

		listOfHandPanels = new ArrayList<>();

		southHandPanel = new SouthHandPanel(selfPlayer, popMenu, clickListener);
		listOfHandPanels.add(southHandPanel);

		this.add(southHandPanel, BorderLayout.SOUTH);
		
		switch (listOfPlayers.length) {

		case 2:
			northHandPanel = new NorthHandPanel(listOfPlayers[1]);
			this.add(northHandPanel, BorderLayout.NORTH);
			listOfHandPanels.add(northHandPanel);
			break;

		case 3:
			westHandPanel = new WestHandPanel(listOfPlayers[1]);
			northHandPanel = new NorthHandPanel(listOfPlayers[2]);
			this.add(westHandPanel, BorderLayout.WEST);
			this.add(northHandPanel, BorderLayout.NORTH);
			listOfHandPanels.add(westHandPanel);
			listOfHandPanels.add(northHandPanel);

			break;
			
		case 4:
			westHandPanel = new WestHandPanel(listOfPlayers[1]);
			northHandPanel = new NorthHandPanel(listOfPlayers[2]);
			eastHandPanel = new EastHandPanel(listOfPlayers[3]); 
			this.add(westHandPanel, BorderLayout.WEST);
			this.add(northHandPanel, BorderLayout.NORTH);
			this.add(eastHandPanel, BorderLayout.EAST);
			listOfHandPanels.add(westHandPanel);
			listOfHandPanels.add(northHandPanel);
			listOfHandPanels.add(eastHandPanel);
			
			break;
		}
	}
	
	public void paintComponent(Graphics g) {				//place these in their respective classes' paintComponents
		super.paintComponent(g);
		//displayPanel.repaint();
		for(int idx = 0; idx < listOfHandPanels.size(); idx++)
			listOfHandPanels.get(idx).repaint();
	}
}
