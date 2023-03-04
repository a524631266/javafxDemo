package com.example.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class StageModelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 默认下有装饰的窗口
        Stage stage1 = new Stage();
        stage1.setTitle("DECORATED");
        stage1.initStyle(StageStyle.DECORATED);
        stage1.show();
//        // 透明窗口没啥用
//        Stage stage2 = new Stage();
//        stage2.setTitle("TRANSPARENT");
//        stage2.initStyle(StageStyle.TRANSPARENT);
//        stage2.show();

//        // 前置空白窗口，没有头装饰的选项
//        Stage stage3 = new Stage();
//        stage3.setTitle("UNDECORATED");
//        stage3.initStyle(StageStyle.UNDECORATED);
//        stage3.show();

        // 非定义的窗口
        Stage stage4 = new Stage();
        stage4.setTitle("UNIFIED");
        stage4.initStyle(StageStyle.UNIFIED);
        stage4.initOwner(stage1);
        // a） 只有当前窗口有一个父级窗口情况下，才能锁定当前窗口。
        stage4.initModality(Modality.WINDOW_MODAL);
        stage4.show();

        // 没有最小化
        Stage stage5 = new Stage();
        stage5.setTitle("UTILITY");
        stage5.initStyle(StageStyle.UTILITY);
        // b）当选中了s5窗口，那么就不能进入其他窗口内部。锁定当前窗口
        stage5.initModality(Modality.APPLICATION_MODAL);
        stage5.show();


    }

    public static void main(String[] args) {
        launch();
    }
}