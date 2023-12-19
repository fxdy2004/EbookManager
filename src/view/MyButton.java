package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MyButton extends JButton {
    public MyButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setBackground(Color.PINK);
        setFont(getFont().deriveFont(20f));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
    }
}