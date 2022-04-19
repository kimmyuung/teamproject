package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public MovieDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip�ּ�/port��ȣ
		} catch(Exception e) {System.out.println(e);}	
		}
	
	
	//1.��ȭ���
	public boolean ��ȭ���(Movie movie) {
		String sql = "INSERT INTO project.movie(mprice,mtitle,mruntime,mgrade,mimage) VALUES (?,?,?,?,?)";
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
		
		String sql ="UPDATE movie set mprice =? , mptitle=? , mruntime=? , mgrade=? , mimage=? where mnum=?";
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
	
	//3.��ȭ����
	public boolean ��ȭ����(int mnum) {
		String sql = "delete from project.movie where mnum =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("��ȭ ���� ����! " + e);}
		return false;
	}
	
	//4. ��ȭ����Ʈ ȣ��
	public ObservableList<Movie> list() {
		ObservableList<Movie> movielist = FXCollections.observableArrayList();
		try {
			String sql = "select * from teamproject.movie order by mnum asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
				movielist.add(movie);
			}
			return movielist;
		}
		catch(Exception e) {System.out.println("ȣ�� ����!" + e);}
	return null;
	}
}
