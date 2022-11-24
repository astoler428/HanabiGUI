import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogPanel extends JPanel {
	
	private JLabel title;
	private JTextArea log;
	private JScrollPane scroll;

	public LogPanel() {
			
		title = new JLabel("Game Log");
		title.setFont(new Font("Ariel", Font.BOLD, 30));
		title.setForeground(Color.blue);
		
		log = new JTextArea(40, 15);
		log.setBackground(Color.yellow);
		log.setEditable(false);	
		log.setLineWrap(true);	//forces stuff onto next line
		log.setWrapStyleWord(true);//breaks at nearest word, not character
		
		scroll = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(200, 600));
		//this.setSize(getPreferredSize());	//don't use set size since it's going into a flow layout...east panel
		this.add(title);
		this.add(scroll);
	}
		
//	public static void main(String[] args) {
//		LogPanel log = new LogPanel();
//		
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(1400, 750);
//		JPanel panel = new JPanel();
//		panel.setSize(new Dimension(200, 200));
//		panel.setBackground(Color.blue);
//		frame.add(panel, BorderLayout.CENTER);
//		frame.add(log, BorderLayout.EAST);
//		//frame.pack();
//		frame.setVisible(true);
//		
//	}

}
