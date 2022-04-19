package jin.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
			Main.instance.loadpage("/jin/view/#4_�ο�����.fxml");
	    }

	    @FXML
	    void accNext(ActionEvent event) {
	    	Alert alert = new Alert( AlertType.CONFIRMATION );  
			alert.setHeaderText("�����Ͻ� ��ȭ�� ������� XX�� �Դϴ�..");
//			alert.showAndWait();
			
			Optional<ButtonType> optional = alert.showAndWait();
	    	if(optional.get()== ButtonType.OK) {
	    		
	    		Main.instance.loadpage("/jin/view/#6_��ȭǥ.fxml");
	    	}
	    	else {
	    		Main.instance.loadpage("/jin/view/#2_�ð�����.fxml");  // �ӽ÷� �ð����� �޴��� �ʱ�޴��� ����
	    		
	    	}
	    }
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
}
