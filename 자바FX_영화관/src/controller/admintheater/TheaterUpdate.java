package controller.admintheater;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Admin_Home;
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
	    
	    	
	    	
	    	Theater updatetheater = TheaterAdd.theater;
		    
	    	boolean result =TheaterDao.theaterDao.상영관수정(updatetheater);	    	
		  
		   	
		   	if(result) {
		   		alert.setHeaderText("상영관 수정 성공 !!");
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

	    @FXML
	    void update(ActionEvent event) {
	    	//카운트 되돌리기
	    	count=0;
	    	//아크로보드 전체 지우기 (중복 방지)
	    	thpane.getChildren().clear();
	    	//updateseatshow 다시 구현
	    	updateseatshow();
	    	//영화관 수정 버튼 클릭 후 배열 내 정보 삭제 ( 중복 방지 )
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
	    			String str=TheaterDao.theaterDao.좌석호출(TheaterList.select.get관번호());
	    		
	    			
	    			//수정 필요
	    			//1.길이 재 설정 
	    			
	    			for(int a=0; a<(200-Integer.parseInt(TheaterList.select.get관좌석() )); a++) {
	    				String seat= str.toString().split(",")[a];
	    				seats.add(seat);
	    				if(button.getId().equals(seat)) {
	    					button.setVisible(false);
	    				
	    				}
	    			}	//2.선택한 값만큼만 좌석좌표 불러오기
	    		

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
