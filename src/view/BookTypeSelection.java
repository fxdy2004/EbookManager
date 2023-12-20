package view;

import javax.swing.*;

import service.EBook;

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

public class BookTypeSelection extends JDialog {
    private JComboBox<EBook.BookType> comboBox;


    public BookTypeSelection(File file,JFrame parent, String title, boolean modal) {
    	super(parent, title, modal);
        setTitle("选择图书类别");
        setSize(300, 200);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        comboBox = new JComboBox<>(EBook.BookType.values());
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EBook.BookType selectedType = (EBook.BookType) comboBox.getSelectedItem();
                if (selectedType != null) {
                    try {
                    	dispose();
						new BookInformationAdd(file, selectedType, parent, title, modal);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(comboBox);
        add(panel);

        setVisible(true);
    }
}
