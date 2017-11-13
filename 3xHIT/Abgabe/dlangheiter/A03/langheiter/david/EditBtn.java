package langheiter.david;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class EditBtn extends JButton {
	
	public EditBtn(String name, ActionListener ac) {
		super("Edit " + name);
		this.setActionCommand("{btn}" + name);
		this.addActionListener(ac);
	}
	
}
