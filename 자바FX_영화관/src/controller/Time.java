package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import dao.MovieDao;
import dto.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Time implements Initializable {


    @FXML
    private Button btnnext2;

    @FXML
    void accback2(ActionEvent event) {
    	Main.main.loadpage("/view/#2movie.fxml");
    }


    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}