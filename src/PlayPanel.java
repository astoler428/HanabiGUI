import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//this panel displays the cards in the deck by taking a cardBack as a label icon with text centered
//it also creates suit logo cards by creating a border around scaled logo icons

public class PlayPanel extends JPanel{
	
	private JLabel deck;
	private JPanel playStacks;
	private JLabel clubStack, diamondStack, heartStack, spadeStack;
	private ArrayList<JLabel> suitLabelList;
	private ImageIcon club, diamond, heart, spade;
	private PlayTracker playTracker;
	
	public PlayPanel(PlayTracker playTracker) {
		
		this.playTracker = playTracker;
	
		createDeckDisplay();
		createStackDisplay();
		
		this.setSize(getPreferredSize());
		this.add(deck);
		this.add(playStacks);
				
	}
	
	private void createDeckDisplay() {
		deck = new JLabel(CardImages.cardBack, JLabel.CENTER); //will need to set text later
		deck.setVerticalTextPosition(JLabel.CENTER);
		deck.setHorizontalTextPosition(JLabel.CENTER);
		deck.setFont(new Font("Ariel", Font.BOLD, 50));
	}
	
	private void createStackDisplay() {
		
//		club = CardImages.clubCard;
//		diamond = CardImages.diamondCard;
//		heart = CardImages.heartCard;
//		spade = CardImages.spadeCard;
//		
//		clubStack = new JLabel(club);
//		diamondStack = new JLabel(diamond);
//		heartStack = new JLabel(heart);
//		spadeStack = new JLabel(spade);
		
		//create labels for images
		
		clubStack = new JLabel();
		diamondStack = new JLabel();
		heartStack = new JLabel();
		spadeStack = new JLabel();
		
		//add labels to list
		suitLabelList = new ArrayList<>();
		suitLabelList.add(clubStack);
		suitLabelList.add(diamondStack);
		suitLabelList.add(heartStack);
		suitLabelList.add(spadeStack);
		
		for(int idx = 0; idx < suitLabelList.size(); idx++)
			suitLabelList.get(idx).setBorder(BorderFactory.createLineBorder(Color.blue));

		playStacks = new JPanel();
		playStacks.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		playStacks.setBorder(BorderFactory.createLineBorder(Color.black));

		for(int idx = 0; idx < suitLabelList.size(); idx++)
			playStacks.add(suitLabelList.get(idx));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		deck.setText(Integer.toString(playTracker.getDeckCount()));
		
		for(int suit = 0; suit < 4; suit++) {				//this is where the label get set to the right icon
			suitLabelList.get(suit).setIcon(playTracker.getIconToDisplayOnStacks(suit)); 
		}
			
	}
	
//	public static void main(String[] args) {
//		
//				JFrame frame = new JFrame();
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame.setSize(1400, 750);
//				PlayPanel pp = new PlayPanel();
//				frame.add(pp);
//				frame.pack();
//				frame.setVisible(true);
//				
//			}
}
