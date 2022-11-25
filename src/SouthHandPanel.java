import java.awt.Color;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

//unique subclass of verticalHandPanel that overides setIcons() to be the backs of cards

public class SouthHandPanel extends VerticalHandPanel {

	public SouthHandPanel(Player player) {
		super(player);
		
		this.add(name);

		for (int idx = 0; idx < hand.size(); idx++) {
			JLabel slot = slots.get(idx);
			this.add(slot);
		}
	}

	public void setIcons() {

		for (int idx = 0; idx < slots.size(); idx++) {
			JLabel slot = slots.get(idx);
			slot.setIcon(CardImages.cardBack);
			
			Card card = hand.get(idx);
			
			if(card.isClued())
				slot.setBorder(BorderFactory.createLineBorder(Color.blue));
		}

	}
}
