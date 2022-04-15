package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class admin_home {
	public static admin_home home;
	void gethome(admin_home home) {
		this.home = home;
	}
	  @FXML
	    private BorderPane borederpane;
	  
	  @FXML
	    private AnchorPane anchorpane;

	    @FXML
	    private Button btnmlist;

	    @FXML
	    private Button btntlist;

	    @FXML
	    private Button btnslist;

	    @FXML
	    void mlist(ActionEvent event) {
	    	loadpage("/view/Adminview/movie/movielist.fxml");
	    }

	    @FXML
	    void slist(ActionEvent event) {
	    	loadpage("/view/Adminview/sales/salescheck.fxml");
	    }

	    @FXML
	    void tlist(ActionEvent event) {
	    	loadpage("/view/Adminview/theater/theaterlist.fxml");
	    }
	    
	    public void loadpage(String page) {
			try {
				Parent parent = FXMLLoader.load(getClass().getResource(page));
				borederpane.setCenter(parent);
				
			}catch(Exception e) {System.out.println(e);}
		}
}
