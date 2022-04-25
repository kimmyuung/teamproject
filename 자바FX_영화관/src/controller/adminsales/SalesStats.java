package controller.adminsales;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

public class SalesStats implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    private Button btnback;

    @FXML
    private ToggleGroup ymd;

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/sales/salescheck.fxml");
    }
    
}
