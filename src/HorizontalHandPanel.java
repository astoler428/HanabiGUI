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
	
	public void paint(Graphics g) {
		super.paint(g);
		
		setIcons();
	}
	
	public void setIcons(){								//sets the icon, but doesn't add it to panel
		for(int idx = 0; idx < slots.size(); idx++) {
			Card card = hand.get(idx);
			JLabel slot = slots.get(idx);
			slot.setIcon(card.getHorizontalImage());
			
			if(card.isClued())
				slot.setBorder(BorderFactory.createLineBorder(Color.blue));
		}		
	}

}
