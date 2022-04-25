package controller.admintheater;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import dao.TheaterDao;
import dto.Theater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TheaterUpdate implements Initializable {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    private TextField txttname;

    @FXML
    private Button btntupdate;

    @FXML
    private Button btntback;

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
    }
    
    @FXML
    void update(ActionEvent event) {
    	String tname=  txttname.getText();
    	
	   	Theater updatetheater = TheaterAdd.theater;
	     
	   	boolean result = TheaterDao.theaterDao.�󿵰�����(updatetheater);
	   	
	   	if(result) {
	   		alert.setHeaderText("�󿵰� ���� ���� !!");
			alert.showAndWait();
	   		
	   	}else {
	   		alert.setHeaderText("�󿵰� ��� ���� !!");
			alert.showAndWait();
	   	}
    
    }
    }

  



