import java.awt.event.MouseListener;

import javax.swing.JPopupMenu;

//unique subclass of verticalHandPanel that overides setIcons() to be the backs of cards

public class SouthHandPanel extends VerticalHandPanel {
	
	JPopupMenu popMenu; //move this

	public SouthHandPanel(Player player, JPopupMenu pop, MouseListener clickListener) {	//takes in a popupMenu. The MenuItems were added previously
		super(player);
		
		this.add(name);
		this.popMenu = pop;

		for (int idx = 0; idx < hand.size(); idx++) {
			CardLabel slot = slots.get(idx);
			slot.addMouseListener(clickListener);
			this.add(slot);
		}
		
		//move some of this...
		
		this.add(pop);
		
		
	}

	public void setIcons() {

		for (int idx = 0; idx < slots.size(); idx++) {
			CardLabel slot = slots.get(idx);
			slot.setIcon(CardImages.cardBack);
			
			Card card = hand.get(idx);
			
			displayClue(card, slot);
		}

	}
	
}
