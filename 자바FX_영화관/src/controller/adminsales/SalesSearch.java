package controller.adminsales;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class SalesSearch implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	 @FXML
	 private TextField txtsearch;

	 @FXML
	 private Button btnback;

	 @FXML
	 private BarChart<?, ?> chart1;

	 @FXML
	 private PieChart chart2;



    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/sales/salescheck.fxml");
    }

    @FXML
    void search(ActionEvent event) {

    }
	
	
}
