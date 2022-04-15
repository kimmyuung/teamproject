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

public class admin_home implements Initializable{
	public static admin_home 본인객체;
	// * 생성자
	// 2. 생성자에서 객체내에 this 넣기
	public static admin_home get본인객체() {
		return 본인객체;
	}
	public admin_home () {
		본인객체 = this;
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
	    	//loadpage("/view/Adminview/movie/movielist.fxml");
	    }

	    @FXML
	    void slist(ActionEvent event) {
	    	//loadpage("/view/Adminview/sales/salescheck.fxml");
	    }

	    @FXML
	    void tlist(ActionEvent event) {
	    	//loadpage("/view/Adminview/theater/theaterlist.fxml");
	    }
	    
	  @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
