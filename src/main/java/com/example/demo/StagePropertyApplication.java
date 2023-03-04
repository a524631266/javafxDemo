package com.example.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * stage 属性方面可以调节的地方
 */
public class StagePropertyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StagePropertyApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        stage.setTitle("Hello!");
//        stage.setScene(scene);
        // 添加图片
        stage.getIcons().add(new Image("0.jpeg"));
        stage.setHeight(500);
        stage.setWidth(500);
        // 是否全屏
//        stage.setFullScreen(true);
        // 是否最小化
//        stage.setIconified(true);
        // 是否可缩放
//        stage.setResizable(false);
        // 是否最大化
//        stage.setMaximized(true);
        // 监听高度属性变化的属性大小
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });
        // 设置窗口透明度
        stage.setOpacity(0.5);
        // 窗口置顶
        stage.setAlwaysOnTop(true);
        // set x and y of top screen
        stage.setX(200);
        stage.setY(300);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}