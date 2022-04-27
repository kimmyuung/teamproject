package controller.admintheater;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import dao.InfoDao;
import dto.Info;
import dto.Movie;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TheaterTime implements Initializable {

	//알람객체
	Alert alert = new Alert(AlertType.INFORMATION);
	//선택 한 값 저장용
	public static Movie select;
	
	
    @FXML
    private Button btntback;

    @FXML
    private TableView<Info> tlist;

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
    }
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Info> info = InfoDao.infoDao.Infolist();
		
		TableColumn tc= tlist.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		tc=tlist.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("movie"));
		
		tc=tlist.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		tlist.setItems(info);	
		
	}
	
	


}


