package com.example.demo.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class GridPaneShow extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Button b1 = new Button("按钮文字1");
        Button b2 = new Button("按钮文字2");
        Button b3 = new Button("按钮文字3");
        Button b4 = new Button("按钮文字4");
        Button b5 = new Button("按钮文字5");
        Button b6 = new Button("按钮文字6");
        Button b7 = new Button("按钮文字7");
        Button b8 = new Button("按钮文字8");

        GridPane gridPane = new GridPane();

        // 方式1
//        gridPane.add(b1, 0, 0);
//        gridPane.add(b2, 1, 0);
        gridPane.add(b3, 2, 0);
        gridPane.add(b4, 3, 0);
        gridPane.add(b5, 0, 1);
        gridPane.add(b6, 1, 1);
        gridPane.add(b7, 2, 1);
        gridPane.add(b8, 3, 1);

        // 方式2
        GridPane.setConstraints(b1, 1, 2);
        gridPane.getChildren().addAll(b1);

        // 方式3
        GridPane.setRowIndex(b2, 2);
        GridPane.setColumnIndex(b2, 2);
        gridPane.getChildren().add(b2);



        Scene scene = new Scene(gridPane);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.show();
    }

}