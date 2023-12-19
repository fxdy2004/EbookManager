package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.User;
import service.UserService;
import service.UserServiceImpl;

public class LogOn extends JFrame{
	UserService userService = new UserServiceImpl();
    private static Point mouseDownCompCoords = null;
	public LogOn() {
		setTitle("LogIn");
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
        
        JTextField nameField = new JTextField();
        nameField.addFocusListener(new JTextFieldHintListener(nameField, "用户名"));
        nameField.setFont(nameField.getFont().deriveFont(20f));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        
        JTextField phoneField = new JTextField();
        phoneField.addFocusListener(new JTextFieldHintListener(phoneField, "手机号"));
        phoneField.setFont(phoneField.getFont().deriveFont(20f));
        phoneField.setHorizontalAlignment(JTextField.CENTER);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(passwordField.getFont().deriveFont(20f));
        passwordField.setHorizontalAlignment(JPasswordField.CENTER);
        passwordField.addFocusListener(new JPasswordFieldHinlistener(passwordField, "密码"));
        
        JPanel buttonPanel = new MyJPanel();
        JButton loginButton = new MyButton("注册");
        loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword());
				if(nameField.getText().equals("用户名")||phoneField.getText().equals("手机号")||password.equals("密码")) {
					JDialog dialog = new JDialog(LogOn.this, "注册失败", true);
					dialog.setLayout(new BorderLayout());
					dialog.setLocationRelativeTo(null);
					dialog.setSize(150,150);
					JLabel label = new JLabel("注册失败");
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setFont(getFont().deriveFont(20f));
					dialog.add(label,BorderLayout.CENTER);
					JButton button = new MyButton("确定");
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dialog.dispose();
						}
					});
					JPanel panel = new MyJPanel();
					panel.add(button);
					dialog.add(panel,BorderLayout.SOUTH);
					dialog.setVisible(true);
				}else {
					User user = new User();
					user.setUserName(nameField.getText());
					user.setPhone(phoneField.getText());
					user.setPassword(password);
					try {
						if(userService.logon(user)==true) {
							dispose();
							new MainWindow();
						}
					}catch (Exception e1) {
						System.out.println("注册出错");
						e1.printStackTrace();
					}
				}
			}
		});
        buttonPanel.add(loginButton);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5,1));
        mainPanel.add(nameField);
        mainPanel.add(Box.createHorizontalGlue());
        mainPanel.add(phoneField);
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
