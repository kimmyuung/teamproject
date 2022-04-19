package jin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable{
	
	public static Main instance;
	public Main() {
		instance = this;
	}
	
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
	
}
