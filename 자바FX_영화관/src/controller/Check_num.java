package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.MovieDao;
import dao.TicketDao;
import dto.Member;
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
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class Check_num implements Initializable{
	
	 
	public static int 성인=0;
	public static int 청소년=0;
//	public static int input_value =0;
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
			
			//public Ticket(int 가격, String 영화제목, int 인원수, String 관이름, String 날짜, String 좌석) {	
			
			alert.setHeaderText("성인 : "+성인+" 명,  청소년 : "+청소년+" 명 선택 하셨습니다");
			alert.showAndWait();
			int total_num= 성인+청소년;
			int i = 0; int j= 0;
			for( i=0;i<=성인;i++) {
				
				
				Ticket ticket = new Ticket(10000*total_num, null, total_num, null, null, null);
				boolean result = TicketDao.ticketDao.티켓저장(ticket);
			}
			for(j=0;j<=청소년;j++) {
				
			}
			
			
			TicketDao.ticketDao.티켓저장(true);
			
			// 1. 회원가입 메소드 ( 인수 : db에 넣을 아이디,비밀번호,이메일,주소 )
			public boolean ticketing(Ticket ticket ) { 
				try {
					// 1. SQL 작성  [ 회원번호(자동번호=auto) 제외한 모든 필드 삽입 ]
					String sql = "insert into ticket(ticket_title,ticket_name,ticket_price,ticket_seat,ticket_date)values(?,?,?,?,?)";
					// 2. SQL 조작
					ps = con.prepareStatement(sql); // PreparedStatement 인터페이스내 연결된 db에 sql 넣기
					ps.setInt( 1 , ticket.get가격()); // 1번 ? 에 아이디 넣어주기
					ps.setString( 2 , ticket.get영화제목() ); // 2번 ? 에 비밀번호 넣어주기
//					ps.setString( 3 , ticket.getMemail() ); // 3번 ? 에 이메일 넣어주기
//					ps.setString( 4 , ticket.getMaddress() ); // 4번 ? 에 주소 넣어주기
//					ps.setInt( 5 , ticket.getMpoint() ); // 5번 ? 에 포인트 넣어주기
					
					// 3. SQL 실행 
					ps.executeUpdate(); // insert 실행 -> 삽입 결과물 X -> resultset X
					return true; // * 성공시 
				}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
				return false; // * 실패시
			}
			
			
	    	Main.main.loadpage("/view/#5seat.fxml");
			}
	    	
		
    }

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if (Time.info.get연령등급().equals("청소년 관람불가")) {
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
