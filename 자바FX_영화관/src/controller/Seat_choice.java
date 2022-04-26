package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.admintheater.TheaterList;
import controller.admintheater.TheaterUpdate;
import dao.TheaterDao;
import dao.TicketDao;
import dto.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;

public class Seat_choice implements Initializable{
	
	 @FXML
	    private Button btnBefore;

	    @FXML
	    private Button btnNext;

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @FXML
	    void accBefore(ActionEvent event) {
	    	
	    	Alert alert = new Alert( AlertType.INFORMATION );  
			alert.setHeaderText("인원 선택 메뉴로 돌아갑니다.");
			alert.showAndWait();
			Main.main.loadpage("/view/#4people.fxml");
	    }

	    @FXML
	    void accNext(ActionEvent event) {
	    	
	    	
//			alert.showAndWait();
			int 성인요금 =Check_num.성인*10000;
			int 청소년요금 =Check_num.청소년*8000;
			int 총요금= 성인요금+청소년요금;
			
			Alert alert = new Alert( AlertType.CONFIRMATION );  
			alert.setHeaderText("선택하신 영화의 관람료는" + 총요금 + "원 입니다.");
			
			
			Optional<ButtonType> optional = alert.showAndWait();
	    	if(optional.get()== ButtonType.OK) {
	    		int i = 0; int j= 0;
				
				
	    		if (Check_num.성인!=0) {
					for( i=1;i<=Check_num.성인;i++) {
						
						
						Ticket ticket = new Ticket(10000, null, 1, null, null, null);
						boolean result = TicketDao.ticketDao.티켓저장(ticket);
						if( result ) {
				    		// 메시지
				    		Alert alert_ticket = new Alert( AlertType.INFORMATION );
				    		alert_ticket.setHeaderText(" 인원 선택이 완료 되었습니다.");
				    		alert_ticket.showAndWait();
				    		// 페이지 전환
				    		
				    	}else {
				    		// 메시지
				    		Alert alert_ticket = new Alert( AlertType.INFORMATION );
				    			alert.setHeaderText(" 발급 실패[관리자에게문의]");
				    		alert.showAndWait();
				    	}
					}
				}
	    		
				if(Check_num.청소년!=0) {
					for(j=1;j<=Check_num.청소년;j++) {
					Ticket ticket = new Ticket(8000, null, 1, null, null, null);
					TicketDao.ticketDao.티켓저장(ticket);
					}
				}
	    		
	    		
	    		Main.main.loadpage("/view/#6ticket.fxml");
	    		
	    		
	    		
	    	}
	    	else {
	    		Main.main.loadpage("/view/#2movie.fxml");  // 임시로 시간선택 메뉴를 초기메뉴로 설정
	    		
	    	}
	    }
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		
		
		
	}
}
