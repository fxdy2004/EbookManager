package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import service.EBook;
import service.EBook.BookType;

public class HomePage extends JPanel{
	public HomePage() {
		setLayout(new BorderLayout());
		JLabel title = new JLabel("图书推荐");
		title.setFont(getFont().deriveFont(Font.BOLD, 20f)); // 设置字体加粗
        title.setHorizontalAlignment(SwingConstants.CENTER); // 设置标题居中对齐
		add(title,BorderLayout.NORTH);
		setPreferredSize(new Dimension(600, 500));
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
