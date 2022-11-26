import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//this class creates the container that holds the button options for giving a clue. There are 5 rows.
//Message to clue, player to clue, value option, suit option, confirm clue
//to keep it organized, i created a grid layout of panels, where each panel is a grid layout

//player is attached to each button so that when a button triggers an actionlistener, i can see which player pressed it since the player represents this particular panel

public class CluePanel extends JPanel {
	
	JLabel clueTitle;
	JRadioButton p1, p2, p3, p4;
	JRadioButton[] arrayOfPlayerButtons;
	JRadioButton val1, val2, val3, val4, val5;
	JRadioButton club, diamond, heart, spade;
	JButton giveClue;
	ButtonGroup playerGroup, clueGroup;
	
	JPanel playerPanel, valuePanel, suitPanel;
	
	Player selfPlayer;
	
	final int BUTTON_HEIGHT = 30;
	final int BUTTON_WIDTH = 60;
	
	
	public CluePanel(Player player, ActionListener playerListener, ActionListener clueListener, ActionListener giveClueListener) {
				
		selfPlayer = player;
		
		this.setLayout(new GridLayout(5,1,0,5));  
		this.setPreferredSize(new Dimension(375, 300));
		this.setBorder(BorderFactory.createLineBorder(Color.magenta));
	
		clueTitle = new JLabel("Give a clue");
		clueTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		clueTitle.setHorizontalAlignment(JLabel.CENTER);
		
		
		playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(1, 4, 5, 0));
		
		p1 = new RadioButton("Player 1", selfPlayer);
		p2 = new RadioButton("Player 2", selfPlayer);
		p3 = new RadioButton("Player 3", selfPlayer);
		p4 = new RadioButton("Player 4", selfPlayer);
		
		
		arrayOfPlayerButtons = new JRadioButton[4];
		arrayOfPlayerButtons[0]= p1;
		arrayOfPlayerButtons[1]= p2;
		arrayOfPlayerButtons[2]= p3;
		arrayOfPlayerButtons[3]= p4;
		
		p1.addActionListener(playerListener);
		p2.addActionListener(playerListener);
		p3.addActionListener(playerListener);
		p4.addActionListener(playerListener);
				
		p1.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT)); //adjust this based on number of players
		p2.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		p3.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		p4.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		
		playerPanel.add(p1);
		playerPanel.add(p2);
		playerPanel.add(p3);
		playerPanel.add(p4);
		
		playerGroup = new ButtonGroup();
		playerGroup.add(p1);
		playerGroup.add(p2);
		playerGroup.add(p3);
		playerGroup.add(p4);
		
		valuePanel = new JPanel();
		valuePanel.setLayout(new GridLayout(1, 5, 5, 0));
		
		val1 = new RadioButton("1", selfPlayer);
		val2 = new RadioButton("2", selfPlayer);
		val3 = new RadioButton("3", selfPlayer);
		val4 = new RadioButton("4", selfPlayer);
		val5 = new RadioButton("5", selfPlayer);
		
		val1.addActionListener(clueListener);
		val2.addActionListener(clueListener);
		val3.addActionListener(clueListener);
		val4.addActionListener(clueListener);
		val5.addActionListener(clueListener);
				
		val1.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val2.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val3.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val4.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val5.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		

		valuePanel.add(val1);
		valuePanel.add(val2);
		valuePanel.add(val3);
		valuePanel.add(val4);
		valuePanel.add(val5);
		
		suitPanel = new JPanel();
		suitPanel.setLayout(new GridLayout(1, 4, 5, 0));
		
//		club = new RadioButton(new ImageIcon(CardImages.club.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)), selfPlayer);
//		diamond = new RadioButton(new ImageIcon(CardImages.diamond.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)), selfPlayer);
//		heart = new RadioButton(new ImageIcon(CardImages.heart.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)), selfPlayer);
//		spade = new RadioButton(new ImageIcon(CardImages.spade.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)), selfPlayer);
		
		club = new RadioButton("Club", selfPlayer);
		diamond = new RadioButton("Diamond", selfPlayer);
		heart = new RadioButton("Heart", selfPlayer);
		spade = new RadioButton("Spade", selfPlayer);
		
		club.addActionListener(clueListener);
		diamond.addActionListener(clueListener);
		heart.addActionListener(clueListener);
		spade.addActionListener(clueListener);

		
		clueGroup = new ButtonGroup();
		clueGroup.add(val1);
		clueGroup.add(val2);
		clueGroup.add(val3);
		clueGroup.add(val4);
		clueGroup.add(val5);
		clueGroup.add(club);
		clueGroup.add(diamond);
		clueGroup.add(heart);
		clueGroup.add(spade);
		
		suitPanel.add(club);
		suitPanel.add(diamond);
		suitPanel.add(heart);
		suitPanel.add(spade);
		
		giveClue = new Button("Give Clue", selfPlayer);
		giveClue.setPreferredSize(new Dimension(4*BUTTON_WIDTH, BUTTON_HEIGHT));
		
		giveClue.addActionListener(giveClueListener);
			
		this.add(clueTitle);
		this.add(playerPanel);
		this.add(valuePanel);
		this.add(suitPanel);
		this.add(giveClue);
	}
	
	public void configureClueButtons(int numPlayers) {		//doesn't display self or less than # players -> decide what to do if no clues
		for(int playerID = 0; playerID < arrayOfPlayerButtons.length; playerID++)
			if(selfPlayer.getID() == playerID || playerID >= numPlayers)
				arrayOfPlayerButtons[playerID].setVisible(false);
	}
	
	public void resetGiveClueButton() {
		giveClue.setText("Give Clue");
		playerGroup.clearSelection();
		clueGroup.clearSelection();
	}
	
	//Can't put update clue visibility in here bc apparently paintComponent won't run if panel is already invisible
	//must first set panel visibility and then repaint.
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
	}

	public void updateCluePanelVisibility() {	
		if(selfPlayer.isTurn()) 
			this.setVisible(true);	
	
		else {
			this.setVisible(false);
			this.resetGiveClueButton();	//in case they pressed it with no clues
		}
		repaint();
	}
	

	
//	public static void main(String[] args) {
//		
//			JFrame frame = new JFrame();
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setSize(new Dimension(600, 750));
//			CluePanel dp = new CluePanel(new Player(0));
//			frame.add(dp);
//			frame.pack();
//			frame.setVisible(true);
//			
//		}

}
