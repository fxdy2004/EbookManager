package view;

import java.awt.Color;

import javax.swing.JPanel;

import uitl.ColorUitl;

public class MyJPanel extends JPanel {
    public MyJPanel() {
        super();
        setBackground(ColorUitl.getSavedColor());
    }
}