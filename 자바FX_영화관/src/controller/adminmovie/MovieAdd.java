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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert.AlertType;

public class MovieAdd implements Initializable {
	
	//�˶� ��ü ���� ( ���� : �ߺ����)
	
	//���� �̹��� 
	private String mimage =null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
	}
	
	
		
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
	    private Button btnmadd;

	    @FXML
	    private Button btnback;
	   
	    @FXML
	    private ImageView img;
	    
	    @FXML
	    private Label miribogi;

	    @FXML
	    void add(ActionEvent event) {
	    		String mtitle=txtmtitle.getText();
	    		String mtime = txtmtime.getText();
	    		int mprice =  Integer.parseInt(txtprice.getText());
	    		
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
	    		else if(!(grade12.isSelected() || grade15.isSelected() || gradeadult.isSelected() || gradeall.isSelected())) {
	    			Alert alert = new Alert(AlertType.ERROR);
	    			alert.setHeaderText("��ȭ ����� �����ؾ� �մϴ� !!");
	    			alert.showAndWait();
	    		}
	    		//��ȭ �޼ҵ� ��üȭ
	    		Movie movie = new Movie(mtitle, mtime, mprice, acategory, mimage);
	    		
	    		boolean result = MovieDao.movieDao.��ȭ���(movie);
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		if(result) {
	    			
	    			alert.setHeaderText("��ȭ ��� ���� !!");
	    			alert.showAndWait();
	    			Admin_Home.instance.loadpage("/view/AdminView/movie/movielist.fxml");	
	    		}else {
	    			alert.setHeaderText("��ȭ ��� ���� !!");
					alert.showAndWait();
	    		}
	    
	    }

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
	    	miribogi.setText("");
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
	
}
