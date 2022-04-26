package controller.adminsales;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

import controller.Admin_Home;
import dao.SalesDao;
import dao.TheaterDao;
import dto.Sales;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

public class SalesCheck implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today= dateFormat.format(date);
		lbltoday.setText(today+"");
		
		//계열 생성
		XYChart.Series series = new XYChart.Series<>();
		
		series.setName("일별매출");
		
		Map<String, Integer> map= SalesDao.salesDao.bdatetotal("sales","sdate");
		
		for(String key : map.keySet()) {
			
			XYChart.Data data=new XYChart.Data<>(key,map.get(key));
			series.getData().add(data);	
			
		}
		
		chart.getData().add(series);
		
		
	}

	@FXML
    private Button btnback;

    @FXML
    private Button btnsearch;

    @FXML
    private Button btnchart;

    @FXML
    private LineChart<Date,Sales> chart;

    @FXML
    private Label lbltoday;

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/home/adminhome.fxml");
  
    }

   
}
