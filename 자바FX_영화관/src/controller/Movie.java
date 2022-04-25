package controller;


import java.net.URL;
import java.util.ResourceBundle;

import dao.MovieDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Movie implements Initializable {

	public static dto.Movie select;
	
	
	
	
	
    @FXML
    private Button btnnext;

    @FXML
    private VBox vbox;
    @FXML
    private ScrollPane scorllpan;

    @FXML
    void accnext(ActionEvent event) {
    	Main.main.loadpage("/view/#3time.fxml");
    }
	void show() {
		 
	    	if(vbox.getChildren().isEmpty() == false) { // .isEmpty() : �ش� ��ü�� ����ִ��� Ȯ��[vbox �� ����ִ��� Ȯ��]
	    		// vbox�� ��ü�� ������� ������
	    		vbox.getChildren().remove(0); // vbox�� ���� ��ü�� ����;
	    		}
	    	
	    	// 1. ��� ��ǰ ��������
	    			ObservableList<dto.Movie> mlist = MovieDao.movieDao.list();
	    			// 2. �׸��� Ŭ���� [ ��/�� ]
	    			GridPane gridPane = new GridPane();
	    				// * �׸��� ����
	    				gridPane.setPadding( new Insets(10) );
	    				// * �׸��峻 �� ���� 
	    				gridPane.setHgap(20);
	    				gridPane.setHgap(20);

	    			// 3. �ݺ��� 
	    			int i = 0 ; // �ε����� ����
	    			for( int row = 0 ; row < mlist.size()/2  ; row++ ) { // ��
	    				for( int col = 0 ; col<2 ; col++ ) { // ��
	    					
	    					// 1. �̹���

	    					ImageView imageView = new ImageView( new Image(mlist.get(i).get�̹���() ) );
	    						
	    						// *�̹��� ������ 
	    						imageView.setFitWidth(390);		// �̹��� ���α��� 
	    						imageView.setFitHeight(390); 	// �̹��� ���α���
	    					// 2. ��ư ���� ( ��ư�� �̹��� �ֱ� )
	    						Button button = new Button( null , imageView );
	    						// *��ư ������� [ transparent : ����� ]
	    						button.setStyle("-fx-background-color:transparent");
	    						// *��ư id���ֱ� [ ��ǰ �ĺ� = index ]
	    						button.setId( i+"" );
	    						// *��ư Ŭ���̺�Ʈ
	    							//	button.setOnAction( e -> { } ); // ���ٽ� : �μ� -> { �����ڵ� }
	    						button.setOnAction( e -> { 
	    							// 1. Ŭ���� ��ư�� id ��������
	    						
	    							int id = Integer.parseInt(  e.toString().split(",")[0].split("=")[2] );
	    							// 2. Ŭ���� ��ǰ ��ȣ ���� 
	    							select = mlist.get(id);
	    							// 3. ȭ�� ��ȯ
	    							Main.main.loadpage("/view/#3time.fxml");
	    						} );
	    					gridPane.add( button  , col , row); // �׸��峻  �ش� ����ȣ , ���ȣ �� ��ư �߰�
	    					
	    					i++; //�ε��� ����
	    				}
	    			}
	    			
	    			// * 3����� ��������
	    			int row = mlist.size() / 2;		// ��
	    			int remain = mlist.size() % 2 ;	// ���������� ������ 
	    			if( remain != 0  ) { // �������� �����ϸ� 
	    				for( int col = 0 ; col<remain ; col++ ) { // ��
	    						ImageView imageView = new ImageView( new Image(mlist.get(i).get�̹���() ) );
	    						imageView.setFitWidth(150);		// �̹��� ���α��� 
	    						imageView.setFitHeight(150); 	// �̹��� ���α���
	    						Button button = new Button( null , imageView );
	    						button.setStyle("-fx-background-color:transparent");
	    						button.setId( i+"" );
	    						button.setOnAction( e -> { 
	    							int id = Integer.parseInt(  e.toString().split(",")[0].split("=")[2] );
	    							select = mlist.get(id);
	    							Main.main.loadpage("/view/#3time.fxml");
	    						} );	
	    					gridPane.add( button  , col , row+1 ); // �������࿡ �������� ��ŭ ��ư �߰��ؼ� �׸��忡 �߰�
	    					i++; //�ε��� ����
	    				}
	    			}
	    			// 4. vbox�� �׸��� �ֱ� 
	    			vbox.getChildren().add(gridPane);
	 }
	 
	 @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			show();
		}
}
