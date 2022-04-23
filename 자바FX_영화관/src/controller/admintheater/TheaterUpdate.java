package controller.admintheater;

import java.net.URL;
import java.util.ArrayList;
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

public class TheaterUpdate implements Initializable {
	
		static String x;
	    
		private static int count;
	    
		static ArrayList<String> cn = new ArrayList<>();
	    
		Alert alert = new Alert(AlertType.INFORMATION);
	
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			Theater theater = TheaterList.select;
			txttname.setText(TheaterList.select.get관이름());
			updateseatshow();
		}
		
		@FXML
	    private TextField txttname;

	   	@FXML
	    private Button btntupdate;

	   	@FXML
	    private AnchorPane thpane;

	    @FXML
	    private Button btntback;

	    @FXML
	    private Button btnupdate;

	    @FXML
	    void add(ActionEvent event) {
	    	updateseatshow();
	    }

	    @FXML
	    void back(ActionEvent event) {
	    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
	    }

	    @FXML
	    void update(ActionEvent event) {
	    	String tname=  txttname.getText();
	    	
		   	Theater updatetheater = TheaterAdd.theater;
		     
		   	boolean result = TheaterDao.theaterDao.상영관수정(updatetheater);
		   	
		   	if(result) {
		   		alert.setHeaderText("상영관 수정 성공 !!");
				alert.showAndWait();
		   		
		   	}else {
		   		alert.setHeaderText("상영관 등록 실패 !!");
				alert.showAndWait();
		   	}
	    }
	   
	
	
	public void updateseatshow() {
	   	
		   GridPane gridPane = new GridPane();
	    
	    	gridPane.setPadding(new Insets(10));
	    	
	    	gridPane.setHgap(10);
	    	gridPane.setVgap(10);
	  
	    	int i = 0;
	    	
	    	for(int row=0; row<200/20; row++) {
	    		int j=1;
	    		
	    		for(int col=0; col<20; col++) {
	    			
	    			ToggleButton button = new ToggleButton();
	    			button.setPrefWidth(40);
	    			button.setPrefHeight(40);
	    			
	    			//좌석 번호 정렬
	    			if(row==0) {button.setText("A"+j); 	}
	    			if(row==1) {button.setText("B"+j); 	}
	    			if(row==2) {button.setText("C"+j);	}
	    			if(row==3) {button.setText("D"+j); 	}
	    			if(row==4) {button.setText("E"+j); 	}
	    			if(row==5) {button.setText("F"+j); 	}
	    			if(row==6) {button.setText("G"+j); 	}
	    			if(row==7) {button.setText("H"+j); 	}
	    			if(row==8) {button.setText("I"+j); 	}
	    			if(row==9) {button.setText("J"+j); 	}
	    	
	    			
	    			
	    			
	    		
//	    			if(button.getId().equals(gridPane)) {
//	    				button.setVisible(false);
//	    			}
//	    			ArrayList<String> seats= new ArrayList<>();
	    			
	    			gridPane.add(button, col, row);
	    			i++;
	    			j++;

	    			button.setOnMouseClicked(e -> {
		    			x = button.getId();
		    			if(button.isSelected()) {
		    				cn.add(x);
		    				button.setVisible(false); 
		    				count++;
		    			}
		    		});	
	    		}
	    	}
	    	
	    	
	    		    	
	    	thpane.getChildren().add(gridPane);	
	    	
  }

 
 
    

  


}
