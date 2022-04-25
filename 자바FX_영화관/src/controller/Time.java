package controller;
import java.net.URL;
import java.util.ResourceBundle;

import dao.InfoDao;
import dao.MovieDao;
import dto.Info;
import dto.Movie;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Time implements Initializable {

    @FXML
    private Button back;

    @FXML
    private Button next;
    
    @FXML
    void btnback(ActionEvent event) {
    	Main.main.loadpage("/view/#2movie.fxml");
    }

    @FXML
    void btnnext(ActionEvent event) {
//    	Main.main.loadpage("/view/#4");
    }

    @FXML
    private TableView<Info> table;
    
    public static Info info;
   
	   public void Infoshow() {
    	
    	ObservableList<Info> infolist = InfoDao.infoDao.Infolist(MovieSelect.select.get영화제목());
    	
    	TableColumn tc = table.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("num"));
    	
    	tc=table.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("movie"));
    	
    	tc=table.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("time"));
    	
    	tc=table.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("name"));
    	
    	tc=table.getColumns().get(4);
    	tc.setCellFactory(new PropertyValueFactory<>("grade"));
    	table.setItems(infolist);
    	
    	table.setOnMouseClicked( e -> {
    		
    		info = table.getSelectionModel().getSelectedItem();
    		
    	});
   
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Infoshow();
		
		
		
	}
	
}