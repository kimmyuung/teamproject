package controller.adminmovie;

import java.net.URL;
import java.util.ResourceBundle;
import controller.Admin_Home;
import dao.MovieDao;
import dto.Movie;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovieList implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	public static dto.Movie movie;
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
    	
    }

    @FXML
    void update(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/movie/movieupdate.fxml");
    }
    
	
    
    
}
