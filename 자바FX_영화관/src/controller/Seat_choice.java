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
			alert.setHeaderText("�ο� ���� �޴��� ���ư��ϴ�.");
			alert.showAndWait();
			Main.main.loadpage("/view/#4people.fxml");
	    }

	    @FXML
	    void accNext(ActionEvent event) {
	    	
	    	
//			alert.showAndWait();
			int ���ο�� =Check_num.����*10000;
			int û�ҳ��� =Check_num.û�ҳ�*8000;
			int �ѿ��= ���ο��+û�ҳ���;
			
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
				    		// �޽���
				    		Alert alert_ticket = new Alert( AlertType.INFORMATION );
				    		alert_ticket.setHeaderText(" �ο� ������ �Ϸ� �Ǿ����ϴ�.");
				    		alert_ticket.showAndWait();
				    		// ������ ��ȯ
				    		
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
					Ticket ticket = new Ticket(8000, null, 1, null, null, null);
					TicketDao.ticketDao.Ƽ������(ticket);
					}
				}
	    		
	    		
	    		Main.main.loadpage("/view/#6ticket.fxml");
	    		
	    		
	    		
	    	}
	    	else {
	    		Main.main.loadpage("/view/#2movie.fxml");  // �ӽ÷� �ð����� �޴��� �ʱ�޴��� ����
	    		
	    	}
	    }
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		
		
		
	}
}
