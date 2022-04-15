package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Movie;

public class MovieDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static MovieDao productDao = new MovieDao();
	
	public MovieDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		} catch (Exception e) {
			System.out.println("[DB연동 실패 ] 위치: dao.MovieDao  "+e);
		}
	}
	
	//1.영화등록
	public boolean 영화등록(Movie movie) {
		String sql = "INSERT INTO movie(가격,영화제목,런닝타임) VALUS (?,?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie.get가격());
			ps.setString(2, movie.get영화제목());
			ps.setString(3, movie.get연령등급());
			ps.executeQuery();
			return true;
		}catch (Exception e) {
			System.out.println("ERR)) 영화 등록 실패 !!  경로:dao.MovieDao "+ e);
		}
		return false;
	}
	
	//2.영화수정
	public void 영화수정() {}
	
	//3.영화삭제
	public void 영화삭제() {}
	
	//4.영화 등록 성공여부
	public boolean 영화등록성공여부() {
		return false;
	}
}
