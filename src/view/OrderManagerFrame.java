package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.DbUtil;
import util.StringUtil;
import Dao.OrderDao;
import models.Order;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JTextField;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class OrderManagerFrame extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil = new DbUtil();
	private OrderDao orderDao=new OrderDao();
	public String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderManagerFrame frame = new OrderManagerFrame();
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
	public OrderManagerFrame() {
		setFrameIcon(new ImageIcon(OrderManagerFrame.class.getResource("/icon/\u987E\u5BA2.png")));
		setForeground(SystemColor.text);
		setBackground(SystemColor.text);
		setTitle("\u8BA2\u5355\u7BA1\u7406\u7CFB\u7EDF");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 815, 609);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8BA2\u5355\u7BA1\u7406");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		
		JButton btnNewButton = new JButton("\u589E\u6DFB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "ÇëÇ°Íù²Ëµ¥Ìí¼Ó");
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderDeleteActionPerformed(arg0);
			}
		});
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(203)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(215))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(356, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(355))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(label)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(34))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				OrderDetailTableMousePressed(arg0);
			}
		});
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u83DC\u540D", "\u4EF7\u683C", "\u6570\u91CF", "\u603B\u4EF7"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(149);
		table.getColumnModel().getColumn(1).setPreferredWidth(143);
		table.getColumnModel().getColumn(2).setPreferredWidth(151);
		table.getColumnModel().getColumn(3).setPreferredWidth(151);
		table.getColumnModel().getColumn(4).setPreferredWidth(145);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
        this.fillTable(new Order());
	}
	private void OrderDetailTableMousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		id=String.valueOf(table.getValueAt(row, 0));
	}

	private void OrderDeleteActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "ÇëÑ¡ÔñÒªÉ¾³ýµÄ¶©µ¥£¡");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "È·¶¨ÒªÉ¾³ýÕâÌõ¶©µ¥Âð£¿");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = orderDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
					this.fillTable(new Order());
				} else {
					JOptionPane.showMessageDialog(null, "É¾³ýÓÐÎó");
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü");
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	private void fillTable(Order order) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = orderDao.list(con, order);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("Cuisine"));
				v.add(rs.getInt("price"));
				v.add(rs.getInt("num"));
				v.add(rs.getInt("sum"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
