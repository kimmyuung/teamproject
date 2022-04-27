package controller.admintheater;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import dao.InfoDao;
import dao.MovieDao;
import dto.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Runmovieadd implements Initializable{
	
	Alert alert = new Alert(AlertType.INFORMATION);
	public static Movie movie;
    @FXML
    private Button btnupdate;

    @FXML
    private Button btntback;

    @FXML
    private Button btnrmovieadd;

    @FXML
    private TableView<Movie> mlist;
    
    @FXML
    private Label lbltname;

    @FXML
    private ChoiceBox<String> timebar;

    @FXML
    void add(ActionEvent event) {
    	String time = timebar.getValue();
    	String title = movie.get영화제목();
    	String tname = lbltname.getText();
    	String grade = movie.get연령등급();
    	boolean result= InfoDao.infoDao.시간등록(time, title, tname,grade);
    	
    	if(result) {
    		alert.setHeaderText("상영관 등록 성공 !!");
			alert.showAndWait();
			Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
    	}
    	else {
    		alert.setHeaderText("상영관 등록 실패 !!");
			alert.showAndWait();
    	}
    }

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
    }

    @FXML
    void listopen(MouseEvent event) {
    	
    }

    @FXML
    void update(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	lbltname.setText(TheaterList.select.get관이름());
    	show();
    	timebar.setItems(FXCollections.observableArrayList ( "08:00-11:00", "11:30-14:00", "14:30-17:00", "17:30-20:00", "20:00-22:30"));
    }
    
    public void show() {
    	ObservableList<Movie> infolist = MovieDao.movieDao.list();
    	
    	TableColumn tc = mlist.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("num"));
    	
    	tc= mlist.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("movie"));
    	
    	tc= mlist.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("time"));
    	
    	tc= mlist.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("name"));
    	
    	mlist.setItems(infolist);
    	
    	mlist.setOnMouseClicked( e -> {
    		
    		movie = mlist.getSelectionModel().getSelectedItem();
    		
    	});
   
    	
    	
    }
    
}
