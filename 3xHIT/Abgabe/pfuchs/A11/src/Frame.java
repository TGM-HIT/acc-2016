import javax.swing.*;
import java.awt.*;

/**
 * The window to show the panels
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	/**
	 * Constructor<br>
	 * Adds a picture in the background<br>
	 * And sets a custom cursor
	 * 
	 * @param panel the panel so show
	 */
	public Frame(JPanel panel) {
		
		setTitle("Quiz");
		setSize(840, 495);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/13.png").getImage(), new Point(0, 0), "Cursor"));
		
		setContentPane(new JLabel(new ImageIcon("src/game.jpeg")));
		
		setLayout(new FlowLayout());
		
		add(panel);
		
		setVisible(true);
	}
}
