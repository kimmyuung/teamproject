package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dto.Movie;
import dto.Theater;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TheaterDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static TheaterDao theaterDao = new TheaterDao();
	
	public TheaterDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip�ּ�/port��ȣ
		} catch(Exception e) {System.out.println( "DB��������! ���:dao.TheaterDao " + e);}	
		}
	
	//1. �󿵰� ȣ��
	public boolean �󿵰����(Theater theater) {
		String sql = "INSERT INTO project.theater(tname, tseat) VALUES (?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, theater.get���̸�());
			ps.setString(2, theater.get���¼�());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) �󿵰� ��� ���� !!  ���:dao.TheaterDao "+ e);
		}
		return false;
	}
	
	//2.�󿵰�����
	public boolean �󿵰�����(Theater theater) {
		
		String sql ="UPDATE theater set tname =? , tseat=?  WHERE tnum=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,theater.get���̸�());
			ps.setString(2, theater.get���¼�());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("ERR)) �󿵰� ���� ���� !!  ���:dao.MovieDao "+ e);
		}
		return false;
	}
	
	//3.�󿵰�����Ʈ ȣ��
	public ObservableList<Theater> list() {
		ObservableList<Theater> theaterlist = FXCollections.observableArrayList();
		try {
			String sql = "SELECT * FROM project.theater ORDER BY tnum DESC";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Theater theater = new Theater(rs.getInt(1) ,rs.getString(2),rs.getString(3));
				theaterlist.add(theater);
			}
			return theaterlist;
		} catch (Exception e) {
			System.out.println("ERR)) �󿵰� ����Ʈ ȣ�� ���� !!  ���:dao.MovieDao "+ e);
		}
		return null;
	}
		
	
	
}
