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
        	alert.setHeaderText("��ü ���� ���� ��ȭ�� �����Ͽ����ϴ�.");
        	alert.showAndWait();
//    	}else if{
//    	Alert alert2 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("12�� �̻� ���� ���� ��ȭ�� �����Ͽ����ϴ�.");
//    	}else if{
//    	Alert alert3 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("15�� �̻� ���� ���� ��ȭ�� �����Ͽ����ϴ�.");
//    	}else if{
//    	Alert alert4 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("19�� �̸��� ���� �Ұ��մϴ�.");
//    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
