package controller.admintheater;

import controller.Admin_Home;
import dto.Theater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TheaterList {
 
	@FXML
    private TableView<Theater> tlist;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnback;

    @FXML
    private Button btnadd50;
    
    @FXML
    private Button btnadd100;

    @FXML
    private Button btnadd150;

    @FXML
    void add50(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theateraddsmall.fxml");
    }

    
    @FXML
    void add100(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theateraddmid.fxml");
    }

    @FXML
    void add150(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theateraddbig.fxml");
    }

    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/home/adminhome.fxml");
    }

    @FXML
    void update(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterupdate.fxml");
    }

}
