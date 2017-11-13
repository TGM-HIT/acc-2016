import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Es werden laufend Fragen gestellt, wenn die Fragen ausgehen fangen sie von neu an.
 * Die Fragen und Antworten werden in einer Datei namens quiz.txt gespeichert.
 * 
 * Steuerung fuer das Quiz.
 * 
 * @author David Maniak
 * @version 22.12.2016
 */
public class QuizControl implements ActionListener, WindowListener {
	private QuizUI ui;
	
	/**
	 * Konstruktor bei dem die dazugehoerige UI gesetzt wird.
	 * 
	 * @param ui die zugehoerige UI
	 */
	public QuizControl(QuizUI ui) {
		this.ui = ui;
		
		ui.next.addActionListener(this);
		ui.quit.addActionListener(this);
		ui.frame.addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(ui.next == e.getSource())
			ui.loadQuestion();
		else if(ui.quit == e.getSource())
			ui.loadPoints();
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		ui.loadPoints();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
}
