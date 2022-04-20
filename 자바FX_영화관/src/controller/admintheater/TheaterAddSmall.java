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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class TheaterAddSmall implements Initializable{

	
		Alert alert = new Alert(AlertType.INFORMATION);
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		
			
			
			
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
	    void add(ActionEvent event) {
	    	String tname =txttname.getText();
	    	String tseat = "50";	//좌석 개수

	     	Theater theater = new Theater(0, tname, tseat);
	     	
	     	boolean result=TheaterDao.theaterDao.상영관등록(theater);
	     	
	     	if(result ) {
	     		alert.setHeaderText("상영관 등록 성공 !!");
    			alert.showAndWait();
	     	}else {
	     		alert.setHeaderText("상영관 등록 실패 !!");
				alert.showAndWait();
	     	}
	    }

	    @FXML
	    void back(ActionEvent event) {
	    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
	    }
	
	    
	    void seatshow () {
	    	
	    	GridPane gridPane = new GridPane();
	    	
	    	gridPane.setPadding(new Insets(10));
	    	
	    	gridPane.setHgap(5);
	    	gridPane.setVgap(5);
	    	
	    	int i = 0;
	    	for(int row=0; row<50/5; row++) {
	    		for(int col=0; col<5; col++) {
	    			
	    			ToggleButton button = new ToggleButton();	    			
	    			
	    			gridPane.add(button, col, row);
	    			i++;
	    		}
	    	}
	    vbox.getChildren().add(gridPane);	
	    	
	    }
	
	    
	
	    
}
