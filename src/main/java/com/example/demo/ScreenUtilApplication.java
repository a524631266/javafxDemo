package com.example.demo;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class ScreenUtilApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 获取主屏幕
        Screen primaryScreen = Screen.getPrimary();
        Rectangle2D bounds = primaryScreen.getBounds();
        Rectangle2D visualBounds = primaryScreen.getVisualBounds();

        System.out.println("minx: " + bounds.getMinX() + ", maxX:" + bounds.getMaxX());
        System.out.println("miny: " + bounds.getMinY() + ", maxX:" + bounds.getMaxY());
        System.out.println("width : " + bounds.getWidth() + ", height:" + bounds.getHeight());

        // dpi 每英寸长度内的像素点数
        System.out.println("dpi 是什么：" + primaryScreen.getDpi());
    }

    public static void main(String[] args) {
        launch();
    }
}