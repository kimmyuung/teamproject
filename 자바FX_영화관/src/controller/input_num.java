package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class input_num implements Initializable {
	
    @FXML
    private TextField txt_input_number;

    @FXML
    private Button btnOK;
    
   
    private void closeButtonAction(){
      // get a handle to the stage
      Stage stage = (Stage) btnOK.getScene().getWindow();
      // do what you have to do
      stage.close();
    }
    
    @FXML
    void accOK(ActionEvent event) {
    	if(Check_num.button==1) {
    	String Input_value = txt_input_number.getText();
    	Check_num.己牢 = Integer.parseInt(Input_value);
    	closeButtonAction();
    	System.out.println(Check_num.己牢); 
    	}
    	else if(Check_num.button==2) {
        	String Input_value = txt_input_number.getText();
        	Check_num.没家斥 = Integer.parseInt(Input_value);
        	closeButtonAction();
        	System.out.println(Check_num.没家斥); 
    	}
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 
		
	}
	
}
