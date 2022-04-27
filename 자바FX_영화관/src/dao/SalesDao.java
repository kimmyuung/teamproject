package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import dto.Movie;

public class SalesDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static SalesDao salesDao= new SalesDao();
	
	public SalesDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip�ּ�/port��ȣ
		} catch(Exception e) {System.out.println("DB���� ���� !! ���:dao.SalesDao :  "+e);}	
		}
	

	//1. ��ü �� ��ȯ
	public Map<String, Integer> bdatetotal(String table, String date) {
		
		Map<String, Integer> map = new TreeMap<>();
		String sql = "SELECT SUBSTRING_INDEX("+date+", ' ' , 1), SUM(sales) FROM "+table+" GROUP BY SUBSTRING_INDEX("+date+", ' ',1)";
		
		try {
		// ��¥�� �ð��� ���� �����ϱ� ������ ��¥�� �ð� �и� [ ���� ���� ]
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			map.put(rs.getString(1), rs.getInt(2) );	
		}
		return map;
		}catch(Exception e) {
			System.out.println("��ü �� ��ȯ ����!! ���:dao.SalesDao :"+e);
		}
		return null;
	}

	
	public boolean ������(int money, String date ) {
		String sql = "INSERT INTO project.sales(sale,date) VALUES (?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, date);
		
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) ���� ��� ���� !!  ���:dao.MovieDao "+ e);
		}
		return false;
	}
}
