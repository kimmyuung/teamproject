package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class SalesDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public SalesDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip�ּ�/port��ȣ
		} catch(Exception e) {System.out.println(e);}	
		}
	
public void save() {}
public void load() {}
public void saleplus() {}


	//1. ��ü �� ��ȯ
	public Map<String, Integer> bdatetotal(String table, String date) {
		try {
			Map<String, Integer> map = new HashMap<>();
		String sql = "select substring_index(" + date + " , ' ' , 1 )  , count(*) from" + table + "group by substring_index( + " + date +", ' ' , 1 )";
		// ��¥�� �ð��� ���� �����ϱ� ������ ��¥�� �ð� �и� [ ���� ���� ]
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			map.put(rs.getString(1), rs.getInt(2));
			
			return map;
		}}catch(Exception e) {}
		return null;
	}


}
