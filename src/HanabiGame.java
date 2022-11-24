//this class is where the game runs from

public class HanabiGame {

	private final int NUM_PLAYERS;
	private final int CARDS_PER_HAND;
	private Deck deck;
	private PlayPanel playPanel;
	private DiscardPanel discardPanel;
	private TrackerPanel trackerPanel;
	private Tracker tracker;
	private LogPanel logPanel;
	private CluePanel cluePanel;
	
	private DisplayPanel displayPanel;
	
	private Player[] listOfPlayers;
	
	public HanabiGame(int numPlayers) {
		NUM_PLAYERS = numPlayers;
		
		if(NUM_PLAYERS == 2 || NUM_PLAYERS == 3)
			CARDS_PER_HAND = 5;
		else
			CARDS_PER_HAND = 4;
		
		
		deck = new Deck();
		logPanel = new LogPanel();
		playPanel = new PlayPanel();
		discardPanel = new DiscardPanel();
		tracker = new Tracker();
		trackerPanel = new TrackerPanel(tracker); 
		cluePanel = new CluePanel();
	

		displayPanel = new DisplayPanel(playPanel, discardPanel, cluePanel);

		createPlayers();
		setHands();
		
	//method called create gamepanels
		
		GamePanel gamePanel1 = new GamePanel(displayPanel, listOfPlayers[0], listOfPlayers);
		HanabiGameFrame gameFrame1 = new HanabiGameFrame("Player 1", gamePanel1, logPanel, trackerPanel);
	}
	
	private void createPlayers() {
		
		listOfPlayers = new Player[NUM_PLAYERS];
		
		for(int i = 0; i < NUM_PLAYERS; i++)
			listOfPlayers[i] = new Player(i); //use player 1 to 5, not 0 to 4
	}
	
	public void setHands() {
		for(int i = 0; i < NUM_PLAYERS; i++)
			for(int j = 0; j < CARDS_PER_HAND; j++)
				deck.draw(listOfPlayers[i]);							
	}
	
	public static void main(String[] args) {
		HanabiGame game = new HanabiGame(2);
	}
	
}
