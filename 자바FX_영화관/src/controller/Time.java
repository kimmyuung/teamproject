package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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