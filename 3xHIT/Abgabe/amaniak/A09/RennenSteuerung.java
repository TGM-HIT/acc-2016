import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Die Steuerung fuer die UI vom Rennen.
 * 
 * @author David Maniak
 * @version 19.12.2016
 */
public class RennenSteuerung implements ActionListener{
	private RennenUI ui;
	private Rennen game;
	
	/**
	 * Konstruktor bei dem die UI gesetzt wird, auf die gelistened werden soll
	 * 
	 * @param ui die zugehoerige UI
	 */
	public RennenSteuerung(RennenUI ui) {
		this.ui = ui;
		
		ui.start.addActionListener(this);
		ui.nextRound.addActionListener(this);
		ui.restart.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(ui.start == e.getSource()) {
			int player = Integer.parseInt(ui.player.getText());
			int maxRounds = Integer.parseInt(ui.maxRounds.getText());
			
			game = new Rennen(player, maxRounds, ui);
			
		} else if(ui.nextRound == e.getSource()) {
			game.nextRound();
		} else if(ui.restart == e.getSource()) {
			game.reset();
		}
	}
	
	
	public static void main(String[] args) {
		new RennenSteuerung(new RennenUI());
	}
}
