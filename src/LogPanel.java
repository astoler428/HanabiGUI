import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//this object will output the moves that occur in the game by updating text in a JTextArea with a scroll component

public class LogPanel extends JPanel {
	
	private JLabel title;
	private JTextArea logTextArea;
	private Log log;
	private JScrollPane scroll;

	public LogPanel(Log log) {
			
		title = new JLabel("Game Log");
		title.setFont(new Font("Ariel", Font.BOLD, 30));
		title.setForeground(Color.blue);
		
		logTextArea = new JTextArea(40, 15);
		logTextArea.setBackground(Color.yellow);
		logTextArea.setEditable(false);	
		logTextArea.setLineWrap(true);	//forces stuff onto next line
		logTextArea.setWrapStyleWord(true);//breaks at nearest word, not character
		
		this.log = log;
		logTextArea.setText(log.getLogText());
		
		scroll = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(200, 600));
		//this.setSize(getPreferredSize());	//don't use set size since it's going into a flow layout...east panel
		this.add(title);
		this.add(scroll);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		logTextArea.setText(log.getLogText());
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
