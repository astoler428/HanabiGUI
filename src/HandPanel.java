import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

//parent class that has common features of any hand to be displayed. A list of JLabels that will be set to card icons
//which orientation and order they are displayed is unique to the location

public class HandPanel extends JPanel {		//come back and add clues here

	//idea here is to pass in actionListeners
	//may have to make a special label that stores a player whose card it is and a player who has access to card
	//in this case players card is player, and player who has access is selfPlayer in the gamepanel class that created this.
	protected ArrayList<JLabel> slots;
	protected LinkedList<Card> hand;
	protected JLabel name;
	protected Player player; //this is the player whose hand it is. I might have to also pass in selfplayer of who is waching these hands
	 
	public HandPanel(Player player) {
		
		setLayout(new FlowLayout());
		
		hand = player.getHand();
		name = new JLabel("Player #" + (player.getID() + 1));
		
		name.setForeground(Color.orange);
		name.setFont(new Font("Ariel", Font.BOLD, 15));
		
		this.player = player;

		slots = new ArrayList<>();
		
		for(int i = 0; i < hand.size(); i++)
			slots.add(new JLabel());
		
		setIcons();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		setIcons();
	}
	
	public void setIcons(){} //polymorphism for each class
	
	public Player getPlayer() {
		return player;
	}
}
