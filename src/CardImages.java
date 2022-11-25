import javax.swing.ImageIcon;

//this class instantiates all the images from the res folder and scales them accordingly
//it also includes the suit logos for the discard, suits scaled into the size of a card for play stacks
//as well as 2D arrays for creating cards

public class CardImages {
	
	static final int CARD_WIDTH = 80;
	static final int CARD_HEIGHT = (int) (1.33333*CARD_WIDTH);
	
	static ImageIcon club1H = new ImageIcon(new ImageIcon("res/1ClubH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club2H = new ImageIcon(new ImageIcon("res/2ClubH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club3H = new ImageIcon(new ImageIcon("res/3ClubH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club4H = new ImageIcon(new ImageIcon("res/4ClubH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club5H = new ImageIcon(new ImageIcon("res/5ClubH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	
	static ImageIcon diamond1H = new ImageIcon(new ImageIcon("res/1DiamondH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond2H = new ImageIcon(new ImageIcon("res/2DiamondH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond3H = new ImageIcon(new ImageIcon("res/3DiamondH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond4H = new ImageIcon(new ImageIcon("res/4DiamondH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond5H = new ImageIcon(new ImageIcon("res/5DiamondH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	
	static ImageIcon heart1H = new ImageIcon(new ImageIcon("res/1HeartH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart2H = new ImageIcon(new ImageIcon("res/2HeartH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart3H = new ImageIcon(new ImageIcon("res/3HeartH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart4H = new ImageIcon(new ImageIcon("res/4HeartH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart5H = new ImageIcon(new ImageIcon("res/5HeartH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	
	static ImageIcon spade1H = new ImageIcon(new ImageIcon("res/1SpadeH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade2H = new ImageIcon(new ImageIcon("res/2SpadeH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade3H = new ImageIcon(new ImageIcon("res/3SpadeH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade4H = new ImageIcon(new ImageIcon("res/4SpadeH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade5H = new ImageIcon(new ImageIcon("res/5SpadeH.png").getImage().getScaledInstance(CARD_HEIGHT, CARD_WIDTH, java.awt.Image.SCALE_SMOOTH));
	
	
	static ImageIcon club1 = new ImageIcon(new ImageIcon("res/1Club.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club2 = new ImageIcon(new ImageIcon("res/2Club.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club3 = new ImageIcon(new ImageIcon("res/3Club.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club4 = new ImageIcon(new ImageIcon("res/4Club.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon club5 = new ImageIcon(new ImageIcon("res/5Club.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	
	static ImageIcon diamond1 = new ImageIcon(new ImageIcon("res/1Diamond.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond2 = new ImageIcon(new ImageIcon("res/2Diamond.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond3 = new ImageIcon(new ImageIcon("res/3Diamond.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond4 = new ImageIcon(new ImageIcon("res/4Diamond.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamond5 = new ImageIcon(new ImageIcon("res/5Diamond.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	
	static ImageIcon heart1 = new ImageIcon(new ImageIcon("res/1Heart.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart2 = new ImageIcon(new ImageIcon("res/2Heart.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart3 = new ImageIcon(new ImageIcon("res/3Heart.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart4 = new ImageIcon(new ImageIcon("res/4Heart.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heart5 = new ImageIcon(new ImageIcon("res/5Heart.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	
	static ImageIcon spade1 = new ImageIcon(new ImageIcon("res/1Spade.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade2 = new ImageIcon(new ImageIcon("res/2Spade.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade3 = new ImageIcon(new ImageIcon("res/3Spade.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade4 = new ImageIcon(new ImageIcon("res/4Spade.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spade5 = new ImageIcon(new ImageIcon("res/5Spade.png").getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
		
	static ImageIcon cardBack = new ImageIcon(new ImageIcon("res/cardBack.jpeg").getImage().getScaledInstance(CARD_WIDTH, 120, java.awt.Image.SCALE_SMOOTH));
	
	static ImageIcon club = new ImageIcon("res/club.png");
	static ImageIcon diamond = new ImageIcon("res/diamond.jpeg");
	static ImageIcon heart = new ImageIcon("res/heart.png");
	static ImageIcon spade = new ImageIcon("res/spade.jpeg");
	
	static ImageIcon clubCard = new ImageIcon(club.getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon diamondCard = new ImageIcon(diamond.getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon heartCard = new ImageIcon(heart.getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
	static ImageIcon spadeCard = new ImageIcon(spade.getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));

	
	static ImageIcon[][] verticalImages = { {club1, club2, club3, club4, club5}, 
											  {diamond1, diamond2, diamond3, diamond4, diamond5},
											  {heart1, heart2, heart3, heart4, heart5},
											  {spade1, spade2, spade3, spade4, spade5}	};
	
	static ImageIcon[][] horizontalImages = { {club1H, club2H, club3H, club4H, club5H}, 
											  {diamond1H, diamond2H, diamond3H, diamond4H, diamond5H},
											  {heart1H, heart2H, heart3H, heart4H, heart5H},
											  {spade1H, spade2H, spade3H, spade4H, spade5H}	};
	
}
