package controller.admintheater;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Admin_Home;
import controller.adminmovie.MovieList;
import dao.MovieDao;
import dao.TheaterDao;
import dto.Movie;
import dto.Theater;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TheaterList implements Initializable{
	
	public static Theater select;
	
	Alert alert = new Alert(AlertType.CONFIRMATION);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Theater> theaterlist=TheaterDao.theaterDao.list();
		
		TableColumn tc = tlist.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("����ȣ"));
		
		tc=tlist.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("���̸�"));
		
		tc=tlist.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("���¼�"));
		
		
		
		tlist.setItems(theaterlist);
		
		tlist.setOnMouseClicked(e-> {
			select= tlist.getSelectionModel().getSelectedItem();
		});
	
	}
 
	@FXML
    private TableView<Theater> tlist;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnback;

    @FXML
    private Button btnadd;

    @FXML
    private Button btntimeadd;

    @FXML
    private Button btntimeupdate;
    
    @FXML
    void add(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theateradd.fxml");
    }

    @FXML
    void timeadd(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/movietime.fxml");
    }

    @FXML
    void timeupdate(ActionEvent event) {
    	
    }
    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/home/adminhome.fxml");
    }
    
    @FXML
    void update(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterupdate.fxml");
    }
    
    @FXML
    void delete(ActionEvent event) {
    	alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
		Optional<ButtonType> optional = alert.showAndWait();
		if(optional.get()== ButtonType.OK) {
			boolean result=TheaterDao.theaterDao.�󿵰�����(TheaterList.select.get����ȣ());
			if(result) {
				alert.setHeaderText("�����Ǿ����ϴ�.");
				alert.showAndWait();
				Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
			}
		}
    }

}
