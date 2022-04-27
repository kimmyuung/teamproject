package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.admintheater.TheaterList;
import dao.MovieDao;
import dao.TicketDao;

import dto.Ticket;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class Check_num implements Initializable{
	
	 
	public static int 성인=0;
	public static int 청소년=0;
	public static int total_num=0;
	public static int button =0;
	static ArrayList<Ticket> ticket = new ArrayList<>();
	
    @FXML
    private ToggleGroup Adult_Num11;

	
	@FXML
    private AnchorPane anchorpane;
    
    @FXML
    private Label lbladult;
    
    @FXML
    private ToggleButton btnadult0;

   
    @FXML
    private ToggleButton btnadult1;

    @FXML
    private ToggleButton btnadult2;

    @FXML
    private ToggleButton btnadult3;

    @FXML
    private ToggleButton btnadult4;
    
    @FXML
    private ToggleButton btnadult5;

    @FXML
    private ToggleButton btnadultex;

    
    @FXML
    private ToggleGroup Adult_Num;

    
    @FXML
    private Label lblyoung;
    
    @FXML
    private ToggleButton btnyoung0;

    
    @FXML
    private ToggleButton btnyoung1;

    @FXML
    private ToggleButton btnyoung2;

    @FXML
    private ToggleButton btnyoung3;

    @FXML
    private ToggleButton btnyoung4;

    @FXML
    private ToggleButton btnyoung5;
    
    @FXML
    private ToggleButton btnyoungex;

    
    @FXML
    private ToggleGroup Young_Num;

    
    
    @FXML
    private Button btnBefore;

    @FXML
    private Button btnNext;

    @FXML
    private ImageView viewimg;

    
    


    @FXML
    void accadult0(ActionEvent event) {
    	boolean isSelected = btnadult0.isSelected();
    	if(isSelected) {
    		성인 = 0;
    	}
    	else {
    		성인 = 0;
    	}
    }

    @FXML
    void accadult1(ActionEvent event) {
    	boolean isSelected = btnadult1.isSelected();
    	if(isSelected) {
    		성인 = 1;
    	}
    	else {
    		성인 = 0;
    	}
    
    		
    }

    @FXML
    void accadult2(ActionEvent event) {
    	boolean isSelected = btnadult2.isSelected();
    	if(isSelected) {
    		성인 = 2;
    	}
    	else {
    		성인 = 0;
    	}
    }

    @FXML
    void accadult3(ActionEvent event) {
    	boolean isSelected = btnadult3.isSelected();
    	if(isSelected) {
    		성인 = 3;
    	}
    	else {
    		성인 = 0;
    	}
    }

    @FXML
    void accadult4(ActionEvent event) {
    	boolean isSelected = btnadult4.isSelected();
    	if(isSelected) {
    		성인 = 4;
    	}
    	else {
    		성인 = 0;
    	}
    }

    @FXML
    void accadult5(ActionEvent event) {
    	boolean isSelected = btnadult5.isSelected();
    	if(isSelected) {
    		성인 = 5;
		}
    	else {
    		성인 = 0;
		}
    }

    @FXML
    void accadultex(ActionEvent event) {
    	button=1;
    	Main.main.popup();
    	
    }

    @FXML
    void accyoung0(ActionEvent event) {
    	boolean isSelected = btnyoung0.isSelected();
    	if(isSelected) {
    		청소년 = 0;
    	}
    	else {
    		청소년 = 0;
    	}
    }

    @FXML
    void accyoung1(ActionEvent event) {
    	
    	boolean isSelected = btnyoung1.isSelected();
    	if(isSelected) {
    		청소년 = 1;
    	}
    	else {
    		청소년 = 0;
    	}
    }

    @FXML
    void accyoung2(ActionEvent event) {
    	boolean isSelected = btnyoung2.isSelected();
    	if(isSelected) {
    		청소년 = 2;
    	}
    	else {
    		청소년 = 0;
    	}
    }
    @FXML
    void accyoung3(ActionEvent event) {
    	boolean isSelected = btnyoung3.isSelected();
    	if(isSelected) {
    		청소년 = 3;
    	}
    	else {
    		청소년 = 0;
    	}
    }
    
    @FXML
    void accyoung4(ActionEvent event) {
    	
    	boolean isSelected = btnyoung4.isSelected();
    	if(isSelected) {
    		청소년 = 4;
    	}
    	else {
    		청소년 = 0;
    	}
    }

    @FXML
    void accyoung5(ActionEvent event) {
    	
    	boolean isSelected = btnyoung5.isSelected();
    	if(isSelected) {
    		청소년 = 5;
    	}
    	else {
    		청소년 = 0;
    	}
    }

    @FXML
    void accyoungex(ActionEvent event) {
    	button=2;
    	Main.main.popup();
    	
    }

  
    
    
	
	
    @FXML
    void accBefore(ActionEvent event) {
    	Alert alert = new Alert( AlertType.INFORMATION );  
		alert.setHeaderText("시간 선택 메뉴로 돌아갑니다.");
		alert.showAndWait();
    	Main.main.loadpage("/view/#3time.fxml");
    }

	@FXML
    void accNext(ActionEvent event) {
		
		Alert alert = new Alert( AlertType.INFORMATION );  
		if(성인==0 && 청소년==0) {
    		alert.setHeaderText(" 관람하시는 인원 수를 입력해 주세요");
    		alert.showAndWait();
    		
    	}
		else {
			
//		
			alert.setHeaderText("성인 : "+성인+" 명,  청소년 : "+청소년+" 명 선택 하셨습니다");
			alert.showAndWait();
			total_num = 성인+청소년;
			
	    	Main.main.loadpage("/view/#5seat.fxml");
			}
	    	
		
    }

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Image image = new Image(Movie.select.get이미지().toString());  
		viewimg.setImage(image);
		
		
		if (Time.info.getGrade().equals("청소년 관람불가")) {
			lblyoung.setText("청소년은 관람할 수 없습니다.");
			
			btnyoung0.setDisable(true);
			btnyoung1.setDisable(true);
			btnyoung2.setDisable(true);
			btnyoung3.setDisable(true);
			btnyoung4.setDisable(true);
			btnyoung5.setDisable(true);
			btnyoungex.setDisable(true);
		}
		
		
	}

}
