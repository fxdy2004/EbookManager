package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import service.EBook;
import service.EBook.BookType;

public class Search extends JPanel{
	public Search() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 500));
		JTextField searchtest = new JTextField();
		searchtest.addFocusListener(new JTextFieldHintListener(searchtest, "请键入要搜索的书名"));
		searchtest.setFont(getFont().deriveFont(20f));
        searchtest.setHorizontalAlignment(JTextField.CENTER);
		add(searchtest,BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.setLayout(new FlowLayout(FlowLayout.LEFT,75,25));
		EBook testBook = new EBook("测试book", "俺", BookType.GAME);
		testBook.setCoverImageIcon(new ImageIcon("images/1.jpg"));
		center.add(new BookCover(testBook));
//		center.add(new BookCover(new ImageIcon("images/2.jpg"), "测试"));
//		center.add(new BookCover(new ImageIcon("images/3.jpg"), "测试"));
//		center.add(new BookCover(new ImageIcon("images/4.jpg"), "测试"));
//		center.add(new BookCover(new ImageIcon("images/5.jpg"), "测试"));
//		center.add(new BookCover(new ImageIcon("images/6.jpg"), "测试"));
		add(center,BorderLayout.CENTER);
	}
}
