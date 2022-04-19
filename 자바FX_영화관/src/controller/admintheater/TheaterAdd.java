package controller.admintheater;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TheaterAdd implements Initializable{

	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		
			
			
			
		}
	
	
		@FXML
	    private TextField txttname;

	    @FXML
	    private RadioButton small;

	    @FXML
	    private ToggleGroup tsize;

	    @FXML
	    private RadioButton mid;

	    @FXML
	    private RadioButton big;

	    @FXML
	    private Button btntadd;

	    @FXML
	    private Button btntback;

	    @FXML
	    void add(ActionEvent event) {

	    }

	    @FXML
	    void back(ActionEvent event) {
	    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
	    }
	
	
	

}
