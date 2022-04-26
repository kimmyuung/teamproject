package controller.admintheater;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Admin_Home;
import dao.TheaterDao;
import dto.Theater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;



//2. �¼��� �پ��� �� ����ŭ �װ� DB�� ����

public class TheaterAdd implements Initializable {
	
	Alert alert = new Alert(AlertType.INFORMATION);	//�˶� ��ü����
	
	public static TheaterAdd theaterAdd = new TheaterAdd();	//�ٸ� Ŭ�������� �������� ��ü����
	
	public static Theater theater;	// �ٸ� Ŭ�������� �������� �ʵ�
	
	static ArrayList<String> cn = new ArrayList<>(); //�¼� ��ǥ ����� �迭

	private static int count;	//�¼� �� ī��Ʈ
	
	static String x; //�¼� ��ǥ ����� ���ڿ�
	
	AnchorPane anchorPane = new AnchorPane();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		seatshow();
		
		
	
	}
	 
	@FXML
	private AnchorPane thpane;
	
    @FXML
    private TextField txttname;

    @FXML
    private Button btntadd;

    @FXML
    private Button btntback;
    
    @FXML
    private Button btnupdate;
   
    //�¼� ����
    @FXML
    public void update(ActionEvent event) {
    	//ī��Ʈ �ǵ�����
    	count=0;
    	//��ũ�κ��� ��ü ����� (�ߺ� ����)
    	thpane.getChildren().clear();
    	//seatshow �ٽ� ����
    	seatshow();
    	//��ȭ�� ���� ��ư Ŭ�� �� �迭 �� ���� ���� ( �ߺ� ���� )
    	cn.clear();
    	
    
    	
    }
    
    //�¼� ���
    @FXML
    public void add(ActionEvent event) {
    	
    	
    	String tname =txttname.getText();  //�ؽ�Ʈ�� �޾ƿ� �� �̸�
    	
    	
    	int tseat = 200 - count; //�¼� �� ī��Ʈ
    	
    	String str="";
    	for(String temp: cn) {  
    		
    		str+=temp+","; // �ɰ��� ���� ���ڿ�(",") ����
    		
    	}
    	
    	//��ȭ�� ��ü ����
    	theater = new Theater(0, tname, Integer.toString(tseat), str ); 
    	//��ȭ�� ����� �迭 �� ���� ���� ( �ߺ� ���� )
    	cn.clear();
    	//��ȭ�� ��� �� �¼� ī��Ʈ �� �ʱ�ȭ
    	count=0;
    	
    	
    	
     
     	boolean result=TheaterDao.theaterDao.�󿵰����(theater);
     	
     	if(result ) {
     		alert.setHeaderText("�󿵰� ��� ���� !!");
			alert.showAndWait();
			Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
			
     	}else {
     		alert.setHeaderText("�󿵰� ��� ���� !!");
			alert.showAndWait();
			
     	}
    }
   
    //�ڷΰ���
    @FXML
    public void back(ActionEvent event) {
    	Admin_Home.instance.loadpage("/view/AdminView/theater/theaterlist.fxml");
    }
    
   
    
   
    
    //�¼� �����ֱ�
    public void seatshow() {
	   	
		   GridPane gridPane = new GridPane();
		   		gridPane.setPadding(new Insets(10));
		   		gridPane.setHgap(10);
		   		gridPane.setVgap(10);
	    	
		   	int i = 0;
	    	
	    	for(int row=0; row<200/20; row++) {
	    		int j=1;
	    		
	    		for(int col=0; col<20; col++) {
	    			
	    			
	    			
	    			ToggleButton button = new ToggleButton();
	    		
	    			button.setPrefWidth(40);
	    			button.setPrefHeight(40);
	    			//�¼� ��ȣ ����
	    			if(row==0) {button.setText("A"+j); 	button.setId("A"+j);}
	    			if(row==1) {button.setText("B"+j); 	button.setId("B"+j);}
	    			if(row==2) {button.setText("C"+j);	button.setId("C"+j);}
	    			if(row==3) {button.setText("D"+j); 	button.setId("D"+j);}
	    			if(row==4) {button.setText("E"+j); 	button.setId("E"+j);}
	    			if(row==5) {button.setText("F"+j); 	button.setId("F"+j);}
	    			if(row==6) {button.setText("G"+j); 	button.setId("G"+j);}
	    			if(row==7) {button.setText("H"+j); 	button.setId("H"+j);}
	    			if(row==8) {button.setText("I"+j); 	button.setId("I"+j);}
	    			if(row==9) {button.setText("J"+j); 	button.setId("J"+j);}
	    	
	    			gridPane.add(button, col, row);
	    			i++;
	    			j++;
	    			
	    			
	    			//��ư Ŭ���� �ش� id�� �Ⱥ��̰� ����
	    			button.setOnMouseClicked(e -> {
		    			x = button.getId();
		    			 
		    			if(button.isSelected()) {
		    				
		    				cn.add(x);
		    				count++;
		    				button.setVisible(false);
		    				
		    				
		    			}
		    		
	    			});	
	    			
	    		}
	    	}		    	
	    	thpane.getChildren().add(gridPane);	
	    	
     }

}
