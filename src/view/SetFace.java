package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetFace extends JPanel{
	public SetFace() {
		setLayout(new GridLayout(4, 1));
		JLabel prompt = new JLabel("设置下载路径:");
		prompt.setFont(getFont().deriveFont(20f));
		add(prompt);
		
		JButton button = new MyButton("点击设置下载路径");
		button.setPreferredSize(new Dimension(200, 30));
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setPreferredSize(new Dimension(300, 30));
		textField.setFont(getFont().deriveFont(20f));
		textField.setText("總之這裏應該獲取一下路徑");		//总之这里应该获取一下下载路径
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(SetFace.this);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    textField.setText(selectedFile.getAbsolutePath());
                    //总之这里应该把下载路径传下去
                }
			}
		});
		JPanel div = new MyJPanel();
		div.setLayout(new FlowLayout(FlowLayout.LEFT));
		div.add(button);
		div.add(textField);
		
		add(div);
	}
}
