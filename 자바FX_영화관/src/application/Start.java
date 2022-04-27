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
		// 5. 컨테이너 불러오기
	Parent parent = 
			FXMLLoader.load(getClass().getResource("/view/ahome.fxml"));
	Scene scene = new Scene(parent);
	stage.setScene(scene);
	Image image = new Image ("/img/로고.png");
	
	stage.getIcons().add(image);
	stage.setResizable(false); // 스테이지 크기 변경 불가
	stage.setTitle("영화는 OGV 에서!! "); // 스테이지 열기
	stage.show();
}
public static void main(String[] args) {
	launch(args);
	
}
}
