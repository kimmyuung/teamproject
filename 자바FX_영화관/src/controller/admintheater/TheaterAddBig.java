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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;



public class TheaterAddBig implements Initializable {

	Alert alert = new Alert(AlertType.INFORMATION);
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		seatshow();
		
	}
	
	@FXML
	private AnchorPane thpane;
	
	@FXML
    private GridPane seat;

    @FXML
    private TextField txttname;

    @FXML
    private Button btntadd;

    @FXML
    private Button btntback;
    
 

    @FXML
    void add(ActionEvent event) {
    	String tname =txttname.getText();
    	String tseat = "150";	//좌석 개수

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

    public void seatshow() {
	   	
		   GridPane gridPane = new GridPane();
	    	
	    	gridPane.setPadding(new Insets(10));
	    	
	    	gridPane.setHgap(10);
	    	gridPane.setVgap(10);
	  
	    	int i = 0;
	    	
	    	for(int row=0; row<150/15; row++) {
	    		int j=1;
	    		for(int col=0; col<15; col++) {
	    			
	    			ToggleButton button = new ToggleButton();
	    			button.setPrefWidth(40);
	    			button.setPrefHeight(40);
	    			//좌석 번호 정렬
	    			if(row==0) {button.setText("A"+j);}
	    			if(row==1) {button.setText("B"+j);}
	    			if(row==2) {button.setText("C"+j);}
	    			if(row==3) {button.setText("D"+j);}
	    			if(row==4) {button.setText("E"+j);}
	    			if(row==5) {button.setText("F"+j);}
	    			if(row==6) {button.setText("G"+j);}
	    			if(row==7) {button.setText("H"+j);}
	    			if(row==8) {button.setText("I"+j);}
	    			if(row==9) {button.setText("J"+j);}
	    			if(row==10) {button.setText("K"+j);}
	    			if(row==11) {button.setText("L"+j);}
	    			if(row==12) {button.setText("N"+j);}
	    			if(row==13) {button.setText("M"+j);}
	    			if(row==14) {button.setText("O"+j);}
	    			if(row==15) {button.setText("P"+j);}
	    			
	    			
	    			gridPane.add(button, col, row);
	    			i++;
	    			j++;
	    			
	    			
	    		
	    			
	    		}
	    	}
	    	thpane.getChildren().add(gridPane);	
	    }


}
