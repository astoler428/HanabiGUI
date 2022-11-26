import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;

import javax.swing.JLabel;

public class NorthHandPanel extends VerticalHandPanel {


	public NorthHandPanel(Player player) {
		super(player);
		
		this.add(name);

		for(int idx = hand.size() - 1; idx >= 0; idx--) {	//move this to constructor for all four
			CardLabel slot = slots.get(idx);
			this.add(slot);
		}
		
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
	}
}
