import java.util.LinkedList;

public class Player {
	
	//players can play, clue, discard
	//players don't draw
	
	private LinkedList<Card> hand;
	private boolean isTurn;
	private final int id;
	
	
	
	public Player(int playerNumber) {
		hand = new LinkedList<Card>();
		id = playerNumber;
		isTurn = false;
	}
	
	public boolean isTurn() {
		return isTurn;
	}
	
	public void setTurn(boolean turn) {
		isTurn = turn;
	}
	
	public int getID() {
		return id;
	}
	
	public int getHandSize() {
		return hand.size();
	}
	
	public Card getCardAt(int slot) {  //returns the card at a particular slot
		return hand.get(slot);
	}
	
	public void addtoHand(Card c) {
		hand.add(0, c);
	}
	
	public Card removefromHand(int slot) {	 //removes the card and returns it
		return hand.remove(slot);
		
	}
	
	public LinkedList<Card> getHand(){
		return hand;
	}
	
	public void receiveValueClue(int value) {
		for(int i = 0; i < hand.size(); i++) {
			Card c = hand.get(i);
			
			if(c.getValue() == value)
				c.clueValue();
		}		
	}
	
	public void receiveSuitClue(int suit) {
		for(int i = 0; i < hand.size(); i++) {
			Card c = hand.get(i);
			
			if(c.getSuit() == suit)
				c.clueSuit();
		}		
	}
	
//	public String toString() {
//		
//		String toReturn = "";
//		
//		if(!isTurn)
//			for(int i = 0; i < hand.size(); i++)
//				toReturn = hand.get(i) + " " + toReturn;
//		
//		else {
//			for(int i = 0; i < hand.size(); i++) {
//				Card c = hand.get(i);
//				if(c.isCluedColor() && c.isCluedValue())
//					toReturn = toReturn + " " + Color.printingColor(c.getColor()) + c.getValue() + Color.ANSI_RESET;
//				else if(c.isCluedColor() && !c.isCluedValue()) {
//					toReturn = toReturn + " " + Color.printingColor(c.getColor()) + "?" + Color.ANSI_RESET;
//				}
//				else if(!c.isCluedColor() && c.isCluedValue())
//					toReturn =  toReturn + " " + c.getValue();
//				else
//					toReturn = toReturn + " ?" ;
//			}
//		}
//		
//		toReturn = "Player #" + id + ": " + toReturn;
//		
//		return toReturn;
//		
//	}
	

	}
