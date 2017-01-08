import javax.swing.*;
import java.awt.*;

/**
 * Menu-Panel
 * 
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	private Controller c;
	
	private JButton start, create, exit;
	
	/**
	 * Constructor
	 * Creates a new JPanel with a button to start the game, create a question and exit the program<br>
	 * 
	 * @param c - {@linkplain Controller}
	 */
	public StartPanel(Controller c) {
		this.c = c;
		
		this.setPreferredSize(new Dimension(840, 495));
		setLayout(null);
		setOpaque(false); //That the user sees the picture and no background-color
		
		JLabel label = new JLabel("<html><body><h1 style=\"font-size: 100;\">Quiz</h1></body></html>", SwingConstants.CENTER);
		label.setFont(new Font(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()[2], Font.BOLD, 100));
		label.setBounds(100, 0, 640, 200);
		add(label);
		
		start = new JButton("Start");
		start.addActionListener(this.c);
		start.setBounds(180, 300, 200, 40);
		start.setForeground(Color.WHITE);
		start.setFocusPainted(false);
		start.setContentAreaFilled(false);
		add(start);
		
		create = new JButton("Create question");
		create.addActionListener(this.c);
		create.setBounds(460, 300, 200, 40);
		create.setBackground(new Color(0, 12, 52));
		create.setForeground(Color.WHITE);
		create.setFocusPainted(false);
		create.setContentAreaFilled(false);
		add(create);
		
		exit = new JButton("Exit");
		exit.addActionListener(this.c);
		exit.setBounds(180, 350, 480, 40);
		exit.setBackground(new Color(0, 12, 52));
		exit.setForeground(Color.WHITE);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		add(exit);
	}

	/**
	 * Checks if one of the buttons got clicked
	 * @param source the object to compare
	 */
	public void checkButtons(Object source) {
		if (this.start == null || this.exit == null || this.create == null)
			return;
		
		if (source.equals(this.start))
			this.c.startGame();
		else if (source.equals(this.exit))
			System.exit(0);
		else if (source.equals(this.create))
			this.c.createQuest();
	}

}
