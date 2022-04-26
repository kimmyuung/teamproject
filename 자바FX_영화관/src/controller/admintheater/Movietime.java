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
		//�˶���ü
		Alert alert = new Alert(AlertType.INFORMATION);
		//���� �� �� �����
		public static Movie select;
		
		//�ð� ���� ��
		static String starth;
		static String startm;
		static int h;
		static int m;
		static int hh;
		static int mm;

		//�ð� ���� �迭
		static ArrayList<String> shour = new ArrayList<>();
		static ArrayList<String> smin = new ArrayList<>();
		static ArrayList<String> time = new ArrayList<>();
		static String str = "";
	
		 
		
		@Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
			
			Theater theater = TheaterList.select;
			lbltname.setText(TheaterList.select.get���̸�());
	    	ObservableList<Movie> movielist= MovieDao.movieDao.list();
	    	
	    	//�����ڰ� ������ �ð� ���� ������ ������
	    	lblstarth.setText("");
	    	lblstartm.setText("");
	    	lblendh.setText("");
	    	lblendm.setText("");
	    	lblendhh.setText("");
	    	lblendmm.setText("");
	    	

	    
			//���̺� ����
	    	TableColumn tc = mlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("��ȭ��ȣ"));
			
			tc=mlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("��ȭ����"));
			
			tc=mlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("���ɵ��"));
			
			tc=mlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("����"));
			
			tc=mlist.getColumns().get(4);
			tc.setCellValueFactory(new PropertyValueFactory<>("����Ÿ��"));
			
			mlist.setItems(movielist);
			 mlist.setOnMouseClicked(e-> {
				 select=mlist.getSelectionModel().getSelectedItem();
				 
			 });
			 
			
			 //���̽��ڽ� �ð� ����
			 for(int i=1 ; i<25; i++) 	{timestartbar.getItems().add(Integer.toString(i));}
			 for(int j=0; j<12; j++) 	{timestartbar2.getItems().add(Integer.toString((j*5)));}
	
			 
			 
			 //���̽��ڽ� (�ð�) ���� �̺�Ʈ ������
			 timestartbar.setOnAction((event)->{
				 lblstarth.setText(timestartbar.getValue());
				 starth=timestartbar.getValue();
				 shour.clear();
				 shour.add(starth);	
				 str = starth +":";
				hh=Integer.parseInt(timestartbar.getValue());
				//�ð� ��ȯ�޼ҵ� ����
				endtime();
				
				int hsum=(h+hh);
				int msum=(m+mm);
				int mremain=(msum-60);
				int hremain=(hsum-24);
				
				lblendhh.setText(hsum+"");
				lblendh.setText(hsum+"");
				lblendmm.setText(msum+"");
				lblendm.setText(msum+"");
				System.out.println(mremain);
				//60���� �Ѿ�� 
				if(msum>60) {
					lblendmm.setText(mremain+"");
					lblendm.setText(mremain+"");
					hsum+=1;
					lblendhh.setText(hsum+"");
					lblendh.setText(hsum+"");
					//�ð��� +1
					if(hsum>24) {
						lblendh.setText(hremain+"");
						lblendhh.setText(hremain+"");
					}
				}
			 });
			 
			 //���̽��ڽ� (��) ���� �̺�Ʈ ������
			 timestartbar2.setOnAction((event)->{
				 lblstartm.setText(timestartbar2.getValue());
				 startm=timestartbar2.getValue();
				 smin.clear();
				 smin.add(startm);
				 str += startm;
				 mm=Integer.parseInt(timestartbar2.getValue());
				 lblendmm.setText((m+mm)+"");
				 lblendm.setText((m+mm)+"");
				 
				 endtime();
					
				 int hsum=(h+hh);
				 int msum=(m+mm);
				 int mremain=(msum-60);
				 int hremain=(hsum-24);
				 
				 if(msum>60) {
					lblendmm.setText(mremain+"");
					lblendm.setText(mremain+"");
					hsum+=1;
					lblendhh.setText(hsum+"");
					lblendh.setText(hsum+"");
					if(hsum>24) {
						lblendh.setText(hremain+"");
						lblendhh.setText(hremain+"");
					}
				 }
				 
				 
			 });
			 //���̽��ڽ� �ð�/�� ���� ��ģ �� �ϳ��� �迭�� ����
			 time.add(str);
			 
			//����Ÿ�� ��Ʈ�� ��ȯ
			
			
			 
			
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
	    	
	    	
	    	boolean result =InfoDao.infoDao.�ð����(select.get��ȭ����(), str, TheaterList.select.get���̸�(), select.get���ɵ��());
	    	
	    	if(result) {
	    		alert.setHeaderText("�ð���ϼ���!!");
	    		alert.showAndWait();
	    		Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
	    	}else {	
	    		alert.setHeaderText("�ð���Ͻ���!!");
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
	    	int runtime= Integer.parseInt(select.get����Ÿ��());
			
	    	int hour= (runtime/60);
			int min = (runtime%60);
			
			
			h=hour;
			m=min;
			
			
			
	    }
    
   
    	
    	
    }
    

