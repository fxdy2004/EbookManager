package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;




public class LogOn extends JFrame{
    private static Point mouseDownCompCoords = null;
	public LogOn() {
		setTitle("LogOn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());
        
        JButton minButton = new MyButton("➖");
        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(Frame.ICONIFIED);  // 最小化窗口
            }
        });
        JButton closeButton = new MyButton("❌");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JPanel toolbar = new MyJPanel();
        toolbar.setLayout(new BorderLayout());
        JPanel winTool = new MyJPanel();
        winTool.setLayout(new FlowLayout(FlowLayout.RIGHT));
        winTool.add(minButton);
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
        
        add(toolbar,BorderLayout.NORTH);
        
        JTextField idField = new JTextField();
        idField.addFocusListener(new JTextFieldHintListener(idField, "用户名/邮箱/手机号"));
        idField.setFont(idField.getFont().deriveFont(20f));
        idField.setHorizontalAlignment(JTextField.CENTER);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(passwordField.getFont().deriveFont(20f));
        passwordField.setHorizontalAlignment(JPasswordField.CENTER);
        passwordField.addFocusListener(new JPasswordFieldHinlistener(passwordField, "密码"));
        
        JPanel buttonPanel = new MyJPanel();
        JButton logOnButton = new MyButton("登录");
        JButton registerButton = new MyButton("注册");
        JButton forgetButton = new MyButton("忘记密码");
        buttonPanel.add(registerButton);
        buttonPanel.add(logOnButton);
        buttonPanel.add(forgetButton);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5,1));
        mainPanel.add(Box.createHorizontalGlue());
        mainPanel.add(idField);
        mainPanel.add(Box.createHorizontalGlue());
        mainPanel.add(passwordField);
        
        add(mainPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(50,500)),BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(50,500)),BorderLayout.EAST);
        
        setVisible(true);
	}
	public static void main(String args[]) {
		new LogOn();
	}
}
