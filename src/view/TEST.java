package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TEST {
	public static void main(String[] args) {
		DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
		DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");
		JTextField showDate1 = new JTextField("单击选择日期");
		JLabel showDate2 = new JLabel("单击选择日期");
 
		dateChooser1.register(showDate1);
		dateChooser2.register(showDate2);
 
		JFrame jf = new JFrame("测试日期选择器");
		jf.add(showDate1, BorderLayout.NORTH);
		jf.add(showDate2, BorderLayout.SOUTH);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
