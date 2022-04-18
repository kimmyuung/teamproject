package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Parent parent = FXMLLoader.load(getClass().getResource("/view/#1main.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		Image image = new Image("/img/영화로고.jpg");
		stage.getIcons().add(image);
		stage.setResizable(false);
		stage.setTitle("영화관");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
