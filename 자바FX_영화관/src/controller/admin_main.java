package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class admin_main implements Initializable{
	
	public static admin_main instance;
	public admin_main() {
		instance = this;
	}
	  @FXML private BorderPane mainborderpane;
	  
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	System.out.println("Main �䰡 ����Ǿ����ϴ�.");
	loadpage("/view/Adminview/home/adminhome.fxml");
}
public void loadpage(String page) {// ���� ��θ� �μ��� ����
	try {
		// ������(fxml) ��üȭ
	Parent parent = FXMLLoader.load(getClass().getResource(page)); // �ش� ���� �ҷ�����
	mainborderpane.setCenter(parent); // main.fxml�� �����ϴ� borderpane��ü�� center�� �ش� ���Ϸ� ����
	// �����̳� ����� �ٸ� ������ �ֱ�
	}catch(Exception e) {System.out.println("������ ���� ����!" + e);}
}
}
