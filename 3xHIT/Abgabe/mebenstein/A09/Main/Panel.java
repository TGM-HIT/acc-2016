package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

	private Race m;
	private Controller c;
	private JLabel equation,round,time;
	private JFormattedTextField input;
	private JButton next;
	private Equation[] roundData;
	private Equation current;
	private int player = 0;
	private JPanel south;
	private boolean leaderBoards = false;
	private Timer timer;
	/**
	 * 
	 * Sets attributes to shared objects. Makes default Panel operations
	 * @param m	shared Model
	 * @param c shared Controller
	 */
	public Panel(Race m,Controller c){
		super();
		this.m = m;
		this.c = c;
		
		equation = new JLabel("Equation");
		round = new JLabel("Round: 0");
		time = new JLabel("Time");
		
		 timer = new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!= null)
				time.setText("Your time is: "+(System.nanoTime()-current.getStartTime())/1000000+"ms");
				else 
					time.setText("");
				
			}
		});
		
		NumberFormat format = NumberFormat.getNumberInstance();
		NumberFormatter numberFieldFormatter = new NumberFormatter(format);
		numberFieldFormatter.setAllowsInvalid(false);
		
		input = new JFormattedTextField(numberFieldFormatter);
		input.setColumns(10);
	
		
		
		next = new JButton("start");
		next.addActionListener(c);
		
		round.setHorizontalAlignment(SwingConstants.CENTER);
		equation.setHorizontalAlignment(SwingConstants.CENTER);
		
		south = new JPanel();
		south.add(time);
		south.add(input);
		south.add(next);
		
		this.setLayout(new BorderLayout());
		this.add(south,BorderLayout.SOUTH);
		this.add(round,BorderLayout.NORTH);
		this.add(equation, BorderLayout.CENTER);

		
		this.setPreferredSize(new Dimension(600, 800));
		
	}
	
	public void next(){
		if(m.getRound() == 0){
			nextRound();
			timer.start();
			
			next.setText("next");
		}else if(!leaderBoards){
			if(input.getText().length() == 0||current.check(Double.parseDouble(input.getText())) == 0)return;
			input.setValue(null);
		}else{
			leaderBoards = false;
		}
		
		
		

		if(player<m.getParticipants()){
			
			current = roundData[player].start();
			round.setText("Round: "+m.getRound()+" Player: "+(player+1));
			equation.setText(current.getEquation());
			player++;
		}else{
		
			nextRound();
		}
		
	}
	
	private void nextRound(){
		if(m.getRound() != 0&&!leaderBoards){
			leaderBoards = true;
			String text = "<html><table><tr><td>Player</td><td>Score</td></tr>";
		
			
			for(int i = 0; i < roundData.length;++i)
				text+="<tr><td>"+(i+1)+"</td><td>"+roundData[i].getDuration()/1000000+"ms</tr>";
		
			equation.setText(text+"</table></html>");
			next.setText("start next round");
			current = null;
		}else
			next.setText("next");
		
		roundData = m.nextRound();
		
		if(roundData == null){
			current = null;
			String text = "<html><h1>Overall</h1><br/><table><tr><td>Player</td><td>Score</td></tr>";
			long[] data = m.getOverall();
			
			for(int i = 0; i < data.length;++i)
				text+="<tr><td>"+(i+1)+"</td><td>"+data[i]/1000000+"ms</tr>";
			
			next.setEnabled(false);
			next.setText("Finished");
			equation.setText(text+"</table></html>");
		}
		
		player = 0;
		
	}

	public JButton getNext() {
		return next;
	}
	
	
}
