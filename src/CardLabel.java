import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

//JLabel that will hold the image that gets printed for each hand
//Also store the player and slot number

public class CardLabel extends JLabel {

	private Player selfPlayer; //player who the card belongs to
	private int slotNum;
	// private Card card;  don't think I actually need this info, since player and slot number can get the card
	
	public CardLabel(Player player, int slotNum) {
		
		this.selfPlayer = player;
		this.slotNum = slotNum;
		
		setFont(new Font("Ariel", Font.PLAIN, 25));
		setForeground(Color.green);
	}

	public Player getPlayer() {
		return selfPlayer;
	}

	public int getSlotNum() {
		return slotNum;
	}

}
