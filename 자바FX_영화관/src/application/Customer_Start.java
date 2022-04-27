package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Customer_Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Parent parent = FXMLLoader.load(getClass().getResource("/view/#1main.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		Image image = new Image("/img/cgv.png");
		stage.getIcons().add(image);
		stage.setResizable(false);
		stage.setTitle("영화관");
		stage.show();	
		// * 외부폰트 설정
			// 1. 폰트 로드
			Font.loadFont( getClass().getResourceAsStream("SANGJU Gotgam.ttf"), 15);
			// 2. 현대 scene에 외부 스타일시트 적용
			scene.getStylesheets().add( getClass().getResource("application.css").toExternalForm() );
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
