package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.EBook;

public class Details extends JPanel{
    public Details(EBook book) {
        setPreferredSize(new Dimension(600, 400));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

     // 图书封面  
        JPanel coverPanel = new JPanel();  
        
        
        
//        JLabel coverLabel = new JLabel(BookCover.resizeImage(book.getCoverImageIcon()));
//        coverPanel.add(coverLabel);
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        gbc.gridheight = 5;  
        gbc.gridwidth = 1;  
        gbc.weighty = 0.5;  
        gbc.weightx = 0.3;
        add(coverPanel, gbc);  
          
        // 图书属性  
        JPanel bookPropertiesPanel = new JPanel();  
        bookPropertiesPanel.setLayout(new GridLayout(7, 1));  
        bookPropertiesPanel.setBackground(Color.ORANGE);  
          
        gbc.gridx = 1;  
        gbc.gridy = 0;  
        gbc.gridheight = 5;  
        gbc.gridwidth = 1;  
        gbc.weighty = 0.5;  
        gbc.weightx = 0.7;  
        add(bookPropertiesPanel, gbc);  
          
        // 详情  
        JPanel detailsPanel = new JPanel();  
        detailsPanel.setBackground(Color.GRAY);  
        gbc.gridx = 0;  
        gbc.gridy = 6;  
        gbc.gridheight = 2;  
        gbc.gridwidth = 2;  
        gbc.weighty = 0.3;  
        add(detailsPanel, gbc);  
          
        // 提交人  
        JPanel submitterLabel = new JPanel();  
        submitterLabel.setBackground(Color.YELLOW);  
        gbc.gridx = 0;  
        gbc.gridy = 8;  
        gbc.gridheight = 1;  
        gbc.gridwidth = 2;  
        gbc.weighty = 0.05;  
        add(submitterLabel, gbc);  
          
        // 提交日期  
        JPanel submissionDateLabel = new JPanel();  
        submissionDateLabel.setBackground(Color.GREEN);  
        gbc.gridx = 0;  
        gbc.gridy = 9;  
        gbc.gridheight = 1;  
        gbc.gridwidth = 2;  
        gbc.weighty = 0.05;  
        add(submissionDateLabel, gbc);
    }
}
