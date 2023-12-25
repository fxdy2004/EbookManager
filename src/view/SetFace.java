package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilePermission;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uitl.ColorUitl;
import uitl.FilePersistenceUtil;

public class SetFace extends JPanel {
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
		String pathString = FilePersistenceUtil.getSavedFilePath();
		textField.setText(pathString);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = fileChooser.showOpenDialog(SetFace.this);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					FilePersistenceUtil.saveFilePath(selectedFile.getAbsolutePath());
					textField.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		JPanel div = new MyJPanel();
		div.setLayout(new FlowLayout(FlowLayout.LEFT));
		div.add(button);
		div.add(textField);

		add(div);

		JLabel prompt2 = new JLabel("设置主题颜色:");
		prompt2.setFont(getFont().deriveFont(20f));
		add(prompt2);
		
		JPanel div2 = new MyJPanel();
		
		JButton colorChooserButton = new MyButton("选择颜色");
		colorChooserButton.setPreferredSize(new Dimension(150, 30));

		JTextField colorCodeTextField = new JTextField();
		colorCodeTextField.setPreferredSize(new Dimension(200, 30));
		colorCodeTextField.setFont(getFont().deriveFont(20f));
		Color savedColor = ColorUitl.getSavedColor();
		if (savedColor != null) {
			String hexColor = "#" + Integer.toHexString(savedColor.getRGB()).substring(2).toUpperCase();
			colorCodeTextField.setText(hexColor);
			colorCodeTextField.setBackground(savedColor);
		}

		colorChooserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color selectedColor = JColorChooser.showDialog(colorChooserButton, "选择颜色",
						colorCodeTextField.getBackground());

				if (selectedColor != null) {
					String hexColor = "#" + Integer.toHexString(selectedColor.getRGB()).substring(2).toUpperCase();
					colorCodeTextField.setText(hexColor);
					colorCodeTextField.setBackground(selectedColor);
					ColorUitl.saveSelectedColor(selectedColor);
					MainWindow.repaintColor();
					div.setBackground(ColorUitl.getSavedColor());
	                div2.setBackground(ColorUitl.getSavedColor());
	                div.repaint();
	                div2.repaint();
				}
			}
		});
		colorCodeTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String colorCode = colorCodeTextField.getText().trim();
	            try {
	                Color selectedColor = Color.decode(colorCode);
	                colorCodeTextField.setBackground(selectedColor);
	                ColorUitl.saveSelectedColor(selectedColor);
	                MainWindow.repaintColor();
	                div.setBackground(ColorUitl.getSavedColor());
	                div2.setBackground(ColorUitl.getSavedColor());
	                div.repaint();
	                div2.repaint();
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(colorCodeTextField, "无效的颜色代码！", "错误", JOptionPane.ERROR_MESSAGE);
	            }
			}
		});

		
		div2.setLayout(new FlowLayout(FlowLayout.LEFT));
		div2.add(colorChooserButton);
		div2.add(colorCodeTextField);

		add(div2);

	}
}
