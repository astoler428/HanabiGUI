
public class Tracker {
	
	private int clues;
	private int points;
	private int strikes;

	public Tracker() {
		clues = 8;
		points = 0;
		strikes = 0;
	}
	
	public int getClues() {
		return clues;
	}

	public void setClues(int clues) {
		this.clues = clues;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}

}
