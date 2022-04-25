package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Runmovie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RecordDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public RecordDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println(e);}	
		}
	
	public boolean 상영영화등록(dto.Runmovie record) {
		String sql = "INSERT INTO project.runmovie(mtitle, runtime, tname) VALUES (?,?,?)";
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1, record.get상영영화());
			ps.setString(2, record.get상영시간());
			ps.setString(3, record.get관이름());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("ERR)) 상영영화 등록 실패 !!  경로:dao.RecordDao "+ e);
		}
		return false;
	}
	public ObservableList<Runmovie> list() {
		ObservableList<Runmovie> recordlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from project.runmovie";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Runmovie record1 = new Runmovie(rs.getString(1), rs.getString(2), rs.getString(3)); 
				recordlist.add(record1);
			}
			return recordlist;
		}
		catch(Exception e) {System.out.println("리스트 호출 실패!  경로:dao.MovieDao  " + e);}
	return null;
	}
}
