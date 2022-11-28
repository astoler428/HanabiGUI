import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

//this is a subclass of HandPanel that uses the vertical image of cards

public class VerticalHandPanel extends HandPanel {

	public VerticalHandPanel(Player player) {
		super(player);
		setPreferredSize(new Dimension(400, 150));
	}

	public void setIcons() { // sets the icon, but doesn't add it to panel
		for (int idx = 0; idx < hand.size(); idx++) {
			Card card = hand.get(idx);
			CardLabel slot = slots.get(idx);
			slot.setIcon(card.getVerticalImage());

			displayClue(card, slot);
		}

		if (hand.size() < slots.size()) { // last turn and played a card
			slots.remove(slots.size() - 1);
			this.remove(slots.size() - 1);
		}
	}

	protected void displayClue(Card card, CardLabel slot) {

		String clue = "";

		if (card.isClued()) {
			slot.setBorder(BorderFactory.createLineBorder(Color.blue));

			if (card.isCluedValue())
				clue += Integer.toString(card.getValue() + 1); // edit this to format nicer
			if (card.isCluedSuit())
				clue += card.getSuitName();
		} else
			slot.setBorder(null);

		slot.setText(clue);
	}
}