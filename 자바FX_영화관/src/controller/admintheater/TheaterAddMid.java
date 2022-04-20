package controller.admintheater;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import dao.TheaterDao;
import dto.Theater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TheaterAddMid implements Initializable {

	Alert alert = new Alert(AlertType.INFORMATION);
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	 	@FXML
	    private GridPane seat;

	    @FXML
	    private VBox vbox;

	    @FXML
	    private TextField txttname;

	    @FXML
	    private Button btntadd;

	    @FXML
	    private Button btntback;

	    @FXML
	    void add(ActionEvent event) {
	    	String tname =txttname.getText();
	    	String tseat = "100"; //�¼� ����

	     	Theater theater = new Theater(0, tname, tseat); 
	     	
	     	boolean result=TheaterDao.theaterDao.�󿵰����(theater);
	     	
	     	if(result ) {
	     		alert.setHeaderText("�󿵰� ��� ���� !!");
    			alert.showAndWait();
	     	}else {
	     		alert.setHeaderText("�󿵰� ��� ���� !!");
				alert.showAndWait();
	     	}
	    }

	    @FXML
	    void back(ActionEvent event) {
	    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
	    	
	    	
	    }
}
