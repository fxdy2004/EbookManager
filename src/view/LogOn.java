package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
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
        JButton maxButton = new MyButton("🔲");
        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getExtendedState() != Frame.MAXIMIZED_BOTH) {
                    setExtendedState(Frame.MAXIMIZED_BOTH);  // 最大化窗口
                } else {
                    setExtendedState(Frame.NORMAL);  // 恢复窗口原始大小
                }
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
        winTool.add(maxButton);
        winTool.add(closeButton);
        toolbar.add(winTool, BorderLayout.EAST);
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
        
        JPanel buttonPanel = new JPanel();
        JButton logOnButton = new MyButton("登录");
        JButton registerButton = new MyButton("注册");
        JButton forgetButton = new MyButton("忘记密码");
        buttonPanel.add(registerButton);
        buttonPanel.add(logOnButton);
        buttonPanel.add(forgetButton);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(idField,BorderLayout.NORTH);
        mainPanel.add(passwordField,BorderLayout.SOUTH);
        
        add(mainPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
        
        setVisible(true);
	}
	public static void main(String args[]) {
		new LogOn();
	}
}
