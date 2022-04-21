package controller.adminmovie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin_Home;
import dao.MovieDao;
import dto.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class MovieUpdate implements Initializable{
	
	
	
	
	private String mimage =null;
	
	@FXML
    private Button btnimageupdate;

    @FXML
    private TextField txtmtitle;

    @FXML
    private TextField txtmtime;

    @FXML
    private RadioButton grade12;

    @FXML
    private ToggleGroup age;

    @FXML
    private RadioButton grade15;

    @FXML
    private RadioButton gradeadult;

    @FXML
    private RadioButton gradeall;

    @FXML
    private TextField txtprice;

    @FXML
    private Button btnmupdate;

    @FXML
    private Button btnback;

    @FXML
    private ImageView img;
    
    @FXML
    void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/movie/movielist.fxml");
    }

    @FXML
    void imageupdate(ActionEvent event) {
    	
    	FileChooser fileChooser = new FileChooser();
    	
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("�̹�������:image file","*png","*jpg","*jepg","*gif"));
    	
    	File file=fileChooser.showOpenDialog(new Stage());
    	
    	mimage = file.toURI().toString();
    	
    	Image image = new Image(mimage);
    	
    	img.setImage(image);
		
    	
    	try {
    		//1.���� �Է� ��Ʈ��
    		FileInputStream inputStream = new FileInputStream(file); //file: fileChooser ���� ���õ� ���� ��ü inputstream �� �ֱ�
    		
			//2.���� ��� ��Ʈ��
			File copyfile = new File("C:\\Users\\504\\git\\teamproject\\�ڹ�FX_��ȭ��\\src\\img\\"+file.getName()); //���ο� ��� ����
    		FileOutputStream outputStream = new FileOutputStream(copyfile);
    		
    		//3.����Ʈ �迭 ����
    		byte [] bytes = new byte [1024*1024*1024];
    		
    		//4.�ݺ����� �̿��� inputstream�� ���� ��Ʈ�� ��� �о����
    		int size;
    		while(( size =inputStream.read(bytes))>0) {	//�о�� ����Ʈ�� 0���� ������ �ݺ��� ����[ �о�� ����Ʈ�� ���� ����]
    				outputStream.write(bytes, 0 ,size);
    		}
    		//5.����� ū ��� ��� ��Ʈ�� ���� 
    		inputStream.close();
    		outputStream.close();
    		
    		mimage= copyfile.toURI().toString();
		} catch (Exception e) {
			System.out.println("�̹��� ���� ���� ! ��� :controller.MovieAdd "+e);
		}
    }

    @FXML
    void update(ActionEvent event) {
       
    	if(mimage==null) {
    		mimage= MovieList.select.get�̹���();
    	}
    	
    	String acategory = null;
		
		if(grade12.isSelected()) {
			acategory="12�� ������";
		}
		if(grade15.isSelected()) {
			acategory="15�� ������";
		}
		if(gradeadult.isSelected()) {
			acategory="û�ҳ� �����Ұ�";
		}
		if(gradeall.isSelected()) {	
			acategory="��ü ������";
		}
		//��ȭ �޼ҵ� ��üȭ
		Movie updatemovie = new Movie(MovieList.select.get��ȭ��ȣ(),
				txtmtitle.getText(),
				txtmtime.getText(),
				Integer.parseInt(txtprice.getText()),
				acategory,mimage);
		
		boolean result = MovieDao.movieDao.��ȭ���(updatemovie);
		
		if(result) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("��ȭ ���� ���� !!");
			alert.showAndWait();
			Admin_Home.instance.loadpage("/view/AdminView/movie/movielist.fxml");	
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("��ȭ ���� ���� !!");
			alert.showAndWait();
		}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	Movie movie = MovieList.select;
    	
    	txtmtime.setText(movie.get��ȭ����());
    
    }
}
