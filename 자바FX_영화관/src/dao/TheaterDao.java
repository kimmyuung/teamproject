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
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println( "DB연동실패! 경로:dao.TheaterDao " + e);}	
		}
	
	//1. 상영관 호출
	public boolean 상영관등록(Theater theater) {
		String sql = "INSERT INTO project.theater(tname, tseat, txy) VALUES (?,?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, theater.get관이름());
			ps.setString(2, theater.get관좌석());
			ps.setString(3, theater.get관좌표());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) 상영관 등록 실패 !!  경로:dao.TheaterDao "+ e);
		}
		return false;
	}
	
	//2.상영관수정
	public boolean 상영관수정(Theater theater) {
		
		String sql ="UPDATE theater set tname =? , tseat=? txy=?  WHERE tnum=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,theater.get관이름());
			ps.setString(2, theater.get관좌석());
			ps.setString(3, theater.get관좌표());
			ps.setInt(4, theater.get관번호());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("ERR)) 상영관 수정 실패 !!  경로:dao.MovieDao "+ e);
		}
		return false;
	}
	
	//3.상영관리스트 호출
	public ObservableList<Theater> list() {
		ObservableList<Theater> theaterlist = FXCollections.observableArrayList();
		try {
			String sql = "SELECT * FROM project.theater ORDER BY tnum DESC";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Theater theater = new Theater(rs.getInt(1) ,rs.getString(2),rs.getString(3) , rs.getString(4));
				theaterlist.add(theater);
			}
			return theaterlist;
		} catch (Exception e) {
			System.out.println("ERR)) 상영관 리스트 호출 실패 !!  경로:dao.MovieDao "+ e);
		}
		return null;
	}
		
	//4.상영관 삭제
	
	public boolean 상영관삭제(int tnum) {
		String sql = "delete from project.theater where tnum =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("상영관 삭제 실패!  경로:dao.TheaterDao  " + e);}
		return false;
	}
	
	//5. 좌석리스트 호출
	public String 좌석호출(int tnum) {
		String str = "";
		try {
			String sql = "SELECT txy FROM project.theater where tnum=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tnum);
			rs = ps.executeQuery();
			while(rs.next()) {
				str += rs.getString(1) + ",";
			}
			return str;
		}catch(Exception e) { System.out.println("상영관 좌석 리스트 호출" + e);}
		return null;
	}
}
