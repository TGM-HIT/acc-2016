package langheiter.david;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controller implements ActionListener {
	
	private File adjFile;
	private File bridgeFile;
	private File nounFile;
	
	private WordList adjectives;
	private WordList bridge;
	private WordList noun;
	
	private JFrame frame;
	
	private JLabel output;
	
	public Controller(String savePath) {
		adjFile = new File(savePath + "\\adjectives.txt");
		bridgeFile = new File(savePath + "\\bridge.txt");
		nounFile = new File(savePath + "\\noun.txt");
		adjectives = new WordList(adjFile, "Adjectives");
		bridge = new WordList(bridgeFile, "Bridges");
		noun = new WordList(nounFile, "Noun");
		
		frame = new JFrame("Funny Names");
		frame.setVisible(true);
		
		JPanel p = new JPanel();
		frame.setContentPane(p);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 2));
		center.add(new JLabel("Name:"));
		JTextField input = new JTextField();
		input.addActionListener(this);
		center.add(input);
		center.add(new JLabel("Output:"));
		output = new JLabel();
		center.add(output);
		
		p.setLayout(new BorderLayout());
		p.add(center, BorderLayout.CENTER);
		
		JPanel ctrlPanel = new JPanel();
		ctrlPanel.setLayout(new GridLayout(1, 3));
		ctrlPanel.add(new EditBtn(adjectives.getName(), this));
		ctrlPanel.add(new EditBtn(bridge.getName(), this));
		ctrlPanel.add(new EditBtn(noun.getName(), this));
		
		p.add(ctrlPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setSize(500, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String in = e.getActionCommand();
		if(in.equals("{btn}" + adjectives.getName())) {
			new EditWindow(adjectives, frame);
			return;
		}
		if(in.equals("{btn}" + bridge.getName())) {
			new EditWindow(bridge, frame);
			return;
		}
		if(in.equals("{btn}" + noun.getName())) {
			new EditWindow(noun, frame);
			return;
		}
		if(in.length() < 2) {
			return;
		}
		String first = adjectives.getWord(in.charAt(0));
		String last = noun.getWord(in.charAt(in.length()-1));
		if(in.length() <= 8) {
			output.setText(first + " " + last);
		} else {
			String middle = bridge.getWord(in.charAt(in.length()/2));
			output.setText(first + " " + middle + " " + last);
		}
		
	}
	
}
