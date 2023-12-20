package view;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String text) {
		super(text);
		this.setHorizontalAlignment(CENTER);
		this.setFont(getFont().deriveFont(20f));
	}
}
