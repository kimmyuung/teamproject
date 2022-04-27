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
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println("DB연동 실패 !! 경로:dao.SalesDao :  "+e);}	
		}
	

	//1. 전체 수 반환
	public Map<String, Integer> bdatetotal(String table, String date) {
		
		Map<String, Integer> map = new TreeMap<>();
		String sql = "SELECT SUBSTRING_INDEX("+date+", ' ' , 1), SUM(sales) FROM "+table+" GROUP BY SUBSTRING_INDEX("+date+", ' ',1)";
		
		try {
		// 날짜랑 시간이 같이 존재하기 때문에 날짜랑 시간 분리 [ 공백 기준 ]
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			map.put(rs.getString(1), rs.getInt(2) );	
		}
		return map;
		}catch(Exception e) {
			System.out.println("전체 수 반환 실패!! 경로:dao.SalesDao :"+e);
		}
		return null;
	}

	
	public boolean 매출등록(int money, String date ) {
		String sql = "INSERT INTO project.sales(sale,date) VALUES (?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, date);
		
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) 매출 등록 실패 !!  경로:dao.MovieDao "+ e);
		}
		return false;
	}
}
