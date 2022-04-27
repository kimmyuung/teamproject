package controller.admintheater;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Admin_Home;
import dao.InfoDao;
import dao.MovieDao;
import dto.Movie;
import dto.Theater;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class Movietime implements Initializable{
		//알람객체
		Alert alert = new Alert(AlertType.INFORMATION);
		//선택 한 값 저장용
		public static Movie select;
		
		//시간 저장 용
		static String starth;
		static String startm;
		static int h;
		static int m;
		static int hh;
		static int mm;

		//시간 저장 배열
		static ArrayList<String> shour = new ArrayList<>();
		static ArrayList<String> smin = new ArrayList<>();
		static ArrayList<String> time = new ArrayList<>();
		static String str = "";
	
		 
		
		@Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
			
			Theater theater = TheaterList.select;
			lbltname.setText(TheaterList.select.get관이름());
	    	ObservableList<Movie> movielist= MovieDao.movieDao.list();
	    	
	    	//관리자가 선택한 시간 값을 보여줄 정보라벨
	    	lblstarth.setText("");
	    	lblstartm.setText("");
	    	lblendh.setText("");
	    	lblendm.setText("");
	    	lblendhh.setText("");
	    	lblendmm.setText("");
	    	

	    
			//테이블 생성
	    	TableColumn tc = mlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("영화번호"));
			
			tc=mlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("영화제목"));
			
			tc=mlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("연령등급"));
			
			tc=mlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("가격"));
			
			tc=mlist.getColumns().get(4);
			tc.setCellValueFactory(new PropertyValueFactory<>("러닝타임"));
			
			mlist.setItems(movielist);
			 mlist.setOnMouseClicked(e-> {
				 select=mlist.getSelectionModel().getSelectedItem();
				 
			 });
			 
			
			 //초이스박스 값 넣기 (시간 선택)
			 for(int i=0 ; i<24; i++) 	{
				 if(i<10) {
					 timestartbar.getItems().add("0"+Integer.toString(i));
					 
				 }else {
					 timestartbar.getItems().add(Integer.toString(i));
				 }
				 
			
			 }
			 //초이스 박스  값넣기 (분 선택) 
			 for(int j=0; j<12; j++){
				 if(j<2) {
					 timestartbar2.getItems().add("0"+Integer.toString(j*5));
				 }else{
					 timestartbar2.getItems().add(Integer.toString((j*5)));
				 } 
			 }
	
			 
			 
			 //초이스박스 (시간) 단위 이벤트 리스너
			 timestartbar.setOnAction((event)->{
				 lblstarth.setText(timestartbar.getValue());
				 starth=timestartbar.getValue();
				 shour.clear();
				 shour.add(starth);	
				 str = starth +":";
				
				 hh=Integer.parseInt(timestartbar.getValue());
				
				//시간 변환메소드 실행
				endtime();
				
				int hsum=(h+hh);
				int msum=(m+mm);
				int hremain=(hsum-24);
				int mremain=(msum-60);
				if(hsum<10){
					lblendhh.setText(Integer.parseInt("0")+""+hsum);
					lblendh.setText(Integer.parseInt("0")+""+hsum);
				}else {
					lblendh.setText(""+hsum);
					lblendhh.setText(""+hsum);
				}
			
				//60분이 넘어가면 
				if(msum>60) {
					//시간에 +1
					hsum+=1;
					if(hsum<10){
						lblendhh.setText(Integer.parseInt("0")+""+hsum);
						lblendh.setText(Integer.parseInt("0")+""+hsum);
					}else {
						lblendh.setText(""+hsum);
						lblendhh.setText(""+hsum);
					}
				}
				if(hsum>24) {
					if(hremain<10) {
						lblendh.setText(Integer.parseInt("0")+""+hremain);
						lblendhh.setText(Integer.parseInt("0")+""+hremain);
					}else {
						lblendh.setText(hremain+"");
						lblendhh.setText(hremain+"");
					}
				}
			 });
			
			 //초이스박스 (분) 단위 이벤트 리스너
			 timestartbar2.setOnAction((event)->{
				 lblstartm.setText(timestartbar2.getValue());
				 startm=timestartbar2.getValue();
				 smin.clear();
				 smin.add(startm);
				 str += startm;
				 mm=Integer.parseInt(timestartbar2.getValue());
				
				 
				 endtime();
				 
				 int hsum=(h+hh);
				 int msum=(m+mm);
				 int hremain=(hsum-24);
				 int mremain=(msum-60);
				 
				
				if(msum<10) {
					 lblendmm.setText(Integer.parseInt("0")+""+msum);
					 lblendm.setText(Integer.parseInt("0")+""+msum);
				}else {
					 lblendmm.setText(""+msum);
					 lblendm.setText(""+msum);
				}
				if(hsum<10){
					lblendhh.setText(Integer.parseInt("0")+""+hsum);
					lblendh.setText(Integer.parseInt("0")+""+hsum);
				}else {
					lblendh.setText(""+hsum);
					lblendhh.setText(""+hsum);
				}
				 
				 if(msum>60) {
					 hsum+=1;
						if(mremain<10) {
							 lblendmm.setText(Integer.parseInt("0")+""+mremain);
							 lblendm.setText(Integer.parseInt("0")+""+mremain);
						}else {
							 lblendmm.setText(""+mremain);
							 lblendm.setText(""+mremain);
						}
						if(hsum<10){
							lblendhh.setText(Integer.parseInt("0")+""+hsum);
							lblendh.setText(Integer.parseInt("0")+""+hsum);
						}else {
							lblendh.setText(""+hsum);
							lblendhh.setText(""+hsum);
						}
					
				 }
				 if(hsum>24) {
						if(hremain<10) {
							lblendh.setText(Integer.parseInt("0")+""+hremain);
							lblendhh.setText(Integer.parseInt("0")+""+hremain);
						}else {
							lblendh.setText(hremain+"");
							lblendhh.setText(hremain+"");
						}
					 	
					}
				 
			 });
			 //초이스박스 시간/분 단위 합친 값 하나의 배열로 저장
			 time.add(str);
			 	
		}
	    
	
		@FXML
	    private Button btnupdate;

	    @FXML
	    private Button btntback;

	    @FXML
	    private Button btnrmovieadd;

	    @FXML
	    private TableView<Movie> mlist;

	    @FXML
	    private Label lbltname;

	    @FXML
	    private ChoiceBox<String>  timestartbar;
	    
	    @FXML
	    private ChoiceBox<String> timestartbar2;

	    @FXML
	    private Label lblstarth;

	    @FXML
	    private Label lblstartm;

	    @FXML
	    private Label lblendh;

	    @FXML
	    private Label lblendm;
	    
	    @FXML
	    private Label lblendhh;

	    @FXML
	    private Label lblendmm;
	   
	    @FXML
	    void add(ActionEvent event) {
	    	
	 
	    	boolean result =InfoDao.infoDao.시간등록(select.get영화제목(), str, TheaterList.select.get관이름(), select.get연령등급());

	    	if(result) {
	    		alert.setHeaderText("시간등록성공!!");
	    		alert.showAndWait();
	    		Admin_Home.instance.loadpage("/view/AdminView/theater/theatertime.fxml");
	    		
	    	}else {	
	    		alert.setHeaderText("시간등록실패!!");
	    		alert.showAndWait();
	    	}
	    }

	    @FXML
	    void back(ActionEvent event) {
	    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
	    	
	    }	
	    
	    @FXML
	    void listopen(MouseEvent event) {
	    	
	    }

	
    
	    void endtime() {
	    	int runtime= Integer.parseInt(select.get러닝타임());
			
	    	int hour= (runtime/60);
			int min = (runtime%60);
			
			h=hour;
			m=min;

	    }
    
   
    	
    	
    }
    

