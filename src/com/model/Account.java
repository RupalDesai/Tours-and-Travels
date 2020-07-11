package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Country;

public class Account {
	String user="root";
	String password ="";
	String url="jdbc:mysql://localhost:3306/";
	
	String dbname="tour";
	String driver="com.mysql.jdbc.Driver";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rst;
	
	ArrayList<Country> list = new ArrayList<Country>();
	
	private void dbConnect() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
	    con = DriverManager.getConnection(url+dbname,user,password);
	}
	
	private void dbClose() throws SQLException{
		con.close();
	}
	
	public ArrayList<Country> getDestination(String location_id) throws Exception{
		dbConnect();
		String sql="select * from country where continent_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(location_id));
		ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Country c=new Country();
				c.setId(rst.getInt("id"));
				c.setName(rst.getString("country_name"));
				c.setGrade(rst.getString("grade"));
				list.add(c);
				c=null;
			}
			dbClose();
		return list;
	}

	public void insertPackage(String pname, String price, String details,
			String continent_id) throws Exception{
		dbConnect();
		String sql ="insert into package(pname,details,price,continent_id) values(?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, pname);
		pstmt.setString(2, details);
		pstmt.setString(3, price);
		pstmt.setInt(4, Integer.parseInt(continent_id));
		
		pstmt.executeUpdate();
		dbClose();
		
	}

	public void addImage(String name,String pac) throws Exception{
		dbConnect();
		String sql ="insert into images(name,package_id) values(?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, Integer.parseInt(pac));
		pstmt.executeUpdate();
		dbClose();
		
	}
}









