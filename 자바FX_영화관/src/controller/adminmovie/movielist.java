package controller.adminmovie;

import controller.admin_home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class movielist {
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
    	
    }

    @FXML
    void back(ActionEvent event) {
    	loadpage("/view/Adminview/adminhome.fxml");
    }

    @FXML
    void delete(ActionEvent event) {
    	
    }

    @FXML
    void update(ActionEvent event) {
    	
    }
    
}
