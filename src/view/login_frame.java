package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;

import Dao.UserDao;
import models.user;
import util.DbUtil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JCheckBox;

public class login_frame extends JFrame {
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	private JCheckBox TypeOfMerchants;
    private JCheckBox TypeOfCustomer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_frame frame = new login_frame();
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
	public login_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 530);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login_frame.class.getResource("/icon/\u767B\u5F55.png")));
		lblNewLabel.setBackground(SystemColor.text);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(login_frame.class.getResource("/icon/\u8D26\u53F7\u8BBE\u7F6E.png")));
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("  \u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(login_frame.class.getResource("/icon/\u5BC6\u7801.png")));
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginActionPerformed(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(login_frame.class.getResource("/icon/\u767B\u5F552.png")));
		btnNewButton.setForeground(SystemColor.textText);
		btnNewButton.setBackground(UIManager.getColor("Button.highlight"));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				replaceActionPerformed(arg0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(login_frame.class.getResource("/icon/\u91CD\u7F6E.png")));
		btnNewButton_1.setForeground(SystemColor.textText);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(login_frame.class.getResource("/icon/\u5BB6\u7535\u4E0B\u5355\u79CD\u7C7B\u9009\u62E9 (1).png")));
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		
		TypeOfMerchants = new JCheckBox("\u5546\u5BB6");
		TypeOfMerchants.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		
		TypeOfCustomer = new JCheckBox("\u987E\u5BA2");
		TypeOfCustomer.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(117)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(55)
									.addComponent(TypeOfMerchants)
									.addGap(29))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(18)))
							.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addGap(23))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(TypeOfCustomer)
									.addGap(38)))))
					.addGap(201))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(341)
					.addComponent(lblNewLabel)
					.addContainerGap(354, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel)
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(86)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(TypeOfMerchants)
						.addComponent(TypeOfCustomer))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(3))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
	protected void replaceActionPerformed(ActionEvent arg0) {
		userNameTxt.setText("");
		passwordTxt.setText("");
		TypeOfMerchants.setSelected(false);
		TypeOfCustomer.setSelected(false);
	}

	private void loginActionPerformed(ActionEvent evt){
		String userName=userNameTxt.getText();
		String password=new String(passwordTxt.getText());
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null, "’À∫≈≤ªƒ‹Œ™ø’");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "√‹¬Î≤ªƒ‹Œ™ø’");
			return;
		}
		if(!(TypeOfMerchants.isSelected()||TypeOfCustomer.isSelected()))
		{
			JOptionPane.showMessageDialog(null, "«Î—°‘Ò”√ªß¿‡–Õ!");
			return;
		}
		if(TypeOfMerchants.isSelected()&&TypeOfCustomer.isSelected())
		{
			JOptionPane.showMessageDialog(null, "ƒ˙÷ªƒ‹—°‘Ò“ª÷÷”√ªß¿‡–Õ!");
			return;
		}
		user user=new user(userName,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			user currentUser = userDao.login(con, user);
			if (currentUser != null) {
				 if(TypeOfMerchants.isSelected())
				 {
					dispose();new Mainframe_Merchants().setVisible(true);}
				  
				    else if(TypeOfCustomer.isSelected())
				   {  
					        dispose();new Mainframe_Customer().setVisible(true);
				   }}
				    else {
				         JOptionPane.showMessageDialog(null, "’À∫≈√‹¬Î¥ÌŒÛ£°");
						 return;
			            }}
		  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "µ«¬Ω ß∞‹£°");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
