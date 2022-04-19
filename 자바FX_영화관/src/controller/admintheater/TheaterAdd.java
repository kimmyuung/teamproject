package controller.admintheater;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import dao.TheaterDao;
import dto.Theater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class TheaterAdd implements Initializable{

	
		Alert alert = new Alert(AlertType.INFORMATION);
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		
			
			
			
		}
		
		@FXML
		private VBox vbox;
		
		@FXML
		private GridPane seat;
		
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
	    	String tname =txttname.getText();
	    	String tcategory=null;
	    	
	    	if(small.isSelected()) {
	    		tcategory="����";
	    	}
	     	if(mid.isSelected()) {
	    		tcategory="����";
	    	}
	     	if(big.isSelected()) {
	    		tcategory="����";
	    	}
	     	
	     	Theater theater = new Theater(0, tname, tcategory);
	     	
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
	
	    
	    static void seatshow(Theater theater) {
	    

	    }
}
