package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Admin_Start extends Application{
@Override
public void start(Stage stage) throws Exception {
		// 5. �����̳� �ҷ�����
	Parent parent = 
			FXMLLoader.load(getClass().getResource("/view/ahome.fxml"));
	Scene scene = new Scene(parent);
	stage.setScene(scene);
	
		
	stage.setResizable(false); // �������� ũ�� ���� �Ұ�
	stage.setTitle("������ȭ"); // �������� ����
	stage.show();
}
public static void main(String[] args) {
	launch(args);
	
}
}
