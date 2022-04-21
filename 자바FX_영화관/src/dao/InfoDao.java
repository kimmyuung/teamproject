package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Info;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InfoDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static InfoDao infoDao = new InfoDao();
	
	public InfoDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println(e);}	
	}
	
	public boolean 시간등록(Info info) {
		try {
			String sql = "insert into project.info(movie,time,name)values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, info.getMovie());
			ps.setString(2, info.getTime());
			ps.setString(3, info.getName());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("시간등록 실패!! info" + e);
		}
		return false;
	}
	
	public ObservableList<Info> Infolist(){
		
		ObservableList<Info> infolist = FXCollections.observableArrayList();
		
		try {
			
			String sql = "select * from info order by num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Info info = new Info(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4));
				infolist.add(info);
			}
			return infolist;
		}catch (Exception e) {}
		return null;
		
	}
	
}









