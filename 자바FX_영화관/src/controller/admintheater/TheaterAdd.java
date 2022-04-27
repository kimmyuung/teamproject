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



//2. 좌석이 줄어들면 그 수만큼 그걸 DB에 적용

public class TheaterAdd implements Initializable {
	
	Alert alert = new Alert(AlertType.INFORMATION);	//알람 객체생성
	
	public static TheaterAdd theaterAdd = new TheaterAdd();	//다른 클래스에서 쓰기위해 객체생성
	
	public static Theater theater;	// 다른 클래스에서 쓰기위한 필드
	
	static ArrayList<String> cn = new ArrayList<>(); //좌석 좌표 저장용 배열

	private static int count;	//좌석 수 카운트
	
	static String x; //좌석 좌표 저장용 문자열
	
	AnchorPane anchorPane = new AnchorPane();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		seatshow();
		
		
	
	}
	 
	@FXML
	private AnchorPane thpane;
	
    @FXML
    private TextField txttname;

    @FXML
    private Button btntadd;

    @FXML
    private Button btntback;
    
    @FXML
    private Button btnupdate;
   
    //좌석 수정
    @FXML
    public void update(ActionEvent event) {
    	//카운트 되돌리기
    	count=0;
    	//아크로보드 전체 지우기 (중복 방지)
    	thpane.getChildren().clear();
    	//seatshow 다시 구현
    	seatshow();
    	//영화관 수정 버튼 클릭 후 배열 내 정보 삭제 ( 중복 방지 )
    	cn.clear();
    	
    
    	
    }
    
    //좌석 등록
    @FXML
    public void add(ActionEvent event) {
    	
    	
    	String tname =txttname.getText();  //텍스트로 받아온 관 이름
    	
    	
    	int tseat = 200 - count; //좌석 수 카운트
    	
    	String str="";
    	for(String temp: cn) {  
    		
    		str+=temp+","; // 쪼개기 위한 문자열(",") 설정
    		
    	}
    	
    	//영화관 객체 생성
    	theater = new Theater(0, tname, Integer.toString(tseat), str ); 
    	//영화관 등록후 배열 내 정보 삭제 ( 중복 방지 )
    	cn.clear();
    	//영화관 등록 후 좌석 카운트 수 초기화
    	count=0;
    	
    	
    
    	
     
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
    public void back(ActionEvent event) {
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
	    	
	    			gridPane.add(button, col, row);
	    			i++;
	    			j++;
	    			
	    			
	    			//버튼 클릭시 해당 id값 안보이게 설정
	    			button.setOnMouseClicked(e -> {
		    			x = button.getId();
		    			 
		    			if(button.isSelected()) {
		    				
		    				cn.add(x);
		    				count++;
		    				button.setVisible(false);
		    				
		    				
		    			}
		    		
	    			});	
	    			
	    		}
	    	}		    	
	    	thpane.getChildren().add(gridPane);	
	    	
     }

}
