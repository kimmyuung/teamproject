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
	static int �ѿ��=0;
	@FXML
    private AnchorPane viewseatlist;
	
	@FXML
	    private Button btnBefore;

	    @FXML
	    private Button btnNext;
    
	    @FXML
	    void accBefore(ActionEvent event) {
	    	Check_num.����=0;
	    	Check_num.û�ҳ�=0;
	    	Alert alert = new Alert( AlertType.INFORMATION );  
			alert.setHeaderText("�ο� ���� �޴��� ���ư��ϴ�.");
			alert.showAndWait();
			Main.main.loadpage("/view/#4people.fxml");
	    }

	    @FXML
	    void accNext(ActionEvent event) {
	    	
	    	
//			alert.showAndWait();
			int ���ο�� =Check_num.����*10000;
			int û�ҳ��� =Check_num.û�ҳ�*8000;
			�ѿ�� = ���ο��+û�ҳ���;
			
			Alert alert = new Alert( AlertType.CONFIRMATION );  
			alert.setHeaderText("�����Ͻ� ��ȭ�� �������" + �ѿ�� + "�� �Դϴ�.");
			
			
			Optional<ButtonType> optional = alert.showAndWait();
	    	if(optional.get()== ButtonType.OK) {
	    		int i = 0; int j= 0;
				
				
	    		if (Check_num.����!=0) {
					for( i=1;i<=Check_num.����;i++) {
						
						
						Ticket ticket = new Ticket(10000, null, 1, null, null, null);
						boolean result = TicketDao.ticketDao.Ƽ������(ticket);
						if( result ) {
				    						    		
				    	}else {
				    		// �޽���
				    		Alert alert_ticket = new Alert( AlertType.INFORMATION );
				    			alert.setHeaderText(" �߱� ����[�����ڿ��Թ���]");
				    		alert.showAndWait();
				    	}
					}
				}
	    		
				if(Check_num.û�ҳ�!=0) {
					for(j=1;j<=Check_num.û�ҳ�;j++) {
					Ticket ticket = new Ticket(8000 , null, 1, null, null, null);
					TicketDao.ticketDao.Ƽ������(ticket);
					}
				}
				LocalDateTime datetime = LocalDateTime.now();
				String parsedLocalDateTimeNow = datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				Sales sales = new Sales(�ѿ��, parsedLocalDateTimeNow);
	    		SalesDao.salesDao.������(sales.get����(),sales.get��¥());
	    		
	    		Main.main.loadpage("/view/#6ticket.fxml");
	    		
	    		
	    		
	    	}
	    	else {
	    		Main.main.loadpage("/view/#2movie.fxml");  // �ӽ÷� �ð����� �޴��� �ʱ�޴��� ����
	    		
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
		    			//�¼� ��ȣ ����
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
//		    			String str=TheaterDao.theaterDao.�¼�ȣ��(TheaterList.select.get����ȣ());
		    		
//		    			�¼�ȣ��2
//		    			for(int a=0; a<(200-Integer.parseInt(TheaterList.select.get���¼�() )); a++) {
////
//		    				String seat= str.toString().split(",")[a];
//		    				seats.add(seat);
//		    				if(button.getId().equals(seat)) {
//		    					button.setVisible(false);
//		    				
//		    				}
//		    			}
		    			
		    			//��ư Ŭ���� �ش� id�� �Ⱥ��̰� ����
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
