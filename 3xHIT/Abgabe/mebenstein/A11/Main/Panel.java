package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.NumberFormatter;


/**
 * 
 * @author Michael Ebenstein
 * @version 17-12-2016
 *
 * Has Interactive elements and displays them accordingly 
 */
public class Panel extends JPanel{

	private Quiz m;
	private Controller c;
	private JLabel questionLabel;
	private JRadioButton[] radioButtons;
	private ArrayList<Boolean> results;
	private JButton end;
	private Question question;
	private JPanel center;
	private boolean ending = false;
	/**
	 * 
	 * Sets attributes to shared objects. Makes default Panel operations
	 * @param m	shared Model
	 * @param c shared Controller
	 */
	public Panel(Quiz m,Controller c){
		super();
		this.m = m;
		this.c = c;
		
		questionLabel = new JLabel("Star Quiz");
		results = new ArrayList<>();
	
		center = new JPanel(new GridLayout(0, 1));
		
		radioButtons = new JRadioButton[4];
		
		for(int i = 0; i < 4;++i){
			radioButtons[i] = new JRadioButton();
			center.add(radioButtons[i]);
			radioButtons[i].addActionListener(c);
		}
		
		end = new JButton("end");
		end.addActionListener(c);
		
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.setLayout(new BorderLayout());
		this.add(questionLabel,BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		this.add(end, BorderLayout.SOUTH);

		
		this.setPreferredSize(new Dimension(600, 800));
		
		nextQuestion(null);
	}
	
	public void end(){
		if(ending == true)System.exit(0);
		ending = true;
		center.removeAll();
		
		int right = 0,wrong = 0;
		
		for(boolean b:results)
			if(b)right++;
			else wrong++;
		
		String s = "<html><table><tr><td>Right</td><td>Wrong</td></tr><tr><td>"+right+"</td><td>"+wrong+"</td></tr>";
		JLabel l = new JLabel(s);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		center.add(l);
		
	}
	
	public void nextQuestion(Object source){
		
		for(int i = 0; i < 4;++i){
			if(source == radioButtons[i]){
				results.add(radioButtons[i].getText().equals(question.getRight()));
				radioButtons[i].setSelected(false);
			}
		}
		
		question = m.nextRound();
		
		if(question==null){
			end();
			return;
		}
			
		String[] answers = question.getAnswers();
		
		Collections.shuffle(Arrays.asList(answers));
		
		for(int i = 0; i < 4;++i)
			radioButtons[i].setText(answers[i]);
		
		questionLabel.setText(question.getQuestion());
			
	}

	
	public JButton getEnd(){
		return end;
	}
}
