import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

//parent class that has common features of any hand to be displayed. A list of JLabels that will be set to card icons
//which orientation and order they are displayed is unique to the location

public class HandPanel extends JPanel {		

	//idea here is to pass in actionListeners
	//may have to make a special label that stores a player whose card it is and a player who has access to card

	protected ArrayList<CardLabel> slots;
	protected LinkedList<Card> hand;
	protected JLabel name;
	protected Player selfPlayer; //this is the player whose hand it is. I might have to also pass in selfplayer of who is waching these hands
	 
	public HandPanel(Player player) {
		
		setLayout(new FlowLayout());
		
		hand = player.getHand();
		name = new JLabel(player.getName());
		
		name.setForeground(Color.orange);
		name.setFont(new Font("Ariel", Font.BOLD, 15));
		
		selfPlayer = player;

		slots = new ArrayList<>();
		
		createSlotLabels();
		setIcons();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		setIcons();
		borderPlayersTurn();
	}
	
	public void setIcons(){} //polymorphism for each class
	
	private void createSlotLabels() {
		for (int i = 0; i < hand.size(); i++) { 
			slots.add(new CardLabel(selfPlayer, i));
			slots.get(i).setHorizontalTextPosition(JLabel.CENTER);
			slots.get(i).setVerticalTextPosition(JLabel.CENTER);
		}
		
	}
	
	private void borderPlayersTurn() {					
		if(selfPlayer.isTurn())
			name.setBorder(BorderFactory.createLineBorder(Color.pink));
		else
			name.setBorder(null);
	}
	
	public Player getPlayer() {
		return selfPlayer;
	}
	
	public JLabel getNameLabel() {
		return name;
	}
}
