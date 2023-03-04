package com.example.demo.layout;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

/**
 * stage 模式区别
 */
public class DialogPaneShow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button b1 = new Button("click open dialog");

        AnchorPane ap = new AnchorPane();
        AnchorPane.setTopAnchor(b1, 100.0);
        AnchorPane.setLeftAnchor(b1, 100.0);

        ap.getChildren().add(b1);
        Scene scene = new Scene(ap);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setScene(scene);
        stage.show();

        b1.setOnAction(event -> {
            DialogPane dialogPane = new DialogPane();
            // 设置头
            dialogPane.setHeaderText("这是一个对话框");
            // 设置内容
            Node node = new ImageView("d3.gif");
            dialogPane.setContent(node);
            // 设置按钮
            dialogPane.getButtonTypes().add(ButtonType.APPLY);
            dialogPane.getButtonTypes().add(ButtonType.CANCEL);
            // 设置右上角的图标
            ImageView imageView = new ImageView("0.jpeg");
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
            dialogPane.setGraphic(imageView);
            // 设置扩展内容 ,显示详细信息
            dialogPane.setExpandableContent(new Text("expandable content"));


            Scene s1 = new Scene(dialogPane);
            s1.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage innerStage = new Stage();
            innerStage.setScene(s1);
            innerStage.initOwner(stage);
            innerStage.initModality(Modality.WINDOW_MODAL);
            innerStage.initStyle(StageStyle.UNDECORATED);

            // 禁止拉伸
            innerStage.setResizable(false);
            innerStage.show();


            // 获取应用按钮并设置事件
            Button applyButton = (Button) dialogPane.lookupButton(ButtonType.APPLY);

            applyButton.setOnAction(event1 -> {
                innerStage.close();
            });
            Button cancelButton = (Button) dialogPane.lookupButton(ButtonType.CANCEL);
            cancelButton.setOnAction(event1 -> {
                stage.close();
            });

            // 调度任务
            MySchedule schedule = new MySchedule(innerStage, dialogPane);
            schedule.setPeriod(Duration.millis(1000));
            schedule.start();
        });
    }

}

class MySchedule extends ScheduledService<Integer> {
    int count = 0;
    final Stage stage;
    final DialogPane dialogPane;

    MySchedule(Stage stage, DialogPane dialogPane) {
        this.stage = stage;
        this.dialogPane = dialogPane;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                System.out.println("call: " + Thread.currentThread().getName());
                return count++;
            }

            @Override
            protected void updateValue(Integer value) {
                System.out.println("updateValue: " + Thread.currentThread().getName() + ",value:" + value);
                dialogPane.setHeaderText(value + ":aaa");
                if (value == 10) {
                    stage.close();
                    MySchedule.this.cancel();
                }
            }
        };
    }
}