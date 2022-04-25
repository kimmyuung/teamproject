package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.admintheater.TheaterList;
import controller.admintheater.TheaterUpdate;
import dao.TheaterDao;
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
	    	Alert alert = new Alert( AlertType.CONFIRMATION );  
			alert.setHeaderText("�����Ͻ� ��ȭ�� ������� XX�� �Դϴ�..");
//			alert.showAndWait();
			
			Optional<ButtonType> optional = alert.showAndWait();
	    	if(optional.get()== ButtonType.OK) {
	    		
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
