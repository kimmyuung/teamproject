package jin.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

//import dao.MovieDao;
//import dao.TicketDao;
//import dto.Movie;
//import dto.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class Check_num implements Initializable{
	
	 
	public static int 성인=0;
	public static int 청소년=0;
//	public static int input_value =0;
	public static int button =0;
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
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    	else {
    		성인 = 0;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    }

    @FXML
    void accadult1(ActionEvent event) {
    	
    	boolean isSelected = btnadult1.isSelected();
    	if(isSelected) {
    		성인 = 1;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    	else {
    		성인 = 0;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    
    		
    }

    @FXML
    void accadult2(ActionEvent event) {
    	
   
    	boolean isSelected = btnadult2.isSelected();
    	if(isSelected) {
    		성인 = 2;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    	else {
    		성인 = 0;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    }

    @FXML
    void accadult3(ActionEvent event) {
    	boolean isSelected = btnadult3.isSelected();
    	if(isSelected) {
    		성인 = 3;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    	else {
    		성인 = 0;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    }

    @FXML
    void accadult4(ActionEvent event) {
    	lbladult.setText("성인 : 4 명 입니다.");
    	boolean isSelected = btnadult4.isSelected();
    	if(isSelected) {
    		성인 = 4;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    	else {
    		성인 = 0;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    }

    @FXML
    void accadult5(ActionEvent event) {
    	lbladult.setText("성인 : 5 명 입니다.");
    	boolean isSelected = btnadult5.isSelected();
    	if(isSelected) {
    		성인 = 5;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    	else {
    		성인 = 0;
    		System.out.println(성인);
    		lbladult.setText("성인 : "+성인+"  명 입니다.");
    	}
    }

    @FXML
    void accadultex(ActionEvent event) {
    	button=1;
    	Main.instance.popup();
    	lbladult.setText("성인 : "+성인+"명 입니다.");
    }

    @FXML
    void accyoung0(ActionEvent event) {
    	lblyoung.setText(" 청소년 : 0 명 입니다.");
    	boolean isSelected = btnyoung0.isSelected();
    	if(isSelected) {
    		청소년 = 0;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    		
    	}
    	else {
    		청소년 = 0;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    }

    @FXML
    void accyoung1(ActionEvent event) {
    	lblyoung.setText(" 청소년 : 1 명 입니다.");
    	boolean isSelected = btnyoung1.isSelected();
    	if(isSelected) {
    		청소년 = 1;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	
    	}
    	else {
    		청소년 = 0;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    		accyoung0(event);
    	}
    }

    @FXML
    void accyoung2(ActionEvent event) {
    	lblyoung.setText(" 청소년 : 2 명 입니다.");
    	boolean isSelected = btnyoung2.isSelected();
    	if(isSelected) {
    		청소년 = 2;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+" 명 입니다.");
    	}
    	else {
    		청소년 = 0;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    }
    @FXML
    void accyoung3(ActionEvent event) {
    	lblyoung.setText(" 청소년 : 3 명 입니다.");
    	boolean isSelected = btnyoung3.isSelected();
    	if(isSelected) {
    		청소년 = 3;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    	else {
    		청소년 = 0;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    }
    
    @FXML
    void accyoung4(ActionEvent event) {
    	lblyoung.setText(" 청소년 : 4 명 입니다.");
    	boolean isSelected = btnyoung4.isSelected();
    	if(isSelected) {
    		청소년 = 4;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    	else {
    		청소년 = 0;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    }

    @FXML
    void accyoung5(ActionEvent event) {
    	lblyoung.setText(" 청소년 : 5 명 입니다.");
    	boolean isSelected = btnyoung5.isSelected();
    	if(isSelected) {
    		청소년 = 5;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    	else {
    		청소년 = 0;
    		System.out.println(청소년);
    		lblyoung.setText("청소년 : "+청소년+"  명 입니다.");
    	}
    }

    @FXML
    void accyoungex(ActionEvent event) {
    	button=2;
    	Main.instance.popup();
    	lblyoung.setText("청소년 : "+청소년+"명 입니다.");
    }

  
    
    
	
	
    @FXML
    void accBefore(ActionEvent event) {
    	Alert alert = new Alert( AlertType.INFORMATION );  
		alert.setHeaderText("시간 선택 메뉴로 돌아갑니다.");
		alert.showAndWait();
    	Main.instance.loadpage("/jin/view/#2_시간선택.fxml");
    }

	@FXML
    void accNext(ActionEvent event) {
		System.out.println(성인);
		Alert alert = new Alert( AlertType.INFORMATION );  
		if(성인==0 && 청소년==0) {
    		alert.setHeaderText(" 관람하시는 인원 수를 입력해 주세요");
    		alert.showAndWait();
    		
    	}
		else {
			
//			int i=0;
//			
////			int 성인_관람_가격 = MovieDao.movieDao.list().get(i).get가격();
//			int 성인_관람_가격 = 8000;
//			int total_num = 성인+청소년;
//			// 청소년은 성인 관람가격 의 30% 할인 예정
//			// int 청소년 관람가격 = 성인_관람_가격 *0.7; 
//			for(i=0;i<total_num;i++)	{
//				TicketDao.ticketDao.티켓저장(ticket);
//			}
				
			
			alert.setHeaderText("성인 :"+성인+"명, 청소년 :"+청소년+"명 선택 하셨습니다");
			alert.showAndWait();
	    	Main.instance.loadpage("/jin/view/#5_좌석선택.fxml");
			}
	    	
    	
    	
    }

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		
	}

}
