package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class Ticket_processing implements Initializable {
	
	
    @FXML
    private Button enter;

   

    

    @FXML
    void accenter(ActionEvent event) {
    	Main.main.loadpage("/view/#1main.fxml");
    
    }
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
