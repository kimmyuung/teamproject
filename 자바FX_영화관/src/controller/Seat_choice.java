package controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.admintheater.TheaterList;
import controller.admintheater.TheaterUpdate;
import dao.InfoDao;
import dao.SalesDao;
import dao.TheaterDao;
import dao.TicketDao;
import dto.Info;
import dto.Sales;
import dto.Theater;
import dto.Ticket;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Seat_choice implements Initializable{
	
	public static ArrayList<String> customer_seat = new ArrayList<>();
	public static ArrayList<Sales> total_money= new ArrayList<>();
	static String seat_name;
	static int counting;
	static int 총요금=0;
	@FXML
    private AnchorPane viewseatlist;
	
	@FXML
	    private Button btnBefore;

	    @FXML
	    private Button btnNext;
    
	    @FXML
	    void accBefore(ActionEvent event) {
	    	Check_num.성인=0;
	    	Check_num.청소년=0;
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
			총요금 = 성인요금+청소년요금;
			
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
					Ticket ticket = new Ticket(8000 , null, 1, null, null, null);
					TicketDao.ticketDao.티켓저장(ticket);
					}
				}
				LocalDateTime datetime = LocalDateTime.now();
				String parsedLocalDateTimeNow = datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				Sales sales = new Sales(총요금, parsedLocalDateTimeNow);
	    		SalesDao.salesDao.매출등록(sales.get매출(),sales.get날짜());
	    		
	    		Main.main.loadpage("/view/#6ticket.fxml");
	    		
	    		
	    		
	    	}
	    	else {
	    		Main.main.loadpage("/view/#2movie.fxml");  // 임시로 시간선택 메뉴를 초기메뉴로 설정
	    		
	    	}
	    }
	
	
	//
	    public void seatshow() {
		   		
			   GridPane gridPane = new GridPane();
			   		gridPane.setPadding(new Insets(10));
			   		gridPane.setHgap(10);
			   		gridPane.setVgap(10);
		    	
			   	int i = 0;
			   	
    			
			   	
		    	for(int row=0; row<200/20; row++) {
		    		int j=1;
		    		
		    		for(int col=0; col<20; col++) {
		    			
		    			
		    			
		    			ToggleButton button = new ToggleButton();
		    		
		    			button.setPrefWidth(50);
		    			button.setPrefHeight(50);
		    			//좌석 번호 정렬
		    			if(row==0) {button.setText("A"+j); 	button.setId("A"+j);}
		    			if(row==1) {button.setText("B"+j); 	button.setId("B"+j);}
		    			if(row==2) {button.setText("C"+j);	button.setId("C"+j);}
		    			if(row==3) {button.setText("D"+j); 	button.setId("D"+j);}
		    			if(row==4) {button.setText("E"+j); 	button.setId("E"+j);}
		    			if(row==5) {button.setText("F"+j); 	button.setId("F"+j);}
		    			if(row==6) {button.setText("G"+j); 	button.setId("G"+j);}
		    			if(row==7) {button.setText("H"+j); 	button.setId("H"+j);}
		    			if(row==8) {button.setText("I"+j); 	button.setId("I"+j);}
		    			if(row==9) {button.setText("J"+j); 	button.setId("J"+j);}
		    	
		    			gridPane.add(button, col, row);
		    			i++;
		    			j++;
		    			
		    			
		    			ArrayList<String> seats= new ArrayList<>();			
//		    			String str=TheaterDao.theaterDao.좌석호출(TheaterList.select.get관번호());
		    		
//		    			좌석호출2
//		    			for(int a=0; a<(200-Integer.parseInt(TheaterList.select.get관좌석() )); a++) {
////
//		    				String seat= str.toString().split(",")[a];
//		    				seats.add(seat);
//		    				if(button.getId().equals(seat)) {
//		    					button.setVisible(false);
//		    				
//		    				}
//		    			}
		    			
		    			//버튼 클릭시 해당 id값 안보이게 설정
//		    			button.setOnMouseClicked(e -> {
//		    				seat_name = button.getId();
//			    			 
//			    			if(button.isSelected()) {
//			    				customer_seat.add(seat_name);
//			    				
//			    				counting++;
//			    				button.setVisible(false);
//			    			    				
//			    				
//			    			}
//			    		
//		    			});	
		    			
		    		}
		    	}		    	
		    	viewseatlist.getChildren().add(gridPane);	
		    	
	     }

	    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		ArrayList<String> seats= new ArrayList<>();
		seatshow();
		
		
	}
}
