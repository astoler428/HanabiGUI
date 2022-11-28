import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WestHandPanel extends HorizontalHandPanel {

	public WestHandPanel(Player player) {
		super(player);
		
		this.add(name);

		for (int idx = 0; idx < hand.size(); idx++) {
			CardLabel slot = slots.get(idx);
			this.add(slot);
		}
	}
}
