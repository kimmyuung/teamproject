package controller.adminsales;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import controller.Admin_Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SalesCheck implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today= dateFormat.format(date);
		
		lbltoday.setText(today+"");
	}

	@FXML
    private Button btnback;

    @FXML
    private Button btnsearch;

    @FXML
    private Button btnchart;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private Label lbltoday;

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/home/adminhome.fxml");
    }

    @FXML
    void chart(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/sales/salesstats.fxml");
    }

    @FXML
    void search(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/sales/salessearch.fxml");
    }	
	
	
}
