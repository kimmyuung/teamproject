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
					"root", "1234"); // jdbc:mysql:ip주소/port번호
		} catch(Exception e) {System.out.println(e);}	
		}
	
	// 티켓 내용 저장
	public boolean 티켓저장(Ticket ticket) {
		String sql = "INSERT INTO project.ticket(ticket_title,ticket_name,ticket_price,ticket_seat,ticket_viewer) VALUES (?,?,?,?,?)";
		try{
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, ticket.get영화제목());
			ps.setString(2, ticket.get관이름());
			ps.setInt(3, ticket.get가격() );
			ps.setString(4, ticket.get좌석());
			ps.setInt(5, ticket.get인원수() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			
			System.out.println("ERR)) 티켓 등록 실패 !!  경로:dao.TicketDao "+ e);
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
	
 	
	// 3. 티켓 정보 삭제 (취소시) --> 좌석 값 필요
	public boolean delete( String date ) {
		
//		LocalDateTime curDate = LocalDateTime.now();
//		
//		String reseve_time =curDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(reseve_time);
//		// DELETE FROM 테이블 WHERE 컬럼 > 49 AND 컬럼 < 1001
//		int num_reseve_time = Integer.parseInt(reseve_time);
		try {
			String sql = "delete from ticket where ticket_date  =?"; // 1. SQL 작성
			ps = conn.prepareStatement(sql); // 2. SQL 조작
			ps.setString( 1 , date);
			ps.executeUpdate(); // 3. SQL 실행 
			return true; // 4. SQL 결과
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false; 
	}
	
}