package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import models.Order;
import Dao.OrderDao;
import util.DbUtil;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class OrderDetailFrame extends JInternalFrame {
	private DbUtil dbUtil = new DbUtil();
	private OrderDao orderDao=new OrderDao();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailFrame frame = new OrderDetailFrame();
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
	public OrderDetailFrame() {
		setFrameIcon(new ImageIcon(OrderDetailFrame.class.getResource("/icon/\u5546\u5BB6.png")));
		setForeground(SystemColor.text);
		setBackground(SystemColor.text);
		setTitle("\u8BA2\u5355\u8BE6\u7EC6"); 
		setBounds(0,0,1000,1000);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setBounds(300,0,600,400);
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u8BA2\u5355\u8BE6\u7EC6");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u83DC\u540D", "\u4EF7\u683C", "\u6570\u91CF", "\u603B\u4EF7"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(151);
		table.getColumnModel().getColumn(1).setPreferredWidth(144);
		table.getColumnModel().getColumn(2).setPreferredWidth(157);
		table.getColumnModel().getColumn(3).setPreferredWidth(147);
		table.getColumnModel().getColumn(4).setPreferredWidth(145);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(lblNewLabel);
		getContentPane().add(scrollPane);
		this.fillTable(new Order());      
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

