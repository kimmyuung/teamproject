
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
public class TheaterAdd implements Initializable {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
	public static TheaterAdd theaterAdd = new TheaterAdd();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		seatshow();
	
	}
	
	static String x;
	 
	@FXML
	private AnchorPane thpane;
	
    @FXML
    private TextField txttname;

    @FXML
    private Button btntadd;

    @FXML
    private Button btntback;
    
    @FXML
    private Button btndelete;
    
    
   
    static ArrayList<String> cn = new ArrayList<>();
   
    private static int count;
    
    //좌석 수정
    @FXML
    void delete(ActionEvent event) {
    	seatshow();
    }
    public static Theater theater;
   
    //좌석 등록
    @FXML
    void add(ActionEvent event) {
    	String tname =txttname.getText();
    	int tseat = 200 - count;
    	for(int i = 0; i < cn.size(); i++) {
    		
    	}
     // theater = new Theater(0, tname, Integer.toString(tseat), cn); 
     //	System.out.println(tseat);
     	boolean result=TheaterDao.theaterDao.상영관등록(theater);
     	
     	if(result ) {
     		alert.setHeaderText("상영관 등록 성공 !!");
			alert.showAndWait();
			Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
     	}else {
     		alert.setHeaderText("상영관 등록 실패 !!");
			alert.showAndWait();
     	}
    }
    //뒤로가기
    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
    }
    //좌석 보여주기
    public void seatshow() {
	   	
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
	    			if(row==0) {button.setText("A"+j); 	button.setId("A"+j);}
	    			if(row==1) {button.setText("B"+j); 	button.setId("B"+j);}
	    			if(row==2) {button.setText("C"+j);	button.setId("C"+j);}
	    			if(row==3) {button.setText("D"+j); 	button.setId("D"+j);}
	    			if(row==4) {button.setText("E"+j); 	button.setId("E"+j);}
	    			if(row==5) {button.setText("F"+j); 	button.setId("F"+j);}
	    			if(row==6) {button.setText("G"+j); 	button.setId("G"+j);}
	    			if(row==7) {button.setText("H"+j); 	button.setId("H"+j);}
	    			if(row==8) {button.setText("I"+j); 	button.setId("I"+j);}
	    			if(row==9) {button.setText("J"+j); 	button.setId("J"+j);}
	    	
	    			
	    			ArrayList<String> seats= new ArrayList<>();
	    			
	    			gridPane.add(button, col, row);
	    			i++;
	    			j++;

	    			button.setOnMouseClicked(e -> {
		    			x = button.getId();
		    			if(button.isSelected()) {
		    				cn.add(x);
		    				System.out.println(cn);
		    				button.setVisible(false); 
		    				count++;
		    			}
		    		});	
	    		}
	    	}
	    	
	    	
	    		    	
	    	thpane.getChildren().add(gridPane);	
	    	
     }

}
