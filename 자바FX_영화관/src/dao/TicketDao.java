package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controller.Check_num;
import dto.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TicketDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public static TicketDao ticketDao = new TicketDao();
	
	public TicketDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=Asia/Seoul ",
					"root", "1234"); // jdbc:mysql:ip�ּ�/port��ȣ
		} catch(Exception e) {System.out.println(e);}	
		}
	
	// Ƽ�� ���� ����
	public boolean Ƽ������(Ticket ticket) {
		String sql = "INSERT INTO project.ticket(ticket_title,ticket_name,ticket_price,ticket_seat,ticket_viewer) VALUES (?,?,?,?,?)";
		try{
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, ticket.get��ȭ����());
			ps.setString(2, ticket.get���̸�());
			ps.setInt(3, ticket.get����() );
			ps.setString(4, ticket.get�¼�());
			ps.setInt(5, ticket.get�ο���() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) Ƽ�� ��� ���� !!  ���:dao.TicketDao "+ e);
		}
		return false;
	}
	
	/*
	 * 
	 * ticket_Num int PK 
ticket_title varchar(1000) 
ticket_name varchar(1000) 
ticket_price int 
ticket_seat varchar(1000) 
ticket_date varchar(1000)
	 * 
	 */
	
	
	// Ƽ�� ���� ȣ��
	public ObservableList<Ticket> list() {
		ObservableList<Ticket> ticketlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from project.ticket order by ticket_Num asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Ticket ticket = new Ticket(rs.getInt(1),rs.getString(2),0,rs.getString(4),rs.getString(5),rs.getString(6));
				ticketlist.add(ticket);
			}
			return ticketlist;
		}
		catch(Exception e) {System.out.println("ȣ�� ����!" + e);}
	return null;
	}
	
 	
	// 3. Ƽ�� ���� ���� (��ҽ�) --> �¼� �� �ʿ�
	public boolean delete( String date ) {
		
//		LocalDateTime curDate = LocalDateTime.now();
//		
//		String reseve_time =curDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(reseve_time);
//		// DELETE FROM ���̺� WHERE �÷� > 49 AND �÷� < 1001
//		int num_reseve_time = Integer.parseInt(reseve_time);
		try {
			String sql = "delete from ticket where ticket_date  =?"; // 1. SQL �ۼ�
			ps = conn.prepareStatement(sql); // 2. SQL ����
			ps.setString( 1 , date);
			ps.executeUpdate(); // 3. SQL ���� 
			return true; // 4. SQL ���
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
		return false; 
	}
	
}