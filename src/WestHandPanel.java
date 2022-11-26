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

//	public static void main(String[] args) {
//		Player p = new Player(0);
//		p.addtoHand(new Card(0, 0));
//		p.addtoHand(new Card(2, 2));
//		p.addtoHand(new Card(1, 3));
//		p.addtoHand(new Card(4, 1));
//		
//	
//
//		HandPanel whp = new NorthHandPanel(p);
//
//		JFrame frame = new JFrame();
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(1200, 750);
//		frame.setLayout(new BorderLayout());
//		frame.add(whp, BorderLayout.NORTH);
//		frame.setVisible(true);
//
//	}

}
