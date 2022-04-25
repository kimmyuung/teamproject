package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Admin_Home implements Initializable{
	
	public static Admin_Home instance;
	
	// * 생성자
	public Admin_Home () {
		instance= this;
	}

	public static Admin_Home getinstance() {
		return instance;
	}
	
	//화면 전환 메소드
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borederpane.setCenter(parent);
		}catch (Exception e) {
			System.out.println( e );
			
		}
	}
	
	    @FXML
	    private BorderPane borederpane;
	  
	    @FXML
	    private AnchorPane anchorpane;

	    @FXML
	    private Button btnmlist;

	    @FXML
	    private Button btntlist;

	    @FXML
	    private Button btnslist;

	    @FXML
	    void mlist(ActionEvent event) {
	    	loadpage("/view/AdminView/movie/movielist.fxml");
	    }

	    @FXML
	    void slist(ActionEvent event) {
	    	loadpage("/view/AdminView/sales/salescheck.fxml");
	    }

	    @FXML
	    void tlist(ActionEvent event) {
	    	loadpage("/view/AdminView/theater/theaterlist.fxml");
	    }
	    
	    
	    
	  @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	  

	  
	  
}
