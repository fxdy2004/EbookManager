package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import service.BookServiceImpl;
import service.EBook;
import uitl.PDFUtil;

public class BookInformationAdd extends JDialog{
	private static Point mouseDownCompCoords = null;
	EBook book;
	public BookInformationAdd(File file,EBook.BookType bookType,JFrame parent, String title, boolean modal) throws Exception {
		super(parent, title, modal);
		setTitle("BookInformationAdd");
		setSize(600, 500);
		
		setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());
        
        JButton closeButton = new MyButton("❌");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel toolbar = new MyJPanel();
        toolbar.setLayout(new BorderLayout());
        JPanel winTool = new MyJPanel();
        winTool.setLayout(new FlowLayout(FlowLayout.RIGHT));
        winTool.add(closeButton);
        toolbar.add(winTool, BorderLayout.EAST);
        JLabel titleLabel = new JLabel("Ebook");
        titleLabel.setFont(titleLabel.getFont().deriveFont(20f));
        toolbar.add(titleLabel, BorderLayout.CENTER);
        toolbar.add(Box.createRigidArea(new Dimension(50,50)),BorderLayout.WEST);
        toolbar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
        });
        toolbar.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });
        book = PDFUtil.PDFLoad(file, bookType);
        add(toolbar,BorderLayout.NORTH);
        add(new Details(book, true),BorderLayout.CENTER);
        
        
        
        JPanel buttonPanel = new MyJPanel();
        JButton button = new MyButton("确认");
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BookServiceImpl bookServiceImpl = new BookServiceImpl();
				try {
					bookServiceImpl.add(book);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
        buttonPanel.add(button);
        add(buttonPanel,BorderLayout.SOUTH);
        setVisible(true);
	}
}
