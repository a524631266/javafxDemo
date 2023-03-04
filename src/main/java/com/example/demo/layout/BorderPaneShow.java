package com.example.demo.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class BorderPaneShow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setWidth(500);
        stage.setHeight(500);
        AnchorPane ap1 = new AnchorPane();
        ap1.setStyle("-fx-background-color: #124060;");
        ap1.setPrefWidth(500);
        ap1.setPrefHeight(100);

        AnchorPane ap2 = new AnchorPane();
        ap2.setPrefWidth(100);
        ap2.setPrefHeight(500);
        ap2.setStyle("-fx-background-color: #b7e527;");

        AnchorPane ap3 = new AnchorPane();
        ap3.setPrefWidth(500);
        ap3.setPrefHeight(100);
        ap3.setStyle("-fx-background-color: #d9e5b4;");

        AnchorPane ap4 = new AnchorPane();
        ap4.setPrefWidth(100);
        ap4.setPrefHeight(500);
        ap4.setStyle("-fx-background-color: #234db6;");

        AnchorPane ap5 = new AnchorPane();
        ap5.setPrefWidth(100);
        ap5.setPrefHeight(500);
        ap5.setStyle("-fx-background-color: #f1a176;");


        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #101111;");
        borderPane.setPadding(new Insets(10));
        borderPane.setRight(ap2);
        borderPane.setTop(ap1);
        borderPane.setBottom(ap3);
        borderPane.setLeft(ap4);
        borderPane.setCenter(ap5);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

}