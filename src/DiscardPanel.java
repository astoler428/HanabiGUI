import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiscardPanel extends JPanel {
	
	JLabel clubDiscards, diamondDiscards, heartDiscards, spadeDiscards;
	//JLabel clubLabel, diamondLabel,heartLabel, spadeLabel;
	ImageIcon clubImage, diamondImage,heartImage, spadeImage;
	
	final int IMAGE_SIZE = 30;
	
	public DiscardPanel() {
		
		clubImage = new ImageIcon(CardImages.club.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));
		diamondImage = new ImageIcon(CardImages.diamond.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));
		heartImage = new ImageIcon(CardImages.heart.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));
		spadeImage = new ImageIcon(CardImages.spade.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));
			
		clubDiscards = new JLabel("1 1 1 2 2 3 3 4 4 5");
		diamondDiscards = new JLabel();
		heartDiscards = new JLabel();
		spadeDiscards = new JLabel();
		
		clubDiscards.setIcon(clubImage);
		diamondDiscards.setIcon(diamondImage);
		heartDiscards.setIcon(heartImage);
		spadeDiscards.setIcon(spadeImage);
		
//		clubDiscards.setHorizontalTextPosition(JLabel.RIGHT);
//		diamondDiscards.setHorizontalTextPosition(JLabel.RIGHT);
//		heartDiscards.setHorizontalTextPosition(JLabel.RIGHT);
//		spadeDiscards.setHorizontalTextPosition(JLabel.RIGHT);
		
		clubDiscards.setIconTextGap(10);
		diamondDiscards.setIconTextGap(10);
		heartDiscards.setIconTextGap(10);
		spadeDiscards.setIconTextGap(10);

		
		clubDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		clubDiscards.setForeground(Color.black);
		//clubDiscards.setHorizontalAlignment(JLabel.CENTER);
		
		diamondDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		diamondDiscards.setForeground(Color.red);
		//diamondDiscards.setHorizontalAlignment(JLabel.CENTER);

		
		heartDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		heartDiscards.setForeground(Color.red);
		//heartDiscards.setHorizontalAlignment(JLabel.CENTER);


		spadeDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		spadeDiscards.setForeground(Color.black);
		//spadeDiscards.setHorizontalAlignment(JLabel.CENTER);

		
		clubDiscards.setPreferredSize(new Dimension(200,IMAGE_SIZE));
		diamondDiscards.setPreferredSize(new Dimension(200,IMAGE_SIZE));
		heartDiscards.setPreferredSize(new Dimension(200,IMAGE_SIZE));
		diamondDiscards.setPreferredSize(new Dimension(200,IMAGE_SIZE));
		

		
	
		//new Dimension(200, 250)
		this.setBackground(Color.gray);
		this.setLayout(new GridLayout(4, 2));
		
		
		this.add(clubDiscards);
		this.add(diamondDiscards);
		this.add(heartDiscards);
		this.add(spadeDiscards);
		
		//this.setSize(getPreferredSize());

	}
	
		public static void main(String[] args) {
		
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1400, 750);
			DiscardPanel dp = new DiscardPanel();
			frame.add(dp);
			frame.pack();
			frame.setVisible(true);
			
		}
	}
