package controller;

import java.net.URL;
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
	private VBox vbox;
	
	@FXML
    private Button btnback2;

    @FXML
    private Button btnnext2;

    @FXML
    void accback2(ActionEvent event) {
    	Main.main.loadpage("/view/#2movie.fxml");
    }

    void show() {
    	
    	if(vbox.getChildren().isEmpty() == false) {
    		vbox.getChildren().remove(0);
    	}
    	ObservableList<Movie> movielist = FXCollections.observableArrayList();
    	ObservableList<Movie> mlist = MovieDao.movieDao.list();
    	
    	GridPane gridPane = new GridPane();
    		gridPane.setPadding(new Insets(10));
    		gridPane.setHgap(20);
    		gridPane.setVgap(20);
    	int i = 0;
    	for(int row = 0; row < movielist.size()/2; row++) {
    		for(int col = 0; col<2; col++) {
    			ImageView imageView = new ImageView(new Image(mlist.get(i).get이미지()));
    			imageView.setFitWidth(250);
    			imageView.setFitHeight(200);
    			
    		Button button = new Button(null, imageView);
    			button.setId(i+"");
    			button.setOnAction(e -> {
    				
    				int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
    				select = movielist.get(id);
    				Main.main.loadpage("/view/#3time.fxml");
    			});
    			gridPane.add(button, row, col);
    			i++;
    		}
    	}
    	
    }
    
    @FXML
    void accnext2(ActionEvent event) {
    	
//    	MovieDao.movieDao.list();
    	
//    	if(){
    	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setHeaderText("전체 관람 가능 영화를 선택하였습니다.");
        	alert.showAndWait();
//    	}else if(){
//    	Alert alert2 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("12세 이상 관람 가능 영화를 선택하였습니다.");
//    	}else if(){
//    	Alert alert3 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("15세 이상 관람 가능 영화를 선택하였습니다.");
//    	}else if(){
//    	Alert alert4 = new Alert(AlertType.INFORMATION);
//        	alert.setHeaderText("19세 미만은 상영이 불가합니다.");
//    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public static Movie select;
	
	
}