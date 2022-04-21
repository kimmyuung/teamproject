package jin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import jin.application.Start;

public class Main implements Initializable{
	
	public static Main instance;
	public Main() {
		instance = this;
	}
	Stage window;
    Scene scene;
    Button button;
	@FXML
	private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		loadpage("/jin/view/#4_�ο�����.fxml");
		
	}
	public void loadpage( String page ) { // loadpage( ���ϰ�� ) 
		try { // ����ó�� 
			
			Parent parent = FXMLLoader.load( getClass().getResource(page));
			// main.fxml�� �����ϴ� borderpane��ü�� center�� �ش� ���Ϸ� ����
			borderpane.setCenter(parent);
			
		}catch( Exception e ) { System.out.println("������ �ҷ����� ���� ����: "+ e);} // ���࿡ ������ �������� ������ ���� �߻� 
	
	}
	
	public void popup() { // ��â ����
		
		  try{
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/jin/view/�ο����Է�.fxml"));
		    Parent root = (Parent) loader.load();
		    Stage stage = new Stage();
		    stage.setTitle("���� �ο� �� �Է�");
		    stage.setScene(new Scene(root));
		    stage.show();
		  }catch(Exception e) {
		  
		  }
	}
	
}
