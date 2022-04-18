package controller.adminmovie;

import java.net.URL;
import java.util.ResourceBundle;
import controller.Admin_Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class MovieList implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	
	}
	
	@FXML
    private TableView<?> mlist;

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
