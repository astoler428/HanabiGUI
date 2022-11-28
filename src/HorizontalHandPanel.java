import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

//this is a subclass of HandPanel that uses the horizontal image of cards

public class HorizontalHandPanel extends HandPanel {
	
	public HorizontalHandPanel(Player player) {
		super(player);	
		setPreferredSize(new Dimension(150, 400));
	}
	
	public void setIcons(){								//sets the icon, but doesn't add it to panel
		for(int idx = 0; idx < hand.size(); idx++) {
			Card card = hand.get(idx);
			CardLabel slot = slots.get(idx);
			slot.setIcon(card.getHorizontalImage());
			displayClue(card, slot);
		}
		
		if(hand.size() < slots.size()) {	//last turn and played a card, remove last slot and remove it from panel
			slots.remove(slots.size()-1);
			this.remove(slots.size()-1);
		}
	}
	
	protected void displayClue(Card card, CardLabel slot) {
		
		String clue = "";

		if(card.isClued()) {
			slot.setBorder(BorderFactory.createLineBorder(Color.blue));
			
			if(card.isCluedValue()) 
				clue += Integer.toString(card.getValue()+1);	//edit this to format nicer
			if(card.isCluedSuit())
				clue += card.getSuitName();
			
		}
		else
			slot.setBorder(null);
		
		slot.setText(clue);
	}

}
