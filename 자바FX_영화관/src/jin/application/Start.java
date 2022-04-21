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
		stage.setResizable(false); // 4. �������� ũ�� ���� �Ұ� 
		stage.setTitle("������ȭ"); // 2.�������� â �̸�
		stage.show(); // 1. �������� ����
		
	}
	
	
	
	public static void main(String[] args) {
		
		launch(args);
	}
			
			
}
