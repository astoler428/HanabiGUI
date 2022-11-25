import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//this class is where the game runs from

public class HanabiGame {

	private final int NUM_PLAYERS;
	private final int CARDS_PER_HAND;
	private Deck deck;
	private Tracker tracker;

	private Player[] listOfPlayers;
	private GamePanel[] gamePanels;
	private HanabiGameFrame[] hanabiGameFrames;

	private LogPanel[] logPanels;
	private TrackerPanel[] trackerPanels;
	private PlayPanel[] playPanels;
	private DiscardPanel[] discardPanels;
	private CluePanel[] cluePanels;
	private DisplayPanel[] displayPanels;

	private int turn; // starts at 0 and will look mod NUM_PLAYERS to find whose turn it is in the
	private Player currentPlayer; // array

	private String[] clueOptionsArray = { "1", "2", "3", "4", "5", "Club", "Diamond", "Heart", "Spade" };
	private String[] playerOptionsArray = { "Player 1", "Player 2", "Player 3", "Player 4" };
	private List<String> clueOptions;
	private List<String> playerOptions;

	public HanabiGame(int numPlayers) {
		NUM_PLAYERS = numPlayers;

		if (NUM_PLAYERS == 2 || NUM_PLAYERS == 3)
			CARDS_PER_HAND = 5;
		else
			CARDS_PER_HAND = 4;

		turn = 0;

		deck = new Deck();
		tracker = new Tracker();

		setClueAndPlayerOptions();
		createPlayers();
		setHands();
		createLogPanels();
		createTrackerPanels();
		createPlayPanels();
		createDiscardPanels();
		createCluePanels();
		CreateDisplayPanels();
		createGamePanelsAndFrames();

		playGame();

	}

	public void playGame() {

		// while (true) { // switch to !gameOver
		
			currentPlayer = getCurrentPlayer();
			currentPlayer.setTurn(true);
			
			repaint();
		

	}

	private void giveClue() {
		// current player clues current players haschosenplayer
		// switch index of hasChosenClue

		int idx = clueOptions.indexOf(currentPlayer.getHasChosenClue());

		if (idx <= 4) // value clue and index here is the value 0-4
			currentPlayer.getHasChosenPlayerToClue().receiveValueClue(idx);
		else // value is 5-8 and subtracting 5 corresponds with suit
			currentPlayer.getHasChosenPlayerToClue().receiveSuitClue(idx - 5);

		tracker.subtractClue();
		
		repaint(); //my method here that calls repaint on all frames
		
		//UPDATE LOG
		//FIGURE OUT HOW TO REPAINT EVERYTHING...

	}
	
	private void updateLogsWithClue() { //working on this, decide on order and storing...
		for(int i = 0; i < NUM_PLAYERS; i++)
			logPanels[i].updateLog("Player " + (currentPlayer.getID()+1));
	}


	private void setClueAndPlayerOptions() {

		clueOptions = new ArrayList<>();
		playerOptions = new ArrayList<>();

		for (int i = 0; i < clueOptionsArray.length; i++)
			clueOptions.add(clueOptionsArray[i]);

		for (int i = 0; i < playerOptionsArray.length; i++)
			playerOptions.add(playerOptionsArray[i]);
	}

	private Player getCurrentPlayer() {
		return listOfPlayers[turn % NUM_PLAYERS];
	}

	private void createPlayers() {

		listOfPlayers = new Player[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			listOfPlayers[i] = new Player(i); // use player 1 to 5, not 0 to 4
	}

	private void setHands() {
		for (int i = 0; i < NUM_PLAYERS; i++)
			for (int j = 0; j < CARDS_PER_HAND; j++)
				deck.draw(listOfPlayers[i]);
	}

	private void createLogPanels() {

		logPanels = new LogPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			logPanels[i] = new LogPanel();
	}

	private void createTrackerPanels() {

		trackerPanels = new TrackerPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			trackerPanels[i] = new TrackerPanel(tracker);
	}

	private void createPlayPanels() {

		playPanels = new PlayPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			playPanels[i] = new PlayPanel();
	}

	private void createDiscardPanels() {

		discardPanels = new DiscardPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			discardPanels[i] = new DiscardPanel();
	}

	private void createCluePanels() {

		cluePanels = new CluePanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			cluePanels[i] = new CluePanel(listOfPlayers[i], new SelectedPlayerListener(), new SelectedClueListener(),
					new GiveClueListener());
	}

	private void CreateDisplayPanels() {

		displayPanels = new DisplayPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			displayPanels[i] = new DisplayPanel(playPanels[i], discardPanels[i], cluePanels[i]);
	}

	private void createGamePanelsAndFrames() {

		gamePanels = new GamePanel[NUM_PLAYERS];
		hanabiGameFrames = new HanabiGameFrame[NUM_PLAYERS];

		for (int idx = 0; idx < NUM_PLAYERS; idx++) {
			gamePanels[idx] = new GamePanel(displayPanels[idx], listOfPlayers[idx], listOfPlayers);
			hanabiGameFrames[idx] = new HanabiGameFrame("player " + (idx + 1), gamePanels[idx], logPanels[idx],
					trackerPanels[idx]);
		}

	}
	
	public void repaint() {
		for(int i = 0; i < NUM_PLAYERS; i++)
			hanabiGameFrames[i].repaint();
	}

	private class SelectedPlayerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			RadioButton button = (RadioButton) e.getSource();
			Player player = button.getPlayer();

			if (player.isTurn()) {							//technically i dont need this bc it only displays on turn
				String text = button.getActionCommand();
				int playerPos = playerOptions.indexOf(text);
				player.setHasChosenPlayerToClue(listOfPlayers[playerPos]);

			}
		}
	}

	private class SelectedClueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			RadioButton button = (RadioButton) e.getSource();
			Player player = button.getPlayer();

			if (player.isTurn()) {
				String text = button.getActionCommand();
				player.setHasChosenClue(text);
			}
		}

	}

	private class GiveClueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Button button = (Button) e.getSource();
			Player player = button.getPlayer();

			if (player.isTurn() && player.getHasChosenPlayerToClue() != null && player.getHasChosenClue() != null) {
				giveClue();
				player.resetClueSelections();
			}
		}

	}

	public static void main(String[] args) {
		HanabiGame game = new HanabiGame(3);
	}
}
