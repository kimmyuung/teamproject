package controller.adminmovie;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MovieAdd implements Initializable {
	 	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
	}
	
	    @FXML
	    private Button btnimageupdate;

	    @FXML
	    private TextField txtmtitle;

	    @FXML
	    private TextField txtmtime;

	    @FXML
	    private RadioButton grade12;

	    @FXML
	    private ToggleGroup age;

	    @FXML
	    private RadioButton grade15;

	    @FXML
	    private RadioButton gradeadult;

	    @FXML
	    private RadioButton gradeall;

	    @FXML
	    private TextField txtprice;

	    @FXML
	    private Button btnmadd;

	    @FXML
	    private Button btnback;

	    @FXML
	    void add(ActionEvent event) {

	    }

	    @FXML
	    void back(ActionEvent event) {
	    	Admin_Home.instance.loadpage("/view/AdminView/movie/movielist.fxml");
	    }

	    @FXML
	    void imageupdate(ActionEvent event) {

	    }	
	
}
