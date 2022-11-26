import javax.swing.ImageIcon;

public class Card {
	
	//every card has a value 0-4, suit 0-3 and holds two of its image, one horizontal and one vertical

	private int value; //0-4
	private int suit; //0 = club //1 = diamond //2 = heart //3 = spade
	private String suitName;
	private boolean cluedSuit, cluedValue;
	private ImageIcon hImage, vImage;
	
	
		
	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
		cluedSuit = false;
		cluedValue= false;
		
		setSuitName();
		
		setImages();
	}
	
	private void setSuitName() {
		switch(suit) {
		
		case 0: suitName = "C";
			break;
			
		case 1: suitName = "D";
			break;
		
		case 2: suitName = "H";
			break;
		
		case 3: suitName = "S";
			break;
		}
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
	
	public String getSuitName() {
		return suitName;
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