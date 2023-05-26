package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import Dao.OrderDao;
import util.DbUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Mainframe_Merchants extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane=null;
	private DbUtil dbUtil = new DbUtil();
	private OrderDao orderDao=new OrderDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe_Merchants frame = new Mainframe_Merchants();
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
	public Mainframe_Merchants() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mainframe_Merchants.class.getResource("/icon/\u5546\u5BB6.png")));
		setTitle("\u70B9\u9910\u7CFB\u7EDF_\u5546\u5BB6");
		setBackground(UIManager.getColor("Button.highlight"));
		setForeground(UIManager.getColor("Button.highlight"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1165, 785);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setForeground(SystemColor.text);
		menuBar.setBackground(SystemColor.text);
		menuBar.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		setJMenuBar(menuBar);
		
		JMenu ¶©µ¥¹ÜÀí = new JMenu("                    \u8BA2\u5355\u7BA1\u7406                    ");
		¶©µ¥¹ÜÀí.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		menuBar.add(¶©µ¥¹ÜÀí);
		
		JMenuItem OderOfDetail = new JMenuItem("                             \u8BA2\u5355\u8BE6\u7EC6                                 ");
		OderOfDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			OrderDetailFrame orderDetailFrame=new OrderDetailFrame();
			orderDetailFrame.setVisible(true);
			orderDetailFrame.setLocation(650, 200);
		    desktopPane.add(orderDetailFrame);
			}
		});
		OderOfDetail.setForeground(SystemColor.desktop);
		OderOfDetail.setBackground(SystemColor.text);
		OderOfDetail.setHorizontalAlignment(SwingConstants.CENTER);
		OderOfDetail.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		¶©µ¥¹ÜÀí.add(OderOfDetail);
		
		JMenu mnNewMenu_1 = new JMenu("                    \u83DC\u54C1\u7BA1\u7406                    ");
		mnNewMenu_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("            \u3001          \u83DC\u54C1\u79CD\u7C7B\u7BA1\u7406                              ");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageMenuActionPerformed(arg0);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 17));
		mntmNewMenuItem_3.setBackground(SystemColor.text);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu = new JMenu("          \u8054\u7CFB\u6211\u4EEC           ");
		mnNewMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("                \u7535\u8BDD                       ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "µç»°£º13142424244");
			}
		});
		mntmNewMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("                \u90AE\u7BB1                     ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "E-Mail:7704@hncu.com");
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.highlight"));
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 desktopPane = new JDesktopPane();
		 desktopPane.setForeground(Color.WHITE);
		 desktopPane.setBorder(null);
		 desktopPane.setBackground(new Color(64, 224, 208));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	protected void ManageMenuActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ManageMenuFrame manageMenuFrame=new ManageMenuFrame();
		manageMenuFrame.setVisible(true);
		manageMenuFrame.setLocation(600, 180);
	    desktopPane.add(manageMenuFrame);
	}

}
