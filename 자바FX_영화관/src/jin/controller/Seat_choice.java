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
			alert.setHeaderText("인원 선택 메뉴로 돌아갑니다.");
			alert.showAndWait();
			Main.instance.loadpage("/jin/view/#4_인원선택.fxml");
	    }

	    @FXML
	    void accNext(ActionEvent event) {
	    	Alert alert = new Alert( AlertType.CONFIRMATION );  
			alert.setHeaderText("선택하신 영화의 관람료는 XX원 입니다..");
//			alert.showAndWait();
			
			Optional<ButtonType> optional = alert.showAndWait();
	    	if(optional.get()== ButtonType.OK) {
	    		
	    		Main.instance.loadpage("/jin/view/#6_영화표.fxml");
	    	}
	    	else {
	    		Main.instance.loadpage("/jin/view/#2_시간선택.fxml");  // 임시로 시간선택 메뉴를 초기메뉴로 설정
	    		
	    	}
	    }
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
}
