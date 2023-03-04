package com.example.demo;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class AbstractApp  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(initPane());
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.show();
    }

    protected abstract Parent initPane();
}
