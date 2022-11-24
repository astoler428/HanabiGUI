import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JLabel;

public class HorizontalHandPanel extends HandPanel {
	
	public HorizontalHandPanel(Player player) {
		super(player);	
		setPreferredSize(new Dimension(150, 400));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		setIcons();
	}
	
	public void setIcons(){
		for(int idx = 0; idx < slots.size(); idx++) {
			Card card = hand.get(idx);
			JLabel slot = slots.get(idx);
			slot.setIcon(card.getHorizontalImage());
		}		
	}

}
