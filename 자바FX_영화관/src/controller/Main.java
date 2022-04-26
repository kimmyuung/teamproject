package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {

	public static Main main;
	public Main(){
		main = this;
	}
	
	@FXML
    private BorderPane borderpane;
	
	@FXML
    private AnchorPane anpane; // fx:id 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/#2movie.fxml");
	}
	
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		}catch (Exception e) {System.out.println("������ �ҷ����� ����" + e);}
	}
	
	public void loadpage2( String page ) { // loadpage( ���ϰ�� ) 
		try { // ����ó�� 
			Parent parent = FXMLLoader.load( getClass().getResource(page)); // �ش� ���� �ҷ����� 
			anpane.setClip(parent);
			
		}catch( Exception e ) { System.out.println("������ �ҷ����� ���� ����: "+ e);} // ���࿡ ������ �������� ������ ���� �߻� 
		
	}
	
	
}
