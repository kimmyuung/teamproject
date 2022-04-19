package jin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class Check_num implements Initializable{
	
	@FXML
	private BorderPane borderPane;
	
	@FXML
    private Button btnNext;

   
	@FXML
    private Button btnBefore;


   
 
    @FXML
    void accBefore(ActionEvent event) {
    	Alert alert = new Alert( AlertType.INFORMATION );  
		alert.setHeaderText("시간 선택 메뉴로 돌아갑니다.");
		alert.showAndWait();
    	Main.instance.loadpage("/jin/view/#2_시간선택.fxml");
    }

	@FXML
    void accNext(ActionEvent event) {
		Alert alert = new Alert( AlertType.INFORMATION );  
		
		alert.setHeaderText("좌석 선택 메뉴로 이동합니다.");
		alert.showAndWait();
    	Main.instance.loadpage("/jin/view/#5_좌석선택.fxml");
    }


	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}

}
