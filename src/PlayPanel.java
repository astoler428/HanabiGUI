import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayPanel extends JPanel{
	
	JLabel deck;
	JPanel playStacks;
	JLabel clubStack, diamondStack, heartStack, spadeStack;
	ImageIcon club, diamond, heart, spade;
	
	public PlayPanel() {
		
		
		deck = new JLabel("35", CardImages.cardBack, JLabel.CENTER); //will need to set text later
		deck.setVerticalTextPosition(JLabel.CENTER);
		deck.setHorizontalTextPosition(JLabel.CENTER);
		deck.setFont(new Font("Ariel", Font.BOLD, 50));
		
		club = CardImages.clubCard;
		diamond = CardImages.diamondCard;
		heart = CardImages.heartCard;
		spade = CardImages.spadeCard;

		
//		club = new ImageIcon(CardImages.club.getImage().getScaledInstance(90, 120, java.awt.Image.SCALE_SMOOTH));
//		diamond = new ImageIcon(CardImages.diamond.getImage().getScaledInstance(90, 120, java.awt.Image.SCALE_SMOOTH));
//		heart = new ImageIcon(CardImages.heart.getImage().getScaledInstance(90, 120, java.awt.Image.SCALE_SMOOTH));
//		spade = new ImageIcon(CardImages.spade.getImage().getScaledInstance(90, 120, java.awt.Image.SCALE_SMOOTH));
		
		clubStack = new JLabel(club);
		diamondStack = new JLabel(diamond);
		heartStack = new JLabel(heart);
		spadeStack = new JLabel(spade);
		
		clubStack.setBorder(BorderFactory.createLineBorder(Color.blue));
		diamondStack.setBorder(BorderFactory.createLineBorder(Color.blue));
		heartStack.setBorder(BorderFactory.createLineBorder(Color.blue));
		spadeStack.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		playStacks = new JPanel();
		playStacks.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		playStacks.setBorder(BorderFactory.createLineBorder(Color.black));

		playStacks.add(clubStack);
		playStacks.add(diamondStack);
		playStacks.add(heartStack);
		playStacks.add(spadeStack);
		
		this.setSize(getPreferredSize());
		//new Dimension(700, 200)
		this.add(deck);
		this.add(playStacks);
				
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
