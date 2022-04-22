package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class test1 extends Application {
    Label label;
    ToggleGroup group;
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) throws Exception {
        label = new Label("This is JavaFX!");
        group = new ToggleGroup();
        ToggleButton btn1 = new ToggleButton("Male");
        btn1.setToggleGroup(group);
     //   btn1.setSelected(true);
        ToggleButton btn2 = new ToggleButton("Female");
        btn2.setToggleGroup(group);
        btn1.setOnAction((ActionEvent)->{
            label.setText("you are Male?");
        });
        btn2.setOnAction((ActionEvent)->{
            label.setText("you are Female?");
        });
         
        BorderPane pane = new BorderPane();
        pane.setTop(label);
        FlowPane flow = new FlowPane();
        flow.getChildren().add(btn1);
        flow.getChildren().add(btn2);
        pane.setCenter(flow);
        Scene scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
 
}