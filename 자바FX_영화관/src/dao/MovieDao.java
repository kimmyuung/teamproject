package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	//영화 등록 성공여부
	public boolean 영화등록성공여부() {
		return false;
	}
	//1.영화등록
	public void 영화등록() {}
	//2.영화수정
	public void 영화수정() {}
	//3.영화삭제
	public void 영화삭제() {}
}
