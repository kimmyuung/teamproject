package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dto.Movie;
import dto.Theater;

public class TheaterDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public TheaterDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println( "DB연동실패! 경로:dao.TheaterDao " + e);}	
		}
	
	
	public boolean 상영관등록(Theater theater) {
		String sql = "INSERT INTO project.theater(tname, tseat) VALUES (?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, theater.get관이름());
			ps.setString(2, theater.get관좌석());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) 상영관 등록 실패 !!  경로:dao.TheaterDao "+ e);
		}
		return false;
	}
	
	//2.영화수정
	public boolean 상영관수정(Theater theater) {
		
		String sql ="UPDATE theater set tname =? , tseat=?  WHERE tnum=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,theater.get관이름());
			ps.setString(2, theater.get관좌석());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("ERR)) 상영관 수정 실패 !!  경로:dao.MovieDao "+ e);
		}
		return false;
	}
		
		
	
	
}
