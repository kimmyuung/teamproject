package controller.admintheater;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
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
import javafx.scene.layout.AnchorPane;

public class Movietime implements Initializable{
	
	Alert alert = new Alert(AlertType.INFORMATION);
	public static Movie movie;

	  
	 @FXML
	    private Button btnupdate;

	    @FXML
	    private Button btntback;

	    @FXML
	    private Button btnrmovieadd;

	    @FXML
	    private TableView<?> mlist;

	    @FXML
	    private Label lbltname;

	    @FXML
	    private ChoiceBox<?> timebar;

	    @FXML
	    void add(ActionEvent event) {

	    }

	    @FXML
	    void back(ActionEvent event) {

	    }

	    @FXML
	    void listopen(MouseEvent event) {

	    }

	    @FXML
	    void update(ActionEvent event) {

	    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
   
    	
    }
    
    
   
    	
    	
    }
    

