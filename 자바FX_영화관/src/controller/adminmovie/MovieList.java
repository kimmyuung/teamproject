package controller.adminmovie;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import controller.Admin_Home;
import dao.MovieDao;
import dto.Movie;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovieList implements Initializable{
	
	public static Movie select;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 ObservableList<Movie> movieList = MovieDao.movieDao.list();
	 
	 TableColumn tc = mlist.getColumns().get(0);
	 tc.setCellValueFactory(new PropertyValueFactory<>("��ȭ��ȣ"));
	 
	 tc=mlist.getColumns().get(1);
	 tc.setCellValueFactory(new PropertyValueFactory<>("���ɵ��"));
	 
	 tc=mlist.getColumns().get(2);
	 tc.setCellValueFactory(new PropertyValueFactory<>("����Ÿ��"));
	 
	 tc=mlist.getColumns().get(3);
	 tc.setCellValueFactory(new PropertyValueFactory<>("��ȭ����"));
	 
	 tc=mlist.getColumns().get(4);
	 tc.setCellValueFactory(new PropertyValueFactory<>("����"));
	 
	 mlist.setItems(movieList);
	 
	 mlist.setOnMouseClicked(e-> {
		 select=mlist.getSelectionModel().getSelectedItem();
		 
	 });
	}
	
	
	@FXML
    private TableView<Movie> mlist;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnback;

    @FXML
    void add(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/movie/movieadd.fxml");
    }

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/home/adminhome.fxml");
    }

    @FXML
    void delete(ActionEvent event) {
    		Alert alert = new Alert(AlertType.CONFIRMATION) ;
    			alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
    			Optional<ButtonType> optional = alert.showAndWait();
	    		if(optional.get()== ButtonType.OK) {
	    			boolean result=MovieDao.movieDao.��ȭ����(MovieList.select.get��ȭ��ȣ());
	    			if(result) {
	    				Admin_Home.instance.loadpage("/view/AdminView/movie/movielist.fxml");
	    			}
	    		}
    		
    }

    @FXML
    void update(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/movie/movieupdate.fxml");
    }
    
	
    
    
}