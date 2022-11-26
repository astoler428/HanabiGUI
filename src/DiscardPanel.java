import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//this container is made up of 4 labels, which each have an icon (suit logo) and text, which will track the discards
//mostly formatting here

public class DiscardPanel extends JPanel {

	private JLabel clubDiscards, diamondDiscards, heartDiscards, spadeDiscards;
	private ImageIcon clubImage, diamondImage, heartImage, spadeImage;

	private final int IMAGE_SIZE = 30;
	private DiscardTracker discardTracker;
	private ArrayList<JLabel> discardLabelList;	//stores the discard Labels

	public DiscardPanel(DiscardTracker discardTracker) {

		this.discardTracker = discardTracker;
		
		createDiscardDisplay();

		

		clubDiscards.setIcon(clubImage);
		diamondDiscards.setIcon(diamondImage);
		heartDiscards.setIcon(heartImage);
		spadeDiscards.setIcon(spadeImage);

		

		// new Dimension(200, 250)
		this.setBackground(Color.gray);
		this.setLayout(new GridLayout(4, 2));

		

		// this.setSize(getPreferredSize());

	}
	
	private void createDiscardDisplay(){
		clubImage = new ImageIcon(
				CardImages.club.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));
		diamondImage = new ImageIcon(
				CardImages.diamond.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));
		heartImage = new ImageIcon(
				CardImages.heart.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));
		spadeImage = new ImageIcon(
				CardImages.spade.getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, java.awt.Image.SCALE_SMOOTH));

		clubDiscards = new JLabel();
		diamondDiscards = new JLabel();
		heartDiscards = new JLabel();
		spadeDiscards = new JLabel();
		
		discardLabelList = new ArrayList<>();
		discardLabelList.add(clubDiscards);
		discardLabelList.add(diamondDiscards);
		discardLabelList.add(heartDiscards);
		discardLabelList.add(spadeDiscards);
		
		for(int idx = 0; idx < discardLabelList.size(); idx++)
			discardLabelList.get(idx).setIconTextGap(10);
		
//		clubDiscards.setIconTextGap(10);
//		diamondDiscards.setIconTextGap(10);
//		heartDiscards.setIconTextGap(10);
//		spadeDiscards.setIconTextGap(10);

		clubDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		clubDiscards.setForeground(Color.black);

		diamondDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		diamondDiscards.setForeground(Color.red);

		heartDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		heartDiscards.setForeground(Color.red);

		spadeDiscards.setFont(new Font("Ariel", Font.BOLD, 15));
		spadeDiscards.setForeground(Color.black);
		
		for(int idx = 0; idx < discardLabelList.size(); idx++)
			discardLabelList.get(idx).setPreferredSize(new Dimension(200, IMAGE_SIZE));

//		clubDiscards.setPreferredSize(new Dimension(200, IMAGE_SIZE));
//		diamondDiscards.setPreferredSize(new Dimension(200, IMAGE_SIZE));
//		heartDiscards.setPreferredSize(new Dimension(200, IMAGE_SIZE));
//		diamondDiscards.setPreferredSize(new Dimension(200, IMAGE_SIZE));
		
		for(int idx = 0; idx < discardLabelList.size(); idx++)
			add(discardLabelList.get(idx));
		
//		this.add(clubDiscards);
//		this.add(diamondDiscards);
//		this.add(heartDiscards);
//		this.add(spadeDiscards);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int suit = 0; suit < 4; suit++) {				//this is where the label get set to the right icon
			discardLabelList.get(suit).setText(discardTracker.getDiscardToDisplay(suit)); 
		}
	}

}
