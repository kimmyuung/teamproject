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
	public static admin_home ���ΰ�ü;
	// * ������
	// 2. �����ڿ��� ��ü���� this �ֱ�
	public static admin_home get���ΰ�ü() {
		return ���ΰ�ü;
	}
	public admin_home () {
		���ΰ�ü = this;
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
