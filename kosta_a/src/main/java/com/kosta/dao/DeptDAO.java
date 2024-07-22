package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kosta.db.ConnectionProvider;
import com.kosta.vo.DeptVO;

public class DeptDAO {
	public int insert(DeptVO d) {
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println(e);
		}
		return re;
	}

	public int update(DeptVO d) {
		int re = -1;
		String sql = "update dept set dname=?, dloc=? where dno=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getDloc());
			pstmt.setInt(3, d.getDno());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println(e);
		}
		return re;
	}

	public int delete(int dno) {
		int re = -1;
		String sql = "delete dept where dno=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dno);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println(e);
		}
		return re;
	}
	
	public ArrayList<DeptVO> findAll(){
		ArrayList<DeptVO> list = new ArrayList<>();
		
		try {
			String sql = "select * from dept";
			Connection conn  = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
}
