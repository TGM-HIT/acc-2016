import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 * Die UI fuer das Rennen.
 * Es gibt Textfelder um die Teilnehmer-& Rundenanzahl anzugeben, Buttons zum Starten, Neustarten 
 * und einen Spielverlauf wo alle Punkte augelistet werden.
 * 
 * @author David Maniak
 * @version 19.12.2016
 */
public class RennenUI extends JPanel {
	JButton start, nextRound, restart;
	JTextField player, maxRounds;
	JCheckBox multi, divi, plus, minus, modulo;
	JScrollPane scroller;
	JTextArea score;
	
	/**
	 * Default-Konstruktor
	 */
	public RennenUI() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		start = new JButton("Start Game");
		restart = new JButton("Restart");
		nextRound = new JButton("Next Round");
		score = new JTextArea();
		scroller = new JScrollPane(score);
		player = new JTextField(16);
		maxRounds = new JTextField(16);
		multi = new JCheckBox("*", true);
		divi = new JCheckBox("/", true);
		plus = new JCheckBox("+", true);
		minus = new JCheckBox("-", true);
		modulo = new JCheckBox("%", true);
		
		restart.setEnabled(false);
		nextRound.setEnabled(false);
		score.setEditable(false);
		
		JPanel operators = new JPanel();
		operators.add(multi);
		operators.add(divi);
		operators.add(plus);
		operators.add(minus);
		operators.add(modulo);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets.bottom = 5;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Teilnehmeranzahl: "), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(player, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets.top = 5;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Maximale Runden: "), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(maxRounds, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets.top = 0;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Operatoren: "), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(operators, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets.top = 10;
		gbc.insets.bottom = 5;
		this.add(start, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets.top = 0;
		this.add(nextRound, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets.top = 10;
		gbc.insets.bottom = 10;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		this.add(restart, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(scroller, gbc);
		
		JFrame frame = new JFrame("Rechen Rennen");
		frame.setSize(400, 400);
		frame.setContentPane(this);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
}
