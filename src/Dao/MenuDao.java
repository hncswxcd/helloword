package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import models.Menu;
import models.Order;
import util.StringUtil;

public class MenuDao {
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from menu_db where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
}
	public ResultSet list(Connection con,Menu menu) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from menu_db");
		if(StringUtil.isNotEmpty(menu.getCuisine())){
			sb.append(" and Cuisine like '%"+menu.getCuisine()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public int update(Connection con,Menu menu)throws Exception 
	{
		String sql="update menu_db set Cuisine=?,Price=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,menu.getCuisine());
		pstmt.setInt(2,menu.getPrice());
		pstmt.setInt(3,menu.getId());
		return pstmt.executeUpdate();
	}
	public int add(Connection con,Menu menu)throws Exception{
		String sql="insert into menu_db values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, menu.getCuisine());
		pstmt.setInt(2, menu.getPrice());
		return pstmt.executeUpdate();
	}
	
}