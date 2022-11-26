import java.util.ArrayList;

public class DiscardTracker {

	private String[] discards; // these will be the strings that the discardLabelTexts are set to.
	private int[][] discardTracker; // tracks copies of each card and is used to check with how many copies there
									// are
	private int maxScore;
	private int[] maxScores = { 5, 5, 5, 5 }; // stores max sore for each color

	public DiscardTracker() {

		discards = new String[4];
		for(int idx = 0; idx < 4; idx++ )		//initializes strings to empty, but not null;
			discards[idx] = ""; 
		
		discardTracker = new int[4][5];
		determineMaxScore();

	}

	private void determineMaxScore() { // adds up max scores for each color
		maxScore = 0;
		for (int i = 0; i < 4; i++)
			maxScore += maxScores[i];
	}

	public int discard(Card card) { // this will return the new max possible score

		int value = card.getValue();
		int suit = card.getSuit();

		discards[suit] += Integer.toString(value+1) + " ";
		discardTracker[suit][value]++; // add card to tracker

		if (discardTracker[suit][value] == Deck.numCopies[value] && value <= maxScores[suit]) // checks if number of
																								// copies have been
																								// reached and that it
																								// actually lowers the
																								// score, if both 2s are
																								// gone and then both 3s
																								// are gone, don't reset
			maxScores[suit] = value;

		determineMaxScore();

		return maxScore;
	}

	public String getDiscardToDisplay(int suit) {
		return discards[suit];
	}

}
