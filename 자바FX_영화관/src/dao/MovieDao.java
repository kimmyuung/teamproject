package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Movie;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MovieDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	
	public static MovieDao movieDao = new MovieDao();
	
	public MovieDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3307/project?serverTimezone=UTC","root","1234");
		} catch (Exception e) {
			System.out.println("[ DB연동 실패 ] 경로: dao.MovieDao  "+e);
		}
	}
	
	//1.영화등록
	public boolean 영화등록(Movie movie) {
		String sql = "INSERT INTO project.movie(mprice,mtitle,mruntime,mgrade,mimage) value (?,?,?,?,?)";
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
	public void 영화수정() {}
	
	//3.영화삭제
	public void 영화삭제() {}
	
	//4.영화 등록 성공여부
	public boolean 영화등록성공여부() {
		return false;
	}
}
