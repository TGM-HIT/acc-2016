import javax.swing.*;
import java.awt.*;

/**
 * The Ending Panel of the program
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
@SuppressWarnings("serial")
public class EndPanel extends JPanel {
	private Controller c;
	
	private JButton end, restart;
	
	/**
	 * Constructor<br>
	 * Creates an ending panel which shows the user his right and wrong answers<br>
	 * and gives him the probability to restart the game
	 * 
	 * @param m - {@linkplain Model}
	 * @param c - {@linkplain Controller}
	 */
	public EndPanel(Model m, Controller c) {
		this.c = c;
		
		setLayout(new BorderLayout());
		setOpaque(false);
		
		this.add(new JLabel("<html><body><h1 style=\"font-size: 60px;\">Ergebnis</h1></html>", SwingConstants.CENTER), BorderLayout.NORTH);				
		JLabel label = new JLabel("<html><body><p style=\"font-size: 30px;\">Richtige Antworten: "+m.getCorrectAnswers()+""
				+ "<br />Falsche Antworten: "+m.getWrongAnswers()+"</p></html></body>", SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(500, 250));
		add(label);
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		restart = new JButton("Menü");
		restart.addActionListener(this.c);
		restart.setContentAreaFilled(false);
		restart.setFocusPainted(false);
		restart.setPreferredSize(new Dimension(200, 40));
		restart.setForeground(Color.WHITE);
		
		end = new JButton("Beenden");
		end.addActionListener(this.c);
		end.setContentAreaFilled(false);
		end.setFocusPainted(false);
		end.setPreferredSize(new Dimension(200, 40));
		end.setForeground(Color.WHITE);
		
		buttons.add(restart);
		buttons.add(end);
		
		add(buttons, BorderLayout.SOUTH);
	}

	/**
	 * Checks if any of the buttons got pressed
	 * @param source the source to compare
	 */
	public void checkButtons(Object source) {
		if (this.restart == null || this.end == null)
			return;
		
		if (source.equals(restart))
			this.c.menu();
		else if (source.equals(end))
			System.exit(0);
	}
}
