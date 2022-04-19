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
					"root", "1234"); // jdbc:mysql:ip�ּ�/port��ȣ
		} catch(Exception e) {System.out.println(e);}	
		}
	
	
	public boolean �󿵰����(Theater theater) {
		String sql = "INSERT INTO project.theater(tname, tseat) VALUES (?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie.get����());
			ps.setString(2, movie.get��ȭ����());
			ps.setString(3, movie.get����Ÿ��());
			ps.setString(4, movie.get���ɵ��());
			ps.setString(5, movie.get�̹���());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) ��ȭ ��� ���� !!  ���:dao.MovieDao "+ e);
		}
		return false;
	}
	
	//2.��ȭ����
	public boolean ��ȭ����(Movie movie) {
		
		String sql ="UPDATE theater set mprice =? , mptitle=? , mruntime=? , mgrade=? , mimage=? where mnum=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie.get����());
			ps.setString(2, movie.get��ȭ����());
			ps.setString(3, movie.get����Ÿ��());
			ps.setString(4, movie.get���ɵ��());
			ps.setString(5, movie.get�̹���());
			ps.setInt(6, movie.get��ȭ��ȣ());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("ERR)) ��ȭ ���� ���� !!  ���:dao.MovieDao "+ e);
		}
		return false;
	}
		
		
	}
	
	
}
