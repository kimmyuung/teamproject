package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main implements Initializable {

	public static Main main;
	public Main(){
		main = this;
	}
	
	@FXML
    private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/#2movie.fxml");
	}
	
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		}catch (Exception e) {System.out.println("페이지 전환 실패" + e);}
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
