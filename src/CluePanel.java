import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CluePanel extends JPanel {
	
	JLabel clueTitle;
	JButton p1, p2, p3, p4;
	JButton val1, val2, val3, val4, val5;
	JButton club, diamond, heart, spade;
	JButton giveClue;
	
	JPanel playerPanel, valuePanel, suitPanel;
	
	final int BUTTON_HEIGHT = 30;
	final int BUTTON_WIDTH = 60;
	
	public CluePanel() {
				
		this.setLayout(new GridLayout(5,1,0,5));
		this.setPreferredSize(new Dimension(375, 300));
		this.setBorder(BorderFactory.createLineBorder(Color.magenta));
	
		clueTitle = new JLabel("Give a clue");
		clueTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		clueTitle.setHorizontalAlignment(JLabel.CENTER);
		
		
		playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(1, 4, 5, 0));
		
		p1 = new JButton("Player 1");
		p2 = new JButton("Player 2");
		p3 = new JButton("Player 3");
		p4 = new JButton("Player 4");
				
		p1.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT)); //adjust this based on number of players
		p2.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		p3.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		p4.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		
		playerPanel.add(p1);
		playerPanel.add(p2);
		playerPanel.add(p3);
		playerPanel.add(p4);
		
		valuePanel = new JPanel();
		valuePanel.setLayout(new GridLayout(1, 5, 5, 0));
		
		val1 = new JButton("1");
		val2 = new JButton("2");
		val3 = new JButton("3");
		val4 = new JButton("4");
		val5 = new JButton("5");
		
		val1.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val2.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val3.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val4.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		val5.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		
		valuePanel.add(val1);
		valuePanel.add(val2);
		valuePanel.add(val3);
		valuePanel.add(val4);
		valuePanel.add(val5);
		
		suitPanel = new JPanel();
		suitPanel.setLayout(new GridLayout(1, 4, 5, 0));
		
		club = new JButton(new ImageIcon(CardImages.club.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		diamond = new JButton(new ImageIcon(CardImages.diamond.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		heart = new JButton(new ImageIcon(CardImages.heart.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		spade = new JButton(new ImageIcon(CardImages.spade.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		
//		club.setPreferredSize(new Dimension(getPreferredSize()));
//		diamond.setPreferredSize(new Dimension(getPreferredSize()));
//		heart.setPreferredSize(new Dimension(getPreferredSize()));
//		spade.setPreferredSize(new Dimension(getPreferredSize()));

		
		suitPanel.add(club);
		suitPanel.add(diamond);
		suitPanel.add(heart);
		suitPanel.add(spade);
		
		giveClue = new JButton("Give Clue");
		giveClue.setPreferredSize(new Dimension(4*BUTTON_WIDTH, BUTTON_HEIGHT));
			
		this.add(clueTitle);
		this.add(playerPanel);
		this.add(valuePanel);
		this.add(suitPanel);
		this.add(giveClue);

	
	}
	
	public static void main(String[] args) {
		
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(600, 750));
			CluePanel dp = new CluePanel();
			frame.add(dp);
			frame.pack();
			frame.setVisible(true);
			
		}

}
