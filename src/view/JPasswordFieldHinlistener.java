package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

public class JPasswordFieldHinlistener implements FocusListener {
	private String hintText;
	private JPasswordField jPasswordField;
	public JPasswordFieldHinlistener(JPasswordField jPasswordField,String hintText) {
		this.jPasswordField=jPasswordField;
		this.hintText = hintText;
		jPasswordField.setText(hintText);  //默认直接显示
		jPasswordField.setEchoChar((char)0);
		jPasswordField.setForeground(Color.GRAY);
	}
 
	public void focusGained(FocusEvent e) {
		//获取焦点时，清空提示内容
		String temp = new String(jPasswordField.getPassword());
		if(temp.equals(hintText)) {
			jPasswordField.setText("");
			jPasswordField.setEchoChar('*');
			jPasswordField.setForeground(Color.BLACK);
		}
		
	}
 
	public void focusLost(FocusEvent e) {	
		//失去焦点时，没有输入内容，显示提示内容
		String temp = new String(jPasswordField.getPassword());
		if(temp.equals("")) {
			jPasswordField.setForeground(Color.GRAY);
			jPasswordField.setEchoChar((char)0);
			jPasswordField.setText(hintText);
		}
		
	}
}