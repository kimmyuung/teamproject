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
			System.out.println("[DB���� ���� ] ��ġ: dao.MovieDao  "+e);
		}
	}
	//��ȭ ��� ��������
	public boolean ��ȭ��ϼ�������() {
		return false;
	}
	//1.��ȭ���
	public void ��ȭ���() {}
	//2.��ȭ����
	public void ��ȭ����() {}
	//3.��ȭ����
	public void ��ȭ����() {}
}
