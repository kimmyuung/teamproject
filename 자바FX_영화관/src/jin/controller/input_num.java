package jin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;


public class input_num implements Initializable {
	
    @FXML
    private TextField txt_input_number;

    @FXML
    private Button btnOK;

    @FXML
    void accOK(ActionEvent event) {
    	Check_num.input_value = 0;
    	String Input_value = txt_input_number.getText();
    	int value = Integer.parseInt(Input_value);
    	Check_num.input_value = value;    	
    	
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 
		
	}
	
}
