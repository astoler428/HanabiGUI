import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

//Radio Button that stores a player too;

public class RadioButton extends JRadioButton {
	
	private Player player;
	
	public RadioButton(Player player) {
		this("", player);
	}
	
	public RadioButton(String text, Player player) {
		super(text);
		this.player = player;
	}
	
	public RadioButton(ImageIcon icon, Player player) {
		super(icon);
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}
}
