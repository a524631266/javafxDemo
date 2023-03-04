package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class LayoutMangeVisableOpacity extends Application {
    static Boolean isManaged = true;
    static Boolean isVisable = true;
    static Boolean isOpacity = true;

    @Override
    public void start(Stage stage) throws IOException {

        AnchorPane ap = new AnchorPane();

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        b1.setCursor(Cursor.HAND);
        b2.setCursor(Cursor.HAND);
        b3.setCursor(Cursor.HAND);
        b4.setCursor(Cursor.HAND);


        Button b5 = new Button("b5");
        Button b6 = new Button("b6");
        Button b7 = new Button("b7");

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(b1, b2, b3, b4);
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.BOTTOM_LEFT);

        vBox.getChildren().addAll(b5, b6, b7);

        AnchorPane.setTopAnchor(vBox, 100.0);
        ap.getChildren().addAll(hBox, vBox);


        Scene scene = new Scene(ap);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        // 获取主屏幕
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();


        b5.setOnAction(event -> {
            b3.setManaged(isManaged);
            isManaged = !isManaged;
            b5.setText("set b3 Managed[" + isManaged + "]");
        });
        b6.setOnAction(event -> {
            b3.setVisible(isVisable);
            isVisable = !isVisable;
            b6.setText("set b3 Visable[" + isVisable + "]");
        });

        b7.setOnAction(event -> {
            b3.setOpacity(isOpacity ? 0 : 1);
            isOpacity = !isOpacity;
            b7.setText("set b3 Opacity[" + (isOpacity ? 0 : 1) + "]");
        });


    }

}