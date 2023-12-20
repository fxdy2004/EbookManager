package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import service.BookServiceImpl;
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
		center.add(new BookCover(testBook));
		center.add(new BookCover(testBook));
		center.add(new BookCover(testBook));
		center.add(new BookCover(testBook));
		center.add(new BookCover(testBook));

		add(center,BorderLayout.CENTER);
		
		searchtest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<EBook> books = null;
				String text = searchtest.getText();
				BookServiceImpl bookServiceImpl = new BookServiceImpl();
				try {
					books=bookServiceImpl.blurryName(new EBook(text, text, null));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.err.println("查询出错");
					System.exit(0);
				}
				center.removeAll();
				int i = 0,n = books.size()>6?6:books.size();
				for(i=0;i<n;i++) {
					center.add(new BookCover(books.get(i)));
				}
			}
		});
	}
}
