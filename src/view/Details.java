package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.EBook;

public class Details extends JPanel{
	public Details(EBook book) {
		setBackground(Color.CYAN);
		setPreferredSize(new Dimension(600, 400));
		setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // 图书封面
        JPanel coverPanel = new JPanel();
        coverPanel.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        add(coverPanel, gbc);

        // 图书属性
        JPanel bookPropertiesPanel = new JPanel();
        bookPropertiesPanel.setLayout(new GridLayout(7, 1));
        // 添加图书属性组件，如图书名称、作者、出版社等
        // ...

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        add(bookPropertiesPanel, gbc);

        // 详情
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(Color.GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 3;
        gbc.gridwidth = 1;
        add(detailsPanel, gbc);

        // 提交人
        JLabel submitterLabel = new JLabel("提交人");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(submitterLabel, gbc);

        // 提交日期
        JLabel submissionDateLabel = new JLabel("提交日期");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(submissionDateLabel, gbc);
	}
}
