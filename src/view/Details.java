package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import service.EBook;
import uitl.ImageUtil;

public class Details extends JPanel{
    public Details(EBook book,boolean flag) {
        setPreferredSize(new Dimension(600, 400));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

     // 图书封面  
        JLabel coverlLabel = new JLabel(ImageUtil.resizeImage(book.getCoverImageIcon(), 150, 200));  
        coverlLabel.setBorder(null);
        coverlLabel.setPreferredSize(new Dimension());
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        gbc.gridheight = 5;  
        gbc.gridwidth = 1;  
        gbc.weighty = 0.5;  
        gbc.weightx = 0.3;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(coverlLabel, gbc);  
        // 图书属性  
        JTextField nameField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField publicationField = new JTextField();
        JTextField pressField = new JTextField();
        JTextField isbnField = new JTextField();
        
        nameField.setText(book.getBookName());
        authorField.setText(book.getAuthor());
        publicationField.setText(book.getPublicationDate());
        pressField.setText(book.getPress());
        isbnField.setText(book.getIsbn());
        
        nameField.setEditable(flag);
        authorField.setEditable(flag);
        publicationField.setEditable(flag);
        pressField.setEditable(flag);
        isbnField.setEditable(flag);
        
        nameField.addFocusListener(new TextListener(book, nameField.getText(), 1));
        authorField.addFocusListener(new TextListener(book, authorField.getText(), 2));
        publicationField.addFocusListener(new TextListener(book, publicationField.getText(), 3));
        pressField.addFocusListener(new TextListener(book, pressField.getText(), 4));
        isbnField.addFocusListener(new TextListener(book, isbnField.getText(), 5));
        
        JPanel bookPropertiesPanel = new JPanel();  
        bookPropertiesPanel.setPreferredSize(new Dimension());
        bookPropertiesPanel.setLayout(new GridLayout(5, 2));
        bookPropertiesPanel.add(new MyLabel("名称"));
        bookPropertiesPanel.add(new MyLabel(book.getBookName()));
        bookPropertiesPanel.add(new MyLabel("作者"));
        bookPropertiesPanel.add(new MyLabel(book.getAuthor()));
        bookPropertiesPanel.add(new MyLabel("版次"));
        bookPropertiesPanel.add(new MyLabel(book.getPublicationDate().toString()));
        bookPropertiesPanel.add(new MyLabel("出版社"));
        bookPropertiesPanel.add(new MyLabel(book.getPress()));
        bookPropertiesPanel.add(new MyLabel("ISBN"));
        bookPropertiesPanel.add(new MyLabel(book.getIsbn()));
        
        gbc.gridx = 1;  
        gbc.gridy = 0;  
        gbc.gridheight = 5;  
        gbc.gridwidth = 1;  
        gbc.weighty = 0.5;  
        gbc.weightx = 0.7;  
        add(bookPropertiesPanel, gbc);  
          
        // 详情  
        JTextArea textArea= new JTextArea(book.getDescription());
        textArea.addFocusListener(new TextListener(book, textArea.getText(), 6));
        textArea.setFont(getFont().deriveFont(20f));
        textArea.setLineWrap(true);
        textArea.setEditable(flag);
        JScrollPane details = new JScrollPane(textArea);
        details.setPreferredSize(new Dimension());
        details.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        details.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        details.setBackground(Color.GRAY);  
        gbc.gridx = 0;  
        gbc.gridy = 6;  
        gbc.gridheight = 2;  
        gbc.gridwidth = 2;  
        gbc.weighty = 0.3;  
        add(details, gbc);  
          
        // 提交人  
        JLabel submitterLabel = new JLabel("提交人id: "+book.getSubmissionUserId());
        submitterLabel.setPreferredSize(new Dimension());
        submitterLabel.setFont(getFont().deriveFont(20f));
        submitterLabel.setBackground(Color.YELLOW);  
        
        gbc.gridx = 0;  
        gbc.gridy = 8;  
        gbc.gridheight = 1;  
        gbc.gridwidth = 2;  
        gbc.weighty = 0.05;  
        add(submitterLabel, gbc);  
          
        // 提交日期  
        JLabel submissionDateLabel = new JLabel("提交日期: "+book.getSubmissionDate());
        submissionDateLabel.setPreferredSize(new Dimension());
        submissionDateLabel.setFont(getFont().deriveFont(20f));
        submissionDateLabel.setBackground(Color.GREEN);  
        gbc.gridx = 0;  
        gbc.gridy = 9;  
        gbc.gridheight = 1;  
        gbc.gridwidth = 2;  
        gbc.weighty = 0.05;  
        add(submissionDateLabel, gbc);
    }
}
