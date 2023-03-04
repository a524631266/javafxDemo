package com.example.demo.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioShow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane ap = new AnchorPane();


        HBox hBox = new HBox();

        // 虚拟分组，不是node
        ToggleGroup tg = new ToggleGroup();

        RadioButton rb1 = new RadioButton("rb1");
        RadioButton rb2 = new RadioButton("rb2");
        RadioButton rb3 = new RadioButton("rb3");
        RadioButton rb4 = new RadioButton("rb4");

        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb4.setToggleGroup(tg);

        hBox.getChildren().addAll(rb1, rb2, rb3, rb4);

        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        ap.getChildren().add(hBox);
        //默认选中状态
        Scene scene = new Scene(ap);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();


        // 给radioButton触发事件
        rb1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("rb1 select " + newValue);
        });
        
        // 给分组触发事件
        tg.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton button = (RadioButton) newValue;
            System.out.println("select button" + button.getText());

        });
    }
}
