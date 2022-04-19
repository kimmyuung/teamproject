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
    private TableView<Theater> mlist;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnback;

    @FXML
    void add(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theateradd.fxml");
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
