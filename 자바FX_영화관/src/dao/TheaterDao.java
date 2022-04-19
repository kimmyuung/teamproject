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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println(e);}	
		}
	
	
	public boolean 상영관등록(Theater theater) {
		String sql = "INSERT INTO project.theater(tname, tseat) VALUES (?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie.get가격());
			ps.setString(2, movie.get영화제목());
			ps.setString(3, movie.get러닝타임());
			ps.setString(4, movie.get연령등급());
			ps.setString(5, movie.get이미지());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) 영화 등록 실패 !!  경로:dao.MovieDao "+ e);
		}
		return false;
	}
	
	//2.영화수정
	public boolean 영화수정(Movie movie) {
		
		String sql ="UPDATE theater set mprice =? , mptitle=? , mruntime=? , mgrade=? , mimage=? where mnum=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie.get가격());
			ps.setString(2, movie.get영화제목());
			ps.setString(3, movie.get러닝타임());
			ps.setString(4, movie.get연령등급());
			ps.setString(5, movie.get이미지());
			ps.setInt(6, movie.get영화번호());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("ERR)) 영화 수정 실패 !!  경로:dao.MovieDao "+ e);
		}
		return false;
	}
		
		
	}
	
	
}
