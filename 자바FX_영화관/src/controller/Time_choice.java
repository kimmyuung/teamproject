package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class Time_choice implements Initializable {
	
	@FXML
    private Button btnNext;

    @FXML
    void accNext(ActionEvent event) {
    	Alert alert = new Alert( AlertType.INFORMATION );  
		alert.setHeaderText("�����Ͻ� ��ȭ�� XX�� ���� ��ȭ �Դϴ�.");
		alert.showAndWait();
    	Main.main.loadpage("/jin/view/#4_�ο�����.fxml");
	    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
