import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> theDeck;
	protected static final int[] numCopies = {3, 2, 2, 2, 1}; //stores how many of each value there are 3, 2, 2, 2, 1
	private final int NUM_SUITS = 4;
	private final int NUM_VALUES = 5;
	private Random rand = new Random();

	
	public Deck() {
		theDeck = new ArrayList<Card>();
		createDeck();
	}
	
	public void createDeck() {
		
		for(int suit = 0; suit < NUM_SUITS; suit++)  //goes through each color from the array
			for(int value = 0; value < NUM_VALUES; value++)		//goes through each value
				for(int idx = 0; idx < numCopies[value]; idx++)	//for each value, repeat the number of times based on the valueCount
						theDeck.add(new Card(value, suit));
		
		shuffle();
	}
	
	public int getNumCopies(int value) {  //tells you how many copies of the card exist
		return numCopies[value];
	}
	
	public Card draw(Player player) {		
		
		if(theDeck.isEmpty())
			return null;
		
		Card c = theDeck.remove(theDeck.size()-1);
		player.addtoHand(c);
		
		return c;
	}
	
	private void shuffle() {
		for(int idx = 0; idx < theDeck.size(); idx++) {
			Card temp = theDeck.get(idx);
			int spot = rand.nextInt(0, theDeck.size());
			theDeck.set(idx, theDeck.get(spot));
			theDeck.set(spot, temp);
		}
	}
	
	public int getDeckSize() {
		return theDeck.size();
	}
	
	public boolean isEmpty() {
		return theDeck.isEmpty();
	}
}