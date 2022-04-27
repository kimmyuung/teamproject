package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Ticket_processing implements Initializable {
	
	  	@FXML
	    private Button enter;

	    @FXML
	    private Label lbltitle;

	    @FXML
	    private Label lblname;

	    @FXML
	    private Label lbltime;

	    @FXML
	    private Label lblmember;

	    @FXML
	    private Label lblseat;

	    @FXML
	    private Label lblprice;

	   

	    @FXML
	    void accenter(ActionEvent event) {
//	    	Check_num.total_num=0;
//	    	Seat_choice.총요금=0;
	    	Main.main.loadpage("/view/#1main.fxml");
	    
	    }
	
	    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		lbltitle.setText("영화제목 : " +  Time.info.getMovie());
		lblname.setText("상영관 : " +  Time.info.getName());
		lbltime.setText("상영 시작 시간 : "  + Time.info.getTime());
		lblmember.setText("관람 인원 수  : " +  Check_num.total_num);
		lblseat.setText("좌석 : " );
		lblprice.setText("총 관람 요금 : "+  Seat_choice.총요금);
		
	}
	
	
	
}
