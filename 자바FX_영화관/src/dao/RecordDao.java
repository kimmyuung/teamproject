package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RecordDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public RecordDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip�ּ�/port��ȣ
		} catch(Exception e) {System.out.println(e);}	
		}
	
	public boolean �󿵿�ȭ���(dto.Record record) {
		String sql = "INSERT INTO project.runmovie(mtitle, runtime, tname) VALUES (?,?,?)";
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1, record.get�󿵿�ȭ());
			ps.setString(2, record.get�󿵽ð�());
			ps.setString(3, record.get���̸�());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("ERR)) �󿵿�ȭ ��� ���� !!  ���:dao.RecordDao "+ e);
		}
		return false;
	}
	public void �󿵿�ȭȣ��() {
		
	}
}
