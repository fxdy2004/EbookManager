package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

public class MainWindow extends JFrame {
    private static Point mouseDownCompCoords = null;
    private static String DownloadAddress = "C:\\";
    private static JPanel content;
    public MainWindow() {
        setTitle("侧边栏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel sidebar = new MyJPanel();
        sidebar.setPreferredSize(new Dimension(50, 500));
        
        JButton button1 = new MyButton("🏠");

        JButton button2 = new MyButton("🔍");

        JButton button3 = new MyButton("🔼");

        JButton button4 = new MyButton("⏬");

        JButton button5 = new MyButton("🔁");

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

        JButton setButton = new MyButton("⚙️");

        sidebar.add(button1);
        sidebar.add(button2);
        sidebar.add(button3);
        sidebar.add(button4);
        sidebar.add(button5);


        content = new JPanel();
        content.setLayout(new FlowLayout());
        JPanel homepage = new HomePage();
        JPanel search = new Search();
        JPanel setface = new SetFace();
        content.add(homepage);
        
        button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				replacePage(homepage);
			}
		});
        button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				replacePage(search);
			}
		});
        button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
				            File selectedFile = fileChooser.getSelectedFile();
				            // 处理选择的文件
				            System.out.println("用户选中了一个文件");
				        }
					}
				});
				replacePage(fileChooser);
			}
		});
        button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(new File(DownloadAddress));
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
				            File selectedFile = fileChooser.getSelectedFile();
				            // 处理选择的文件
				            System.out.println("用户选中了一个文件");
				        }
					}
				});
				replacePage(fileChooser);
			}
		});
        button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new LogOnDialog(MainWindow.this,"重新登录",true);
			}
		});
        setButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				replacePage(setface);
			}
		});
        
        JButton toggleButton = new MyButton("🔜");
        toggleButton.setToolTipText("点击展开侧边栏");
        toggleButton.addActionListener(new ActionListener() {
            private static boolean isSidebarShown = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSidebarShown) {
                    sidebar.setPreferredSize(new Dimension(50, 500));
                    toggleButton.setText("🔜");
                    button1.setText("🏠");
                    button2.setText("🔍");
                    button3.setText("🔼");
                    button4.setText("⏬");
                    button5.setText("🔁");
                    setButton.setText("⚙️");
                    validate();
                    isSidebarShown = false;
                } else {
                    remove(sidebar);
                    sidebar.setPreferredSize(new Dimension(100, 500));
                    toggleButton.setText("🔙");
                    button1.setText("首页");
                    button2.setText("搜索");
                    button3.setText("我的上传");
                    button4.setText("我的下载");
                    button5.setText("切换账号");
                    setButton.setText("设置");
                    add(sidebar, BorderLayout.WEST);
                    validate();
                    isSidebarShown = true;
                }
            }
        });

        JPanel toolbar = new MyJPanel();
        toolbar.setLayout(new BorderLayout());
        toolbar.add(toggleButton, BorderLayout.WEST);
        JPanel winTool = new MyJPanel();
        winTool.setLayout(new FlowLayout(FlowLayout.RIGHT));
        winTool.add(minButton);
        winTool.add(maxButton);
        winTool.add(closeButton);
        toolbar.add(winTool, BorderLayout.EAST);

        JLabel titleLabel = new JLabel("Ebook");
        titleLabel.setFont(titleLabel.getFont().deriveFont(20f));
        toolbar.add(titleLabel, BorderLayout.CENTER);

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

        JPanel setPanel = new MyJPanel();
        setPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        setPanel.add(setButton);


        add(toolbar, BorderLayout.NORTH);
        add(sidebar, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);
        add(setPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });
    }

    public static void replacePage(Component comp) {
    	content.removeAll();;
		content.add(comp);
		content.revalidate();
		content.repaint();
    }

    
}
