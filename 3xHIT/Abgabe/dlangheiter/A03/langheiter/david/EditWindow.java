package langheiter.david;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditWindow extends WindowAdapter {
	
	private static Map<String, EditWindow> openWindows = new HashMap<>();
	
	private WordList ws;
	private List<JTextField> inputs;
	JFrame frame;
	
	public EditWindow(WordList ws, JFrame caller) {
		if(isOpen(ws.getName())) {
			return;
		}
		inputs = new ArrayList<>();
		this.ws = ws;
		frame = new JFrame("Edit Wordlist " + ws.getName());
		frame.addWindowListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(caller);
		
		ScrollPane sp = new ScrollPane();
		
		JPanel p = new JPanel();
		sp.add(p);
		frame.setContentPane(sp);
		p.setLayout(new GridLayout(26, 2));
		
		
		for(int i = 0; i < 26; i++) {
			char c = (char) (97 + i);
			p.add(new JLabel("" + c, SwingConstants.CENTER));
			JTextField b = new JTextField(ws.getWord(c));
			p.add(b);
			inputs.add(b);
		}
		
		frame.setSize(300, 500);	
	}
	
	private boolean isOpen(String name) {
		if(!openWindows.containsKey(name)) {
			openWindows.put(name, this);
			return false;
		}
		openWindows.get(name).toFront();
		return true;
	}
	
	private void toFront() {
		frame.toFront();
	}
	
	public void windowClosing(WindowEvent e) {
		for(int i = 0; i < 26; i++) {
			char c = (char) (97 + i);
			ws.setWord(c, inputs.get(i).getText());
		}
		ws.saveToFile();
		openWindows.remove(ws.getName());
	}
	
}
