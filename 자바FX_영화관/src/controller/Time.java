package controller;
import java.net.URL;
import java.util.ResourceBundle;

import dao.InfoDao;
import dto.Info;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Time implements Initializable {

	

    @FXML
    private TableView<Info> table;
    
    public static Info info;
   
	   public void Infoshow() {
    	
    	ObservableList<Info> infolist = InfoDao.infoDao.Infolist();
    	
    	TableColumn tc = table.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("num"));
    	
    	tc=table.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("movie"));
    	
    	tc=table.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("time"));
    	
    	tc=table.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("name"));
    	
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











