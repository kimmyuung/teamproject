package jin.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent parent =
				FXMLLoader.load(getClass().getResource("/jin/view/#1_main.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false); // 4. 스테이지 크기 변경 불가 
		stage.setTitle("이젠영화"); // 2.스테이지 창 이름
		stage.show(); // 1. 스테이지 열기
		
	}
	
	
	
	public static void main(String[] args) {
		
		launch(args);
	}
			
			
}
