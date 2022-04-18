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
			System.out.println("[ DB���� ���� ] ���: dao.MovieDao  "+e);
		}
	}
	
	//1.��ȭ���
	public boolean ��ȭ���(Movie movie) {
		String sql = "INSERT INTO project.movie(mprice,mtitle,mruntime,mgrade,mimage) value (?,?,?,?,?)";
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
	public void ��ȭ����() {}
	
	//3.��ȭ����
	public void ��ȭ����() {}
	
	//4.��ȭ ��� ��������
	public boolean ��ȭ��ϼ�������() {
		return false;
	}
}
