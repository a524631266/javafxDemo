package com.example.demo.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class FlowPaneShow extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Button b1 = new Button("按钮文字1");
        Button b2 = new Button("按钮文字2");
        Button b3 = new Button("按钮文字3");
        Button b4 = new Button("按钮文字4");
        Button b5 = new Button("按钮文字5");
        Button b6 = new Button("按钮文字6");

        FlowPane flowPane = new FlowPane();
        FlowPane.setMargin(b1, new Insets(10));
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(20);
        flowPane.setVgap(20);
        flowPane.setOrientation(Orientation.VERTICAL);

        flowPane.getChildren().addAll(b1, b2, b3, b4, b5, b6);
        flowPane.setStyle("-fx-background-color: #101111;");
        Scene scene = new Scene(flowPane);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.show();
    }

}