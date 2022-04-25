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
		alert.setHeaderText("선택하신 영화는 XX세 관람 영화 입니다.");
		alert.showAndWait();
    	Main.main.loadpage("/jin/view/#4_인원선택.fxml");
	    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
