import javax.swing.ImageIcon;

public class Card {

	private int value; //0-4
	private int suit; //0 = club //1 = diamond //2 = heart //3 = spade
	private boolean cluedSuit, cluedValue;
	private ImageIcon hImage, vImage;
	
		
	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
		cluedSuit = false;
		cluedValue= false;
		
		setImages();
	}
	
	private void setImages() {
		vImage = CardImages.verticalImages[suit][value];
		hImage = CardImages.horizontalImages[suit][value];
	}
	
	public ImageIcon getHorizontalImage() {
		return hImage;
	}
	
	public ImageIcon getVerticalImage() {
		return vImage;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public boolean isCluedSuit() {
		return cluedSuit;
	}
	
	public boolean isCluedValue() {
		return cluedValue;
	}
	
	public boolean isClued() {
		return cluedValue || cluedSuit;
	}
	
	public void clueValue() {
		cluedValue = true;
	}
	
	public void clueSuit() {
		cluedSuit = true;
	}
	
	public void unClue() {
		cluedSuit = false;
		cluedValue = false;
	}	
	
//	public static void main(String[] args) {
//		Card c = new Card(2, 3);
//		System.out.println(c.vImage);
//	}
}	