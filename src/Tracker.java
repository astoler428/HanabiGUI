
//this class stores important data as one object

public class Tracker {
	
	private int clues;
	private int points;
	private int strikes;
	
	private int maxPossibleScore;

	public Tracker() {
		clues = 8;
		points = 0;
		strikes = 0;
		
		maxPossibleScore = 25;
	}
	
	public int getMaxPossibleScore() {
		return maxPossibleScore;
	}
	
	public void setMaxPossibleScore(int score) {
		maxPossibleScore = score;
	}
	
	public int getClues() {
		return clues;
	}

	public void addClue() {
		if(clues != 8)
			clues++;
	}
	
	public void subtractClue() {
		clues--;
	}

	public int getPoints() {
		return points;
	}

	public void addPoint() {
		points++;
	}

	public int getStrikes() {
		return strikes;
	}

	public void addStrike() {
		strikes++;
	}

}
