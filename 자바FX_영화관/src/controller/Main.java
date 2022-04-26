package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {

	public static Main main;
	public Main(){
		main = this;
	}
	
	@FXML
    private BorderPane borderpane;
	
	@FXML
    private AnchorPane anpane; // fx:id 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/#2movie.fxml");
	}
	
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		}catch (Exception e) {System.out.println("페이지 불러오기 실패" + e);}
	}
	
	public void loadpage2( String page ) { // loadpage( 파일경로 ) 
		try { // 예외처리 
			Parent parent = FXMLLoader.load( getClass().getResource(page)); // 해당 파일 불러오기 
			anpane.setClip(parent);
			
		}catch( Exception e ) { System.out.println("페이지 불러오기 실패 사유: "+ e);} // 만약에 파일이 존재하지 않으면 예외 발생 
		
	}
	
	
}
