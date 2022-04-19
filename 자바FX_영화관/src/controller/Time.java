package controller;

import java.net.URL;
import java.util.ResourceBundle;

import controller.adminmovie.MovieAdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class Time implements Initializable {

	@FXML
    private Button btnback2;

    @FXML
    private Button btnnext2;

    @FXML
    void accback2(ActionEvent event) {
    	Main.main.loadpage("/view/#2movie.fxml");
    }

    @FXML
    void accnext2(ActionEvent event) {
    	
    	
    	
//    	if{
    	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setHeaderText("전체 관람 가능 영화를 선택하였습니다.");
        	alert.showAndWait();
//    	}else if{
//    	Alert alert2 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("12세 이상 관람 가능 영화를 선택하였습니다.");
//    	}else if{
//    	Alert alert3 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("15세 이상 관람 가능 영화를 선택하였습니다.");
//    	}else if{
//    	Alert alert4 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("19세 미만은 상영이 불가합니다.");
//    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
