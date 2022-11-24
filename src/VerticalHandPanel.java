import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JLabel;

public class VerticalHandPanel extends HandPanel {
	
	public VerticalHandPanel(Player player) {
		super(player);	
		setPreferredSize(new Dimension(400, 150));

	}
	
	public void setIcons(){
		for(int idx = 0; idx < slots.size(); idx++) {
			Card card = hand.get(idx);
			JLabel slot = slots.get(idx);
			slot.setIcon(card.getVerticalImage());
		}		
	}

}