package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;

import models.Order;
import java.awt.Color;
import java.awt.Toolkit;

public class Mainframe_Customer extends JFrame {
	private JDesktopPane desktopPane;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe_Customer frame = new Mainframe_Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainframe_Customer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mainframe_Customer.class.getResource("/icon/\u987E\u5BA2.png")));
		setForeground(Color.WHITE);
		setTitle("\u70B9\u9910\u7CFB\u7EDF_\u987E\u5BA2");
		setBackground(SystemColor.text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 764);
	    desktopPane = new JDesktopPane();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.text);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("                        \u70B9\u9910                        ");
		mnNewMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		mnNewMenu.setBackground(SystemColor.text);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("                       \u6253\u5F00\u83DC\u5355                         ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuDetailFrame menuDetailFrame=new MenuDetailFrame();
				menuDetailFrame.setVisible(true);
				menuDetailFrame.setLocation(550, 150);
				desktopPane.add(menuDetailFrame);
			}
		});
		mntmNewMenuItem.setBackground(SystemColor.text);
		mntmNewMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("                    \u4E2A\u4EBA\u8BA2\u5355                       ");
		mnNewMenu_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("                      \u8BA2\u5355\u7BA1\u7406                        ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderManagerFrame orderManagerFrame=new OrderManagerFrame();
				orderManagerFrame.setVisible(true);
				orderManagerFrame.setLocation(540, 150);
				desktopPane.add(orderManagerFrame);
			}
		});
		mntmNewMenuItem_1.setBackground(SystemColor.text);
		mntmNewMenuItem_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("           \u8054\u7CFB\u6211\u4EEC            ");
		mnNewMenu_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		mnNewMenu_2.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("               \u7535\u8BDD                  ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "µç»°£º13142424244");
			}
		});
		mntmNewMenuItem_2.setBackground(SystemColor.text);
		mntmNewMenuItem_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("E-Mail");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "E-Mail:7704@hncu.com");
			}
		});
		mntmNewMenuItem_3.setBackground(SystemColor.text);
		mntmNewMenuItem_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_2.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	
		desktopPane.setBackground(new Color(240, 255, 240));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
