package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import service.EBook;

public class BookCover extends JPanel{
	private ImageIcon bookCover;
    private String bookName;

    public BookCover(EBook book) {
        this.bookCover = book.getCoverImageIcon();
        this.bookName = book.getBookName();

        setPreferredSize(new Dimension(100, 150)); // 设置尺寸

        JLabel coverLabel = new JLabel(resizeImage(bookCover)); // 创建包含调整大小后的封面图像的标签
        JLabel titleLabel = new JLabel(bookName); // 创建显示书名的标签
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 设置标题居中对齐

        setLayout(new BorderLayout()); // 使用边界布局管理器
        add(coverLabel, BorderLayout.CENTER); // 将封面标签放置在中间位置
        add(titleLabel, BorderLayout.SOUTH); // 将书名标签放置在底部位置
        addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow.replacePage(new Details(book));
			}
		});
    }

    private ImageIcon resizeImage(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        int width = 100; // 调整为合适的宽度
        int height = 150; // 调整为合适的高度
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
