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
	
	public void setIcons(){								//sets the icon, but doesn't add it to panel
		for(int idx = 0; idx < slots.size(); idx++) {
			Card card = hand.get(idx);
			JLabel slot = slots.get(idx);
			slot.setIcon(card.getVerticalImage());
			
			if(card.isClued())
				slot.setBorder(BorderFactory.createLineBorder(Color.blue));
		}
		
		
	}

}