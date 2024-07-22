package com.kosta.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {	
	public static  Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "c##madang";
		String password = "madang";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}	
		return conn;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	public static void close(Statement stmt, Connection conn) {
		try {		
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}




















