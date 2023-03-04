package com.example.demo;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class LayoutApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        AnchorPane ap = new AnchorPane();
//        Button button = new Button("搜索");
//        button.setLayoutX(400);
//        ap.setBackground(new Background(new BackgroundFill(Color.rgb(12,40,60), new CornerRadii(0), new Insets(10))));
//        ap.setPadding(new Insets(10, 10 , 10, 10));

//        AnchorPane.setLeftAnchor(button, 10.0);
//        AnchorPane.setRightAnchor(button, 10.0);
//        AnchorPane.setTopAnchor(button, 10.0);
//        AnchorPane.setBottomAnchor(button, 10.0);
        // 不生效了
//        button.setPrefWidth(100);
//        ap.getChildren().add(button);

//        ap.setStyle("-fx-background-color: #124060;" +
//                "-fx-padding: 10 10 10 10;" +
//                "-fx-arc-width: 1000");
        Scene scene = new Scene(ap);

        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        // 获取主屏幕
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();

        ap.setStyle("-fx-background-color: #FF3E96");
    }

}