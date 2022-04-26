package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;


import dao.MovieDao;
import dao.TicketDao;

import dto.Ticket;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class Check_num implements Initializable{
	
	 
	public static int ����=0;
	public static int û�ҳ�=0;
//	public static int input_value =0;
	public static int button =0;
	static ArrayList<Ticket> ticket = new ArrayList<>();
	
    @FXML
    private ToggleGroup Adult_Num11;

	
	@FXML
    private AnchorPane anchorpane;
    
    @FXML
    private Label lbladult;
    
    @FXML
    private ToggleButton btnadult0;

   
    @FXML
    private ToggleButton btnadult1;

    @FXML
    private ToggleButton btnadult2;

    @FXML
    private ToggleButton btnadult3;

    @FXML
    private ToggleButton btnadult4;
    
    @FXML
    private ToggleButton btnadult5;

    @FXML
    private ToggleButton btnadultex;

    
    @FXML
    private ToggleGroup Adult_Num;

    
    @FXML
    private Label lblyoung;
    
    @FXML
    private ToggleButton btnyoung0;

    
    @FXML
    private ToggleButton btnyoung1;

    @FXML
    private ToggleButton btnyoung2;

    @FXML
    private ToggleButton btnyoung3;

    @FXML
    private ToggleButton btnyoung4;

    @FXML
    private ToggleButton btnyoung5;
    
    @FXML
    private ToggleButton btnyoungex;

    
    @FXML
    private ToggleGroup Young_Num;

    
    
    @FXML
    private Button btnBefore;

    @FXML
    private Button btnNext;

    @FXML
    private ImageView viewimg;

    
    


    @FXML
    void accadult0(ActionEvent event) {
    	boolean isSelected = btnadult0.isSelected();
    	if(isSelected) {
    		���� = 0;
    	}
    	else {
    		���� = 0;
    	}
    }

    @FXML
    void accadult1(ActionEvent event) {
    	boolean isSelected = btnadult1.isSelected();
    	if(isSelected) {
    		���� = 1;
    	}
    	else {
    		���� = 0;
    	}
    
    		
    }

    @FXML
    void accadult2(ActionEvent event) {
    	boolean isSelected = btnadult2.isSelected();
    	if(isSelected) {
    		���� = 2;
    	}
    	else {
    		���� = 0;
    	}
    }

    @FXML
    void accadult3(ActionEvent event) {
    	boolean isSelected = btnadult3.isSelected();
    	if(isSelected) {
    		���� = 3;
    	}
    	else {
    		���� = 0;
    	}
    }

    @FXML
    void accadult4(ActionEvent event) {
    	boolean isSelected = btnadult4.isSelected();
    	if(isSelected) {
    		���� = 4;
    	}
    	else {
    		���� = 0;
    	}
    }

    @FXML
    void accadult5(ActionEvent event) {
    	boolean isSelected = btnadult5.isSelected();
    	if(isSelected) {
    		���� = 5;
		}
    	else {
    		���� = 0;
		}
    }

    @FXML
    void accadultex(ActionEvent event) {
    	button=1;
    	Main.main.popup();
    	
    }

    @FXML
    void accyoung0(ActionEvent event) {
    	boolean isSelected = btnyoung0.isSelected();
    	if(isSelected) {
    		û�ҳ� = 0;
    	}
    	else {
    		û�ҳ� = 0;
    	}
    }

    @FXML
    void accyoung1(ActionEvent event) {
    	
    	boolean isSelected = btnyoung1.isSelected();
    	if(isSelected) {
    		û�ҳ� = 1;
    	}
    	else {
    		û�ҳ� = 0;
    	}
    }

    @FXML
    void accyoung2(ActionEvent event) {
    	boolean isSelected = btnyoung2.isSelected();
    	if(isSelected) {
    		û�ҳ� = 2;
    	}
    	else {
    		û�ҳ� = 0;
    	}
    }
    @FXML
    void accyoung3(ActionEvent event) {
    	boolean isSelected = btnyoung3.isSelected();
    	if(isSelected) {
    		û�ҳ� = 3;
    	}
    	else {
    		û�ҳ� = 0;
    	}
    }
    
    @FXML
    void accyoung4(ActionEvent event) {
    	
    	boolean isSelected = btnyoung4.isSelected();
    	if(isSelected) {
    		û�ҳ� = 4;
    	}
    	else {
    		û�ҳ� = 0;
    	}
    }

    @FXML
    void accyoung5(ActionEvent event) {
    	
    	boolean isSelected = btnyoung5.isSelected();
    	if(isSelected) {
    		û�ҳ� = 5;
    	}
    	else {
    		û�ҳ� = 0;
    	}
    }

    @FXML
    void accyoungex(ActionEvent event) {
    	button=2;
    	Main.main.popup();
    	
    }

  
    
    
	
	
    @FXML
    void accBefore(ActionEvent event) {
    	Alert alert = new Alert( AlertType.INFORMATION );  
		alert.setHeaderText("�ð� ���� �޴��� ���ư��ϴ�.");
		alert.showAndWait();
    	Main.main.loadpage("/view/#3time.fxml");
    }

	@FXML
    void accNext(ActionEvent event) {
		
		Alert alert = new Alert( AlertType.INFORMATION );  
		if(����==0 && û�ҳ�==0) {
    		alert.setHeaderText(" �����Ͻô� �ο� ���� �Է��� �ּ���");
    		alert.showAndWait();
    		
    	}
		else {
			
//			int i=0;
//			
////			int ����_����_���� = MovieDao.movieDao.list().get(i).get����();
//			int ����_����_���� = 8000;
//			int total_num = ����+û�ҳ�;
//			// û�ҳ��� ���� �������� �� 30% ���� ����
//			// int û�ҳ� �������� = ����_����_���� *0.7; 
//			for(i=0;i<total_num;i++)	{
//				TicketDao.ticketDao.Ƽ������(ticket);
//			}
			
			//public Ticket(int ����, String ��ȭ����, int �ο���, String ���̸�, String ��¥, String �¼�) {	
			
			alert.setHeaderText("���� : "+����+" ��,  û�ҳ� : "+û�ҳ�+" �� ���� �ϼ̽��ϴ�");
			alert.showAndWait();
			int total_num= ����+û�ҳ�;
			
			
			
			
			// 1. ȸ������ �޼ҵ� ( �μ� : db�� ���� ���̵�,��й�ȣ,�̸���,�ּ� )
		
			
	    	Main.main.loadpage("/view/#5seat.fxml");
			}
	    	
		
    }

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if (Time.info.get���ɵ��().equals("û�ҳ� �����Ұ�")) {
			lblyoung.setText("û�ҳ��� ������ �� �����ϴ�.");
			
			btnyoung0.setDisable(true);
			btnyoung1.setDisable(true);
			btnyoung2.setDisable(true);
			btnyoung3.setDisable(true);
			btnyoung4.setDisable(true);
			btnyoung5.setDisable(true);
			btnyoungex.setDisable(true);
		}
		
		
	}

}
