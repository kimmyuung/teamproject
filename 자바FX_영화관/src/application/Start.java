package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application{
@Override
public void start(Stage stage) throws Exception {
		// 5. �����̳� �ҷ�����
	Parent parent = 
			FXMLLoader.load(getClass().getResource("/view/ahome.fxml"));
	Scene scene = new Scene(parent);
	stage.setScene(scene);
	Image image = new Image ("/img/�ΰ�.png");
	
	stage.getIcons().add(image);
	stage.setResizable(false); // �������� ũ�� ���� �Ұ�
	stage.setTitle("��ȭ�� OGV ����!! "); // �������� ����
	stage.show();
}
public static void main(String[] args) {
	launch(args);
	
}
}
