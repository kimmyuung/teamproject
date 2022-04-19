package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.adminmovie.MovieList;
import dto.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MovieDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	
	public static MovieDao movieDao = new MovieDao();
	// 0. db와의 연동 메소드
	public MovieDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println(e);}	
		}
	
	
	//1.영화등록
	public boolean 영화등록(Movie movie) {
		String sql = "INSERT INTO project.movie(mprice,mtitle,mruntime,mgrade,mimage) VALUES (?,?,?,?,?)";
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
		
		String sql ="UPDATE movie set mprice =? , mptitle=? , mruntime=? , mgrade=? , mimage=? where mnum=?";
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
	
	//3.영화삭제
	public boolean 영화삭제(int mnum) {
		String sql = "delete from project.movie where mnum =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("영화 삭제 실패!  경로:dao.MovieDao  " + e);}
		return false;
	}
	
	//4. 영화리스트 호출
	public ObservableList<Movie> list() {
		ObservableList<Movie> movielist = FXCollections.observableArrayList();
		try {
			String sql = "select * from project.movie order by mnum asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
				movielist.add(movie);
			}
			return movielist;
		}
		catch(Exception e) {System.out.println("리스트 호출 실패!  경로:dao.MovieDao  " + e);}
	return null;
	}
	
	// 5. 영화이름 중복 체크
	public boolean mtitlecheck(String mtitle) {
		try {
		// 1. SQL 작성
			// 검색 : select * from 테이블명 where 조건
		String sql = "select * from project.movie where mtitle = ?";
		// 2. SQL 조작
		ps = conn.prepareStatement(sql);
		ps.setString(1, mtitle);
		// 3. SQL 실행
		rs = ps.executeQuery(); // select 실행 -> 검색은 결과물 존재 -> resultset 0
		// resultSet 처음 기본 값은 : null -> next() -> 결과 레코드
		// 4. SQL 결과
		if(rs.next()) return true;
		
		} catch(Exception e) {}
		return false;
	}
}