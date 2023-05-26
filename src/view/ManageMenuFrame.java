package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import models.Menu;
import models.Order;
import util.DbUtil;
import util.StringUtil;
import Dao.MenuDao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ManageMenuFrame extends JInternalFrame {
	private JTable table;
	private JTextField IdTxt;
	private JTextField CuisineTxt;
	private JTextField PriceTxt;
	private DbUtil dbUtil = new DbUtil();
	private MenuDao menuDao=new MenuDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMenuFrame frame = new ManageMenuFrame();
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
	public ManageMenuFrame() {
		setFrameIcon(new ImageIcon(ManageMenuFrame.class.getResource("/icon/\u5546\u5BB6.png")));
		setForeground(SystemColor.text);
		setBackground(SystemColor.text);
	
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 697, 583);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u83DC\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)
					.addGap(94))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u5E8F\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u83DC\u540D\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C\uFF1A");
		
		IdTxt = new JTextField();
		IdTxt.setEditable(false);
		IdTxt.setColumns(10);
		
		CuisineTxt = new JTextField();
		CuisineTxt.setColumns(10);
		
		PriceTxt = new JTextField();
		PriceTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUpdateActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuDeleteActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u91CD\u7F6E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ReSetValues();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(IdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(47)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(CuisineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addGap(30)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_3)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(IdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(CuisineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TableMouseClicked(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u83DC\u540D", "\u4EF7\u683C"
			}
		));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
 		getContentPane().setLayout(groupLayout);
        this.fillTable(new Menu());
	}
	private void AddActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String Cuisine=CuisineTxt.getText();
		String Price=PriceTxt.getText();
		if(StringUtil.isEmpty(Cuisine)){
			JOptionPane.showMessageDialog(null, "请输入菜名！");
			return;
		}
		if(StringUtil.isEmpty(Price)){
			JOptionPane.showMessageDialog(null, "请输入价格！");
			return;
		}
		Menu menu=new Menu(Cuisine,Integer.valueOf(Price));
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=menuDao.add(con, menu);
			if(n==1){
				JOptionPane.showMessageDialog(null, "菜品添加成功！");
				ReSetValues();
				fillTable(new Menu());
			}else{
				JOptionPane.showMessageDialog(null, "菜品添加失败！");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "菜品添加失败！");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void ReSetValues() {
		// TODO Auto-generated method stub
		IdTxt.setText("");
		CuisineTxt.setText("");
		PriceTxt.setText("");
	}

	private void MenuUpdateActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String Id = IdTxt.getText();
		String Cuisine=CuisineTxt.getText();
		String Price=PriceTxt.getText();
		if (StringUtil.isEmpty(Id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的菜品！");
			return;
		}
		Menu menu=new Menu(Integer.valueOf(Id),Cuisine,Integer.valueOf(Price));
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = menuDao.update(con, menu);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				ReSetValues();
				this.fillTable(new Menu());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void TableMouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
	this.IdTxt.setText(String.valueOf(table.getValueAt(row, 0)));
	this.CuisineTxt.setText(String.valueOf(table.getValueAt(row, 1)));
	this.PriceTxt.setText(String.valueOf(table.getValueAt(row, 2)));
	}
	private void fillTable(Menu menu) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = menuDao.list(con, menu);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("Cuisine"));
				v.add(rs.getFloat("price"));
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
	private void MenuDeleteActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String id = IdTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的菜品！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录吗？");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				
				int deleteNum = menuDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					ReSetValues();
					fillTable(new Menu());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}}}
		

