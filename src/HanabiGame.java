import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


//this class is where the game runs from

public class HanabiGame {

	private final int NUM_PLAYERS;
	private final int CARDS_PER_HAND;
	private Deck deck;
	private Tracker tracker;
	private Log log;
	private PlayTracker playTracker;
	private DiscardTracker discardTracker;

	private Player[] listOfPlayers;
	private GamePanel[] gamePanels;
	private HanabiGameFrame[] hanabiGameFrames;

	private LogPanel[] logPanels;
	private TrackerPanel[] trackerPanels;
	private PlayPanel[] playPanels;
	private DiscardPanel[] discardPanels;
	private CluePanel[] cluePanels;
	private DisplayPanel[] displayPanels;
	private JPopupMenu[] popupMenus;

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
		log = new Log();
		playTracker = new PlayTracker(deck);
		discardTracker = new DiscardTracker();

		setClueAndPlayerOptions();
		createPlayers();
		setHands();
		createPopupMenus();
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
		updateLog("player clued");
		currentPlayer.setTurn(false);
		turn++;
		currentPlayer = getCurrentPlayer();
		currentPlayer.setTurn(true);
		repaint(); //my method here that calls repaint on all frames
		
		//UPDATE LOG
		//FIGURE OUT HOW TO REPAINT EVERYTHING...
	}
	
	private void play(Player player, int slot) {		//keep editing for misplay and drawing accounting for final turns
		Card card = player.getCardAt(slot);
		

		if(playTracker.play(card)) {		//means card successfully played on stacks
			
			player.removefromHand(slot);
			tracker.addPoint();
			
			if(tracker.getClues() != 8 && card.getValue() == 4)		//add a clue for playing 5's
				tracker.addClue();
			
			deck.draw(player); //EDIT TO ACCOUNT FOR ON FINAL TURNS...
			
			
			
			updateLog("Card Played");
			currentPlayer.setTurn(false);
			turn++;
			currentPlayer = getCurrentPlayer();
			currentPlayer.setTurn(true);
			repaint();
		}
		else {
			misPlay(player, slot);
		}
	}
	
	public void misPlay(Player player, int slot) {
		tracker.addStrike();
		discard(player, slot, true);
	}
	
	public void discard(Player player, int slot, boolean misplay) {		//only diff between misplay and discard is adding clue
		Card card = player.getCardAt(slot);
		
		tracker.setMaxPossibleScore(discardTracker.discard(card));		//discards card and sets tracker to a new maxScore
		player.removefromHand(slot);
		
		if(!misplay)
			tracker.addClue();
		
		deck.draw(player);	//EDIT TO ACCOUNT FOR ON FINAL TURNS...

		if(!misplay)
			updateLog("Card Discarded");
		else
			updateLog("Card Misplayed");
		currentPlayer.setTurn(false);
		turn++;
		currentPlayer = getCurrentPlayer();
		currentPlayer.setTurn(true);
		repaint();
	}
	
	
	public void updateLog(String message) {
		log.updateLog(message);
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
	
	private void createPopupMenus() {
		
		popupMenus = new JPopupMenu[NUM_PLAYERS];
		
		for (int i = 0; i < NUM_PLAYERS; i++) {
			JMenuItem play = new JMenuItem("Play");
			JMenuItem discard = new JMenuItem("Discard");
			play.addActionListener(new PlayListener());
			discard.addActionListener(new DiscardListener());
			popupMenus[i] = new JPopupMenu();			//CardLabels in southListener need a mouselistener!
			popupMenus[i].add(play);
			popupMenus[i].add(discard);
		}
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
			logPanels[i] = new LogPanel(log);
	}

	private void createTrackerPanels() {

		trackerPanels = new TrackerPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			trackerPanels[i] = new TrackerPanel(tracker);
	}

	private void createPlayPanels() {

		playPanels = new PlayPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			playPanels[i] = new PlayPanel(playTracker);
	}

	private void createDiscardPanels() {

		discardPanels = new DiscardPanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++)
			discardPanels[i] = new DiscardPanel(discardTracker);
	}

	private void createCluePanels() {

		cluePanels = new CluePanel[NUM_PLAYERS];

		for (int i = 0; i < NUM_PLAYERS; i++) {
			cluePanels[i] = new CluePanel(listOfPlayers[i], new SelectedPlayerListener(), new SelectedClueListener(),
					new GiveClueListener());
			cluePanels[i].configureClueButtons(NUM_PLAYERS);
		}
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
			gamePanels[idx] = new GamePanel(displayPanels[idx], listOfPlayers[idx], listOfPlayers, popupMenus[idx], new ClickListener());
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
			
			if(tracker.getClues() == 0)	//doesn't do anything if there are 0 clues
				button.setText("Cannot clue with 0 clues");
		
			else if (player.isTurn() && player.getHasChosenPlayerToClue() != null && player.getHasChosenClue() != null) {
				giveClue();
				player.resetClueSelections();
			}
		}

	}
	
	private class PlayListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {		//don't have to check for turn since clickListener for popup will and thats the only way this will get accessed
			//only accessed by currentPlayer
			play(currentPlayer, currentPlayer.getChosenSlot());
			
		}
		
	}
	
	private class DiscardListener implements ActionListener{	//check for 8 clues and turn

		@Override
		public void actionPerformed(ActionEvent e) {
			if(tracker.getClues() == 8) {
//				JOptionPane.showMessageDialog(null, "Can't discard with 8 clues"); 
			}
			else {
				discard(currentPlayer, currentPlayer.getChosenSlot(), false);
			}
				
			
		}
	}
	
	//popups and MenuItems are created above. ActionListeners are attached to menuItems
	//popUps and ClickListeners are passed to GamePanel and then passed into SouthHandPanel
	
	private class ClickListener extends MouseAdapter{	
		
		public void mouseClicked(MouseEvent e) {				//create a CardLabel variable here to store/update what was last selected or create a slot variable and store that - player is obviously currentPlayer
			CardLabel cardLabel = (CardLabel) e.getComponent();
			Player player = cardLabel.getPlayer();
			if(player.isTurn()) { 
				popupMenus[player.getID()].show(cardLabel, e.getX(), e.getY());
				player.setChosenSlot(cardLabel.getSlotNum());
			}
		}

	}

	public static void main(String[] args) {
		HanabiGame game = new HanabiGame(3);
	}
}
