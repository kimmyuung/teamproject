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
    	
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("이미지파일:image file","*png","*jpg","*jepg","*gif"));
    	
    	File file=fileChooser.showOpenDialog(new Stage());
    	
    	mimage = file.toURI().toString();
    	
    	Image image = new Image(mimage);
    	
    	img.setImage(image);
		
    	
    	try {
    		//1.파일 입력 스트림
    		FileInputStream inputStream = new FileInputStream(file); //file: fileChooser 에서 선택된 파일 객체 inputstream 에 넣기
    		
			//2.파일 출력 스트림
			File copyfile = new File("C:\\Users\\504\\git\\teamproject\\자바FX_영화관\\src\\img\\"+file.getName()); //새로운 경로 설정
    		FileOutputStream outputStream = new FileOutputStream(copyfile);
    		
    		//3.바이트 배열 서언
    		byte [] bytes = new byte [1024*1024*1024];
    		
    		//4.반복문을 이용한 inputstream의 파일 스트림 모두 읽어오기
    		int size;
    		while(( size =inputStream.read(bytes))>0) {	//읽어온 바이트가 0보다 작으면 반복문 종료[ 읽어올 바이트가 없기 때문]
    				outputStream.write(bytes, 0 ,size);
    		}
    		//5.용랑이 큰 경우 대비 스트림 종료 
    		inputStream.close();
    		outputStream.close();
    		
    		mimage= copyfile.toURI().toString();
		} catch (Exception e) {
			System.out.println("이미지 저장 실패 ! 경로 :controller.MovieAdd "+e);
		}
    }

    @FXML
    void update(ActionEvent event) {
       
    	if(mimage==null) {
    		mimage= MovieList.select.get이미지();
    	}
    	
    	String acategory = null;
		
		if(grade12.isSelected()) {
			acategory="12세 관람가";
		}
		if(grade15.isSelected()) {
			acategory="15세 관람가";
		}
		if(gradeadult.isSelected()) {
			acategory="청소년 관람불가";
		}
		if(gradeall.isSelected()) {	
			acategory="전체 관람가";
		}
		//영화 메소드 객체화
		Movie updatemovie = new Movie(MovieList.select.get영화번호(),
				txtmtitle.getText(),
				txtmtime.getText(),
				Integer.parseInt(txtprice.getText()),
				acategory,mimage);
		
		boolean result = MovieDao.movieDao.영화수정(updatemovie);
		
		if(result) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("영화 수정 성공 !!");
			alert.showAndWait();
			Admin_Home.instance.loadpage("/view/AdminView/movie/movielist.fxml");	
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("영화 수정 실패 !!");
			alert.showAndWait();
		}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	Movie movie = MovieList.select;
    	
    	txtmtime.setText(movie.get영화제목());
    
    }
}
