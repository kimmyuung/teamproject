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
//	    	Seat_choice.�ѿ��=0;
	    	Main.main.loadpage("/view/#1main.fxml");
	    
	    }
	
	    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		lbltitle.setText("��ȭ���� : " +  Time.info.getMovie());
		lblname.setText("�󿵰� : " +  Time.info.getName());
		lbltime.setText("�� ���� �ð� : "  + Time.info.getTime());
		lblmember.setText("���� �ο� ��  : " +  Check_num.total_num);
		lblseat.setText("�¼� : " );
		lblprice.setText("�� ���� ��� : "+  Seat_choice.�ѿ��);
		
	}
	
	
	
}
