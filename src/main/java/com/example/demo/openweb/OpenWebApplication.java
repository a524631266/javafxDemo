package com.example.demo.openweb;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 打开浏览器
 */
public class OpenWebApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HostServices hostServices = getHostServices();
        hostServices.showDocument("http://test.zll0428.fun:8443");
//        hostServices.showDocument("https://www.baidu.com");

    }

    public static void main(String[] args) {
        launch();
    }
}