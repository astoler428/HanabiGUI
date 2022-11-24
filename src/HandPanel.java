import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HandPanel extends JPanel {		//come back and add clues here

	
	ArrayList<JLabel> slots;
	LinkedList<Card> hand;
	JLabel name;
	
	public HandPanel(Player player) {
		
		setLayout(new FlowLayout());
		
		hand = player.getHand();
		name = new JLabel("Player #" + (player.getID() + 1));
		
		name.setForeground(Color.orange);
		name.setFont(new Font("Ariel", Font.BOLD, 15));
		
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
	
}
