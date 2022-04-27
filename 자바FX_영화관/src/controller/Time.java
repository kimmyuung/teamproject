package controller;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.text.DateFormatter;

import controller.admintheater.Runmovieadd;
import dao.InfoDao;
import dao.MovieDao;
import dto.Info;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Time implements Initializable {

    @FXML
    private MediaView miediaview;
	
    @FXML
    private Button back;

    @FXML
    private Button next;
    
    @FXML
    private ImageView imageview;
    
    @FXML
    void btnback(ActionEvent event) {
    	Main.main.loadpage("/view/#2movie.fxml");
    }

    @FXML
    void btnnext(ActionEvent event) {
//    	Main.main.loadpage("/view/#4");
    }
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TableView<Info> table;
    
    public static Info info;
    public static Date[] date;

	public void Infoshow() {
    	
    	ObservableList<Info> infolist = InfoDao.infoDao.Infolist();
    	
    	TableColumn tc = table.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("num"));
    	
    	tc=table.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("movie"));
    	
    	tc=table.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("time"));
    	
    	tc=table.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("name"));
    	
    	tc=table.getColumns().get(4);
    	tc.setCellValueFactory(new PropertyValueFactory<>("grade"));
    	
    	table.setItems(infolist);
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // 원하는 시간
    	
    	Date now = new Date(); // 현재 날짜와 시간을 나타냄
    	//for(String)
    	
    	table.setOnMouseClicked( e -> {
    		
    		info = table.getSelectionModel().getSelectedItem();
    		
    		String str = InfoDao.infoDao.time(); //상영 시작 시간
    			
        		String[] cut = info.getTime().split(":");  // 영화 시작 시간들을 쪼갬
        		String nowTime = sdf.format(now); // 지금 시간을 표시형식 변경
				String[] now_intime = nowTime.split(":"); // 지금 시간 시간과 분으로 쪼갬
				int nowtime_hour = Integer.parseInt(now_intime[0]); 
				int nowtime_min = Integer.parseInt(now_intime[1]);
				int intime_hour = Integer.parseInt(cut[0]);
				int intime_min = Integer.parseInt(cut[1]);
				
				
        		
				int runtime_min = Integer.parseInt(Movie.select.get러닝타임()); 
				int outhour = intime_hour;
				int outmin = (intime_min+runtime_min); // 러닝타임
				for(int j = 0; j < outmin/60; j++)
				if(outmin / 60 > 1) {
					outmin -= 60;
					outhour += 1;
				}
				/////if 영화상영시간이 현재시간에 포함되어있으면
				
				if(nowtime_hour >= outhour || nowtime_hour == outhour && nowtime_min<outmin) {
					System.out.print("상영종료");
					// 알람
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("상영이 종료되었습니다. 다른 영화를 예매해 주세요");
					alert.showAndWait();
				}
				else if(nowtime_hour >= intime_hour || nowtime_hour == outhour && nowtime_min<outmin) {
					System.out.print("상영중");
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("상영 중입니다. 다른 영화를 예매해 주세요");
					alert.showAndWait();
				}
				else {
//					System.out.print("예약가능");
					Main.main.loadpage("/view/#4people.fxml");
				}
				
        		

    	});
    	
    }
	
	public void Infoimgshow() {
		
//		ObservableList<M>
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Media media = new Media(getClass().getResource("/img/비디오2.mp4").toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		miediaview.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			
			@Override
			public void run() {
				mediaPlayer.seek(Duration.ZERO);
				
			}
		});
		
		Image image = new Image(Movie.select.get이미지().toString());  
		imageview.setImage(image);
		
		Infoshow();
		
	}
	
}











