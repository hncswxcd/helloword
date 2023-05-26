package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Menu;
import models.Order;
import util.StringUtil;


public class OrderDao{

	public ResultSet list(Connection con,Order order) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from order_db");
		if(StringUtil.isNotEmpty(order.getCuisine())){
			sb.append(" and Cuisine like '%"+order.getCuisine()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from order_db where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
	
	public boolean existBookByBookTypeId(Connection con,String OrderId)throws Exception{
		String sql="select * from order_db where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, OrderId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	public int add(Connection con,Order order)throws Exception{
		String sql="insert into order_db values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, order.getId());
		pstmt.setString(2, order.getCuisine());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getNum());
		pstmt.setInt(5,order.getPrice());
		return pstmt.executeUpdate();
	}
	
}
