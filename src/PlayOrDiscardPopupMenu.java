import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PlayOrDiscardPopupMenu extends JPopupMenu {
	
	JMenuItem play;
	JMenuItem discard;

	public PlayOrDiscardPopupMenu(ActionListener playListener, ActionListener discardListener) {

		this.setPreferredSize(new Dimension(80, 80));

		play = new JMenuItem("Play");
		discard = new JMenuItem("Discard");
		play.setBackground(Color.magenta);
		discard.setBackground(Color.cyan);
		play.addActionListener(playListener);
		discard.addActionListener(discardListener);

		add(play);
		add(discard);
	}
	
	public void takeAwayDiscard() {
		discard.setVisible(false);
	}
	
	public void addDiscardBack() {
		discard.setVisible(true);
	}
}
