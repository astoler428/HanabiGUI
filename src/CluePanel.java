import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
	
	final int BUTTON_HEIGHT = 30;
	final int BUTTON_WIDTH = 60;
	
	public CluePanel() {
				
		//set up cluePanel
		
		clueTitle = new JLabel("\t\t\t\t\t\t\t\t\t\t Give a clue\t\t\t\t\t\t\t\t\t\t");
		clueTitle.setFont(new Font("Ariel", Font.BOLD, 25));
				
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		this.setPreferredSize(new Dimension(375, 300));
		this.setBackground(Color.magenta);
		
		p1 = new JButton("Player 1");
		p2 = new JButton("Player 2");
		p3 = new JButton("Player 3");
		p4 = new JButton("Player 4");
		
		p1.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT)); //adjust this based on number of players
		p2.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		p3.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		p4.setPreferredSize(new Dimension((int) (1.333*BUTTON_WIDTH), BUTTON_HEIGHT));
		
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
	
		club = new JButton(new ImageIcon(CardImages.club.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		diamond = new JButton(new ImageIcon(CardImages.diamond.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		heart = new JButton(new ImageIcon(CardImages.heart.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		spade = new JButton(new ImageIcon(CardImages.spade.getImage().getScaledInstance((int) (.75*BUTTON_WIDTH), (int) (.75*BUTTON_WIDTH), java.awt.Image.SCALE_SMOOTH)));
		
		giveClue = new JButton("Give Clue");
		giveClue.setPreferredSize(new Dimension(4*BUTTON_WIDTH, BUTTON_HEIGHT));
	
		this.add(clueTitle);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(val1);
		this.add(val2);
		this.add(val3);
		this.add(val4);
		this.add(val5);
		this.add(club);
		this.add(diamond);
		this.add(heart);
		this.add(spade);
		this.add(giveClue);
		
		//this.setBorder(BorderFactory.createLineBorder(Color.cyan));
	
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(375, 300);
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
