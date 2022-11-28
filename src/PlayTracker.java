import java.util.ArrayList;
import java.util.Stack;

import javax.swing.ImageIcon;

//this stores all the non JComponent data. Each JComponent refers to this data so I just need to repaint.

public class PlayTracker {
	
	private int deckCount;
	private ArrayList<Stack<Integer>> stackTracker; //tracks what has been played
	private ImageIcon[] iconsToDisplayOnStacks;
	private ImageIcon club, diamond, heart, spade;
	private Deck deck;

	public PlayTracker(Deck deck) {	//don't need numPlayers
		
		this.deck = deck; 
		
		createStackTracker();
		setIconsToDisplayOnStacks();
	}
	
	private void setIconsToDisplayOnStacks() {		//sets initial icons
		club = CardImages.clubCard;
		diamond = CardImages.diamondCard;
		heart = CardImages.heartCard;
		spade = CardImages.spadeCard;
		
		iconsToDisplayOnStacks = new ImageIcon[4];

		iconsToDisplayOnStacks[0] = club;
		iconsToDisplayOnStacks[1] = diamond;
		iconsToDisplayOnStacks[2] = heart;
		iconsToDisplayOnStacks[3] = spade;
	}
	
	public void createStackTracker() {
		stackTracker = new ArrayList<Stack<Integer>>();

		for(int suit = 0; suit < 4; suit++)
			stackTracker.add(new Stack<Integer>());  //creates the stacks
		
		for(int suit = 0; suit < 4; suit++)		
			stackTracker.get(suit).add(-1);		//sets to -1 bc first card to play is 0
	}
	
	public boolean play(Card card) {
		
		boolean playable = false;

		int value = card.getValue();
		int suit = card.getSuit();
				
		if(value == stackTracker.get(suit).peek()+1) {  //goes to the correct stack, peeks at the card and then checks it's the next number
			playable = true;
			stackTracker.get(suit).push(value);
			iconsToDisplayOnStacks[suit] = CardImages.verticalImages[suit][value]; //updatesIconsToDisplay
		}
		return playable;
	}
	
	public ImageIcon getIconToDisplayOnStacks(int suit) {
		return iconsToDisplayOnStacks[suit];
	}
	
	public int getDeckCount() {
		return deck.getDeckSize();
	}
}
