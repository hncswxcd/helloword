package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.DbUtil;
import util.StringUtil;
import Dao.MenuDao;
import Dao.OrderDao;
import models.Menu;
import models.Order;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class MenuDetailFrame extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil = new DbUtil();
	private MenuDao menuDao=new MenuDao();
	private OrderDao orderDao=new OrderDao();
	private JTextField IdTxt;
	private JTextField PriceTxt;
	private JTextField CuisineTxt;
	private JTextField NumTxt;
	private JTextField SumTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDetailFrame frame = new MenuDetailFrame();
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
	public MenuDetailFrame() {
		setFrameIcon(new ImageIcon(MenuDetailFrame.class.getResource("/icon/\u987E\u5BA2.png")));
		setForeground(SystemColor.text);
		setBackground(SystemColor.text);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u83DC\u5355\u9875\u9762");
		setBounds(100, 100, 787, 712);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u64CD\u4F5C\u533A\u57DF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("     \u6DFB\u52A0     ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Id=IdTxt.getText();
				String Cuisine=CuisineTxt.getText();
				String Price=PriceTxt.getText();
				String Num=NumTxt.getText();
				String Sum=SumTxt.getText();
				if(StringUtil.isEmpty(Cuisine)){
					JOptionPane.showMessageDialog(null, "请选择菜单菜品！");
					return;
				}
				Double price=Double.parseDouble(PriceTxt.getText());
				Double sum=Double.parseDouble(SumTxt.getText());
				Order order=new Order(Integer.parseInt(Id),Cuisine,price.intValue(),Integer.parseInt(Num),sum.intValue());
				Connection con=null;
				try {
					con=dbUtil.getCon();
					int n=orderDao.add(con, order);
					if(n==1){
						JOptionPane.showMessageDialog(null, "订单添加成功！");
						ReSetValues();
						fillTable(new Menu());
					}else{
						JOptionPane.showMessageDialog(null, "订单添加失败！");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "订单添加失败！");
				}finally{
					try {
						dbUtil.closeCon(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		JLabel Id = new JLabel("\u5E8F\u53F7\uFF1A");
		
		JLabel Price = new JLabel("\u4EF7\u683C\uFF1A");
		
		IdTxt = new JTextField();
		IdTxt.setEditable(false);
		IdTxt.setColumns(10);
		
		PriceTxt = new JTextField();
		PriceTxt.setEditable(false);
		PriceTxt.setColumns(10);
		
		JLabel Cuisine = new JLabel("\u83DC\u540D\uFF1A");
		
		CuisineTxt = new JTextField();
		CuisineTxt.setEditable(false);
		CuisineTxt.setColumns(10);
		
		JLabel Num = new JLabel("\u6570\u91CF\uFF1A");
		
		NumTxt = new JTextField();
		NumTxt.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(!NumTxt.getText().equals(""))
				{Double p=Double.parseDouble(PriceTxt.getText());
				SumTxt.setText(String.valueOf(Integer.parseInt(NumTxt.getText())*p.intValue()));}
				else return;
			}
		});
		
	

		NumTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u8BE6\u7EC6\u8BA2\u5355");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showConfirmDialog(null, "请前往订单页查看");
			}
		});
		
		JLabel Sum = new JLabel("\u603B\u4EF7\uFF1A");
		
		SumTxt = new JTextField();
		SumTxt.setEditable(false);
		SumTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(Id)
									.addGap(18)
									.addComponent(IdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(Price)
									.addGap(18)
									.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(208)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(Cuisine)
								.addComponent(Num))
							.addGap(27))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(Sum)
							.addGap(18)
							.addComponent(SumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(87)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(NumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(CuisineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(68, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Id)
						.addComponent(IdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Cuisine)
						.addComponent(CuisineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Price)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Num)
						.addComponent(NumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(Sum)
						.addComponent(SumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(26))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row=table.getSelectedRow();
				IdTxt.setText(String.valueOf(table.getValueAt(row, 0)));
				CuisineTxt.setText(String.valueOf(table.getValueAt(row, 1)));
				PriceTxt.setText(String.valueOf(table.getValueAt(row, 2)));
				NumTxt.setText("1");
				JOptionPane.showMessageDialog(null,"默认份数为1，如需添加请自行输入");
				SumTxt.setText(String.valueOf(Integer.parseInt(NumTxt.getText())*Double.parseDouble(PriceTxt.getText())));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u83DC\u540D", "\u4EF7\u683C"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
        this.fillTable(new Menu());
	}
	private void ReSetValues() {
		// TODO Auto-generated method stub
		IdTxt.setText("");
		CuisineTxt.setText("");
		PriceTxt.setText("");
		NumTxt.setText("");
		SumTxt.setText("");
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
}
