package Controller.movielist;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class Mlist implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
	    void add(ActionEvent event) {
	    //	loadpage("/AdminView/movie/movieadd.fxml);
	    }

	    @FXML
	    void delete(ActionEvent event) {
       
	    }

	    @FXML
	    void update(ActionEvent event) {
	    //	loadpage("/AdminView/movie/movieupdate.fxml);
	    }

	
	
	
}
