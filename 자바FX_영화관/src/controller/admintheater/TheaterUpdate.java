package controller.admintheater;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Admin_Home;
import controller.Main;
import dao.TheaterDao;
import dto.Theater;
import javafx.css.Size;
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
		
		public static TheaterUpdate theaterUpdate;
		public TheaterUpdate(){
			theaterUpdate = this;
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			Theater theater = TheaterList.select;
			txttname.setText(TheaterList.select.get���̸�());
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
	    
	    	
	    	
	    	Theater updatetheater = TheaterAdd.theater;
		    
	    	boolean result =TheaterDao.theaterDao.�󿵰�����(updatetheater);	    	
		  
		   	
		   	if(result) {
		   		alert.setHeaderText("�󿵰� ���� ���� !!");
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

	    @FXML
	    void update(ActionEvent event) {
	    	//ī��Ʈ �ǵ�����
	    	count=0;
	    	//��ũ�κ��� ��ü ����� (�ߺ� ����)
	    	thpane.getChildren().clear();
	    	//updateseatshow �ٽ� ����
	    	updateseatshow();
	    	//��ȭ�� ���� ��ư Ŭ�� �� �迭 �� ���� ���� ( �ߺ� ���� )
	    	cn.clear();
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
	    			
	    			//�¼� ��ȣ ����
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
	    			String str=TheaterDao.theaterDao.�¼�ȣ��(TheaterList.select.get����ȣ());
	    		
	    			
	    			//���� �ʿ�
	    			//1.���� �� ���� 
	    			
	    			//2.������ ����ŭ�� �¼���ǥ �ҷ�����
	    			for(int a=0; a<(200-Integer.parseInt(TheaterList.select.get���¼�() )); a++) {
	    				String seat= str.toString().split(",")[a];
	    				seats.add(seat);
	    				if(button.getId().equals(seat)) {
	    					button.setVisible(false);
	    				
	    				}
	    			}

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
