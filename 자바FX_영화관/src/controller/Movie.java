package controller;


import java.net.URL;
import java.util.ResourceBundle;

import dao.MovieDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Movie implements Initializable {

	public static dto.Movie select;
	
	
	
	
	
    @FXML
    private Button btnnext;

    @FXML
    private VBox vbox;
    @FXML
    private ScrollPane scorllpan;

    @FXML
    void accnext(ActionEvent event) {
    	Main.main.loadpage("/view/#3time.fxml");
    }
	void show() {
		 
	    	if(vbox.getChildren().isEmpty() == false) { // .isEmpty() : 해당 객체내 비어있는지 확인[vbox 내 비어있는지 확인]
	    		// vbox내 객체가 비어있지 않으면
	    		vbox.getChildren().remove(0); // vbox내 기존 객체를 삭제;
	    		}
	    	
	    	// 1. 모든 제품 가져오기
	    			ObservableList<dto.Movie> mlist = MovieDao.movieDao.list();
	    			// 2. 그리드 클래스 [ 행/열 ]
	    			GridPane gridPane = new GridPane();
	    				// * 그리드 여백
	    				gridPane.setPadding( new Insets(10) );
	    				// * 그리드내 셀 여백 
	    				gridPane.setHgap(20);
	    				gridPane.setHgap(20);

	    			// 3. 반복문 
	    			int i = 0 ; // 인덱스용 변수
	    			for( int row = 0 ; row < mlist.size()/2  ; row++ ) { // 행
	    				for( int col = 0 ; col<2 ; col++ ) { // 열
	    					
	    					// 1. 이미지

	    					ImageView imageView = new ImageView( new Image(mlist.get(i).get이미지() ) );
	    						
	    						// *이미지 사이즈 
	    						imageView.setFitWidth(390);		// 이미지 가로길이 
	    						imageView.setFitHeight(390); 	// 이미지 세로길이
	    					// 2. 버튼 생성 ( 버튼에 이미지 넣기 )
	    						Button button = new Button( null , imageView );
	    						// *버튼 배경제거 [ transparent : 투명색 ]
	    						button.setStyle("-fx-background-color:transparent");
	    						// *버튼 id값넣기 [ 제품 식별 = index ]
	    						button.setId( i+"" );
	    						// *버튼 클릭이벤트
	    							//	button.setOnAction( e -> { } ); // 람다식 : 인수 -> { 실행코드 }
	    						button.setOnAction( e -> { 
	    							// 1. 클릭한 버튼의 id 가져오기
	    						
	    							int id = Integer.parseInt(  e.toString().split(",")[0].split("=")[2] );
	    							// 2. 클릭한 제품 번호 저장 
	    							select = mlist.get(id);
	    							// 3. 화면 전환
	    							Main.main.loadpage("/view/#3time.fxml");
	    						} );
	    					gridPane.add( button  , col , row); // 그리드내  해당 열번호 , 행번호 에 버튼 추가
	    					
	    					i++; //인덱스 증가
	    				}
	    			}
	    			
	    			// * 3배수의 나머지값
	    			int row = mlist.size() / 2;		// 행
	    			int remain = mlist.size() % 2 ;	// 마지막행의 나머지 
	    			if( remain != 0  ) { // 나머지가 존재하면 
	    				for( int col = 0 ; col<remain ; col++ ) { // 열
	    						ImageView imageView = new ImageView( new Image(mlist.get(i).get이미지() ) );
	    						imageView.setFitWidth(150);		// 이미지 가로길이 
	    						imageView.setFitHeight(150); 	// 이미지 세로길이
	    						Button button = new Button( null , imageView );
	    						button.setStyle("-fx-background-color:transparent");
	    						button.setId( i+"" );
	    						button.setOnAction( e -> { 
	    							int id = Integer.parseInt(  e.toString().split(",")[0].split("=")[2] );
	    							select = mlist.get(id);
	    							Main.main.loadpage("/view/#3time.fxml");
	    						} );	
	    					gridPane.add( button  , col , row+1 ); // 마지막행에 나머지값 만큼 버튼 추가해서 그리드에 추가
	    					i++; //인덱스 증가
	    				}
	    			}
	    			// 4. vbox에 그리도 넣기 
	    			vbox.getChildren().add(gridPane);
	 }
	 
	 @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			show();
		}
}
