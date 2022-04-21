package jin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import jin.application.Start;

public class Main implements Initializable{
	
	public static Main instance;
	public Main() {
		instance = this;
	}
	Stage window;
    Scene scene;
    Button button;
	@FXML
	private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		loadpage("/jin/view/#4_인원선택.fxml");
		
	}
	public void loadpage( String page ) { // loadpage( 파일경로 ) 
		try { // 예외처리 
			
			Parent parent = FXMLLoader.load( getClass().getResource(page));
			// main.fxml에 존재하는 borderpane객체내 center을 해당 파일로 변경
			borderpane.setCenter(parent);
			
		}catch( Exception e ) { System.out.println("페이지 불러오기 실패 사유: "+ e);} // 만약에 파일이 존재하지 않으면 예외 발생 
	
	}
	
	public void popup() { // 새창 띄우기
		
		  try{
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/jin/view/인원수입력.fxml"));
		    Parent root = (Parent) loader.load();
		    Stage stage = new Stage();
		    stage.setTitle("관람 인원 수 입력");
		    stage.setScene(new Scene(root));
		    stage.show();
		  }catch(Exception e) {
		  
		  }
	}
	
}
