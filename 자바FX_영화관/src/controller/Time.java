package controller;
import java.net.URL;
import java.util.ResourceBundle;

import dao.InfoDao;
import dao.MovieDao;
import dto.Info;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Time implements Initializable {

    @FXML
    private AnchorPane anchorpane;

  
    @FXML
    private Button accback;
    
    @FXML
    private Button accnext;

    @FXML
    private ImageView imageview;

    @FXML
    void btnback(ActionEvent event) {
    	Main.main.loadpage("/view/#2movie.fxml");
    }

    @FXML
    void btnnext(ActionEvent event) {
    	Main.main.loadpage("/view/#4people.fxml");
    }
	
	
    static ObservableList<dto.Movie> infolist = MovieDao.movieDao.list(); 

    
    

    @FXML
    private TableView<dto.Movie> table;
    
    public static dto.Movie info;

	public void Infoshow() {
    	
//		ObservableList<dto.Movie> infolist = MovieDao.movieDao.list(); 
//    			InfoDao.infoDao.Infolist(Movie.select.get영화제목());
    	
    	TableColumn tc = table.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("영화번호"));
    	
    	tc=table.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("영화제목"));
    	
    	tc=table.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("러닝타임"));
    	
//    	tc=table.getColumns().get(3);
//    	tc.setCellValueFactory(new PropertyValueFactory<>("name"));
//    	
    	tc=table.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("연령등급"));
    	
    	table.setItems(infolist);
    	
    	table.setOnMouseClicked( e -> {
    		
    		info = table.getSelectionModel().getSelectedItem();

    		
    	});
   
    }
	
	public void Infoimgshow() {
		
//		ObservableList<M>
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Image image = new Image(Movie.select.get이미지().toString());  
		imageview.setImage(image);
		
		Infoshow();
		
		
		
		
	}
	
}











