import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller for the program
 * 
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
public class Controller implements ActionListener {
	/**
	 * Main-method starts the program
	 * @param args
	 */
	public static void main(String[] args) {
		new Controller();
	}

	private StartPanel sp;
	private GamePanel gp;
	private CreateQuestion cq;
	private EndPanel ep;
	private Frame f;
	private Model m;
	
	/**
	 * Constructor<br>
	 * creates a {@linkplain Model}, a {@linkplain StartPanel} and a {@linkplain Frame}
	 */
	public Controller() {		
		this.m = new Model();
		this.sp = new StartPanel(this);
		this.f = new Frame(this.sp);
	}
	
	/**
	 * When a user presses a button, this method gets called
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.sp.checkButtons(e.getSource());
		if (this.gp != null)
			this.gp.checkButtons(e.getSource());
		if (this.ep != null)
			this.ep.checkButtons(e.getSource());
	}
	
	/**
	 * Creates an instance of {@linkplain GamePanel} and saves it as an attribute<br>
	 * then updates the frame
	 */
	public void startGame() {
		this.gp = new GamePanel(this, this.m);
		if (!this.m.isOver()) {
			this.f.dispose();
			this.f = new Frame(this.gp);
		}
	}
	
	/**
	 * Updates the StartPanel with a new {@linkplain Quiz}
	 * @param b true if the question was answered correctly
	 * false if not
	 */
	public void answered(boolean b) {
		if (b) this.m.setCorrectAnswers(this.m.getCorrectAnswers()+1);
		else this.m.setWrongAnswers(this.m.getWrongAnswers()+1);

		this.gp = new GamePanel(this, this.m);
		if (!m.isOver()) {
			this.f.dispose();
			this.f = new Frame(this.gp);
		}
	}
	
	/**
	 * End the game and shows a {@linkplain EndPanel}<br>
	 * Updates the frame
	 */
	public void endGame() {
		this.m.setOver(true);
		this.f.dispose();
		this.ep = new EndPanel(this.m, this);
		this.f = new Frame(this.ep);
	}
	
	/**
	 * Gives the possibility to create a question via {@linkplain CreateQuestion}<br>
	 * Updates the frame
	 */
	public void createQuest() {
		this.cq = new CreateQuestion(this, this.m);
		
		this.f.dispose();
		this.f = new Frame(this.cq);
	}
	
	/**
	 * Shows the menu (a {@linkplain StartPanel})<br>
	 * Updates the frame
	 */
	public void menu() {
		this.m.reset();
		
		this.f.dispose();
		this.sp = new StartPanel(this);
		this.f = new Frame(this.sp);
	}
	
}
