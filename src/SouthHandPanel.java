import java.awt.event.MouseListener;

import javax.swing.JPopupMenu;

//unique subclass of verticalHandPanel that overides setIcons() to be the backs of cards

public class SouthHandPanel extends VerticalHandPanel {
	
	JPopupMenu popMenu; //move this

	public SouthHandPanel(Player player, JPopupMenu pop, MouseListener clickListener) {	//takes in a popupMenu. The MenuItems were added previously
		super(player);
		
		this.add(name);
		popMenu = pop;

		for (int idx = 0; idx < hand.size(); idx++) {
			CardLabel slot = slots.get(idx);
			slot.addMouseListener(clickListener);
			this.add(slot);
		}
		this.add(popMenu);
	}

	public void setIcons() {

		for (int idx = 0; idx < hand.size(); idx++) {
			CardLabel slot = slots.get(idx);
			slot.setIcon(CardImages.cardBack);
			
			Card card = hand.get(idx);
			
			displayClue(card, slot);
		}
		
		if(hand.size() < slots.size()) {	//last turn and played a card
			slots.remove(slots.size()-1);
			this.remove(slots.size()-1);
		}
	}
}
