package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Movie implements Initializable {

    @FXML
    private Button btnnext;

    @FXML
    void accnext(ActionEvent event) {
    	Main.main.loadpage("/view/#3time.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	void show(String serch) {
		
	}
}
