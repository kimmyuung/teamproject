package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println(e);}	
		}
	
	// 티켓 내용 저장
	public boolean 티켓저장(Ticket ticket) {
		String sql = "INSERT INTO project.ticket(ticket_title,ticket_name,ticket_price,ticket_seat,ticket_date) VALUES (?,?,?,?,?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ticket.get가격() );
//			ps.setString(2, ticket.get영화제목());
//			ps.setString(3, ticket.get관이름());
//			ps.setString(4, ticket.get좌석());
//			ps.setString(5, ticket.get날짜());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) 티켓 등록 실패 !!  경로:dao.TicketDao "+ e);
		}
		return false;
	}
	
	// 티켓 정보 호출
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
		catch(Exception e) {System.out.println("호출 실패!" + e);}
	return null;
	}
	
	
	
	
}