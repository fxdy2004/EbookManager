package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
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

public class Forget extends JFrame {
	UserService userService = new UserServiceImpl();
	private static Point mouseDownCompCoords = null;

	public Forget() {
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
				setState(Frame.ICONIFIED); // 最小化窗口
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
		toolbar.add(Box.createRigidArea(new Dimension(50, 50)), BorderLayout.WEST);
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

		add(toolbar, BorderLayout.NORTH);

		JTextField phoneField = new JTextField();
		phoneField.addFocusListener(new JTextFieldHintListener(phoneField, "电话号码"));
		phoneField.setFont(phoneField.getFont().deriveFont(20f));
		phoneField.setHorizontalAlignment(JTextField.CENTER);

		JPasswordField passwordField1 = new JPasswordField();
		passwordField1.setFont(passwordField1.getFont().deriveFont(20f));
		passwordField1.setHorizontalAlignment(JPasswordField.CENTER);
		passwordField1.addFocusListener(new JPasswordFieldHinlistener(passwordField1, "新密码"));

		JPasswordField passwordField2 = new JPasswordField();
		passwordField2.setFont(passwordField2.getFont().deriveFont(20f));
		passwordField2.setHorizontalAlignment(JPasswordField.CENTER);
		passwordField2.addFocusListener(new JPasswordFieldHinlistener(passwordField2, "确认密码"));

		JPanel buttonPanel = new MyJPanel();
		JButton loginButton = new MyButton("修改密码");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password1 = new String(passwordField1.getPassword());
				String password2 = new String(passwordField2.getPassword());
				try {
					if (password1.equals("新密码") || password2.equals("确认密码") || !password1.equals(password2)) {
						throw new Exception();
					} else {
						User user = new User();
						user.setPassword(password2);
						user.setPhone(phoneField.getText());

						if (userService.forgetPassword(user) == true) {
							System.out.println("更新密码成功!");
							dispose();
							new LogIn();
						} else {
							throw new Exception();
						}
					}
				} catch (Exception e1) {
					System.out.println("更新密码出错");
					e1.printStackTrace();
					JDialog dialog = new JDialog(Forget.this, "更新密码失败", true);
					dialog.setLayout(new BorderLayout());
					dialog.setLocationRelativeTo(null);
					dialog.setSize(150, 150);
					JLabel label = new JLabel("更新密码失败");
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setFont(getFont().deriveFont(20f));
					dialog.add(label, BorderLayout.CENTER);
					JButton button = new MyButton("确定");
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dialog.dispose();
						}
					});
					JPanel panel = new MyJPanel();
					panel.add(button);
					dialog.add(panel, BorderLayout.SOUTH);
					dialog.setVisible(true);
				}
			}
		});
		buttonPanel.add(loginButton);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 1));
		mainPanel.add(phoneField);
		mainPanel.add(Box.createHorizontalGlue());
		mainPanel.add(passwordField1);
		mainPanel.add(Box.createHorizontalGlue());
		mainPanel.add(passwordField2);

		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(Box.createRigidArea(new Dimension(50, 500)), BorderLayout.WEST);
		add(Box.createRigidArea(new Dimension(50, 500)), BorderLayout.EAST);

		setVisible(true);
	}

	public static void main(String args[]) {
		new Forget();
	}
}
