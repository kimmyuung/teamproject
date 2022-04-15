package Controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Home implements Initializable{
	
	public static Home home;
	
	public Home() {
		
	}
	
    @FXML
    private AnchorPane ahome;

    @FXML
    private Button btnmlist;

    @FXML
    private Button btntlist;

    @FXML
    private Button btnsales;

    
    //영화 리스트 버튼 클릭 시 
    @FXML
    void mlist(ActionEvent event) {
    	//loadpage("/AdminView/home/adminhome.fxml);
    }
    // 매출 버튼 클릭 시
    @FXML
    void sales(ActionEvent event) {
    	//loadpage("/AdminView/sales/salescheck.fxml);
    }
    //상영관 목록 버튼 클릭 시 
    @FXML
    void tlist(ActionEvent event) {
    	//loadpage("/AdminView/theater/theaterlist.fxml);
    }
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// TODO Auto-generated method stub
    	
    }

}
