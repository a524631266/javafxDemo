package com.example.demo;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class PlatformUtilApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // start out :JavaFX Application Thread
        System.out.println("start out :" + Thread.currentThread().getName());
        // 初始化 stage之后的一个操作。 与 start公用一个线程，非多线程，而是一个队列去消费了
        Platform.runLater(() -> {
            // start run later :JavaFX Application Thread
            System.out.println("start run later :" + Thread.currentThread().getName());
        });
        System.out.println("gogogogo ");


        // 是否支持3D效果 . true 表示支持
        System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
        System.out.println(Platform.isSupported(ConditionalFeature.FXML));



    }

    public static void main(String[] args) {
        launch();
    }
}