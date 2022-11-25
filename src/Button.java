import javax.swing.ImageIcon;
import javax.swing.JButton;

//Radio Button that stores a player too;

public class Button extends JButton {
	
	private Player player;
	
	public Button(Player player) {
		this("", player);
	}
	
	public Button(String text, Player player) {
		super(text);
		this.player = player;
	}
	
	public Button(ImageIcon icon, Player player) {
		super(icon);
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}
	

}