import java.util.LinkedList;

import javax.swing.JLabel;

public class EastHandPanel extends HorizontalHandPanel {

	public EastHandPanel(Player player) {
		super(player);

		this.add(name);

		for (int idx = hand.size() - 1; idx >= 0; idx--) {
			CardLabel slot = slots.get(idx);
			this.add(slot);
		}
	}
}
