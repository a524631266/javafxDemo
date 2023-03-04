package com.example.demo;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.ListChangeListener;
import javafx.collections.WeakListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * stage 模式区别
 */
public class NodeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 获取主屏幕
        stage.setWidth(500);
        stage.setHeight(500);
        Group group = new Group();
        Button button = new Button();
        button.setPrefWidth(200);
        button.setPrefHeight(300);
        button.setText("按钮");

        // 方式2
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                visitOwnBlogWeb();
//                addAnButtonIntoGroup(group);
                if (event.getClickCount() == 2) {

                    System.out.println("双击" + event.getButton().name());
                }
            }
        });

        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // a 可以识别大写A还是小写a
                System.out.println(event.getText());
                // A 全部大写
                System.out.println(event.getCode().getName());
                System.out.println(KeyCode.A.getName());
            }
        });

        // 方式1
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                visitOwnBlogWeb();
//                addAnButtonIntoGroup(group);
                Button source = (Button) event.getSource();
                System.out.println("这是按钮文字: " + source.getText());
            }
        });

        // 添加背景色
        BackgroundFill fill = new BackgroundFill(
                Paint.valueOf("#191970"), // 背景色 50表示 透明度50%
                new CornerRadii(20), // 圆角
                new Insets(10, 15, 20 ,30) // 内边距
                );
        Background bgd = new Background(fill);
        button.setBackground(bgd);

        // 添加边框
        Border border = new Border(new BorderStroke(
                Paint.valueOf("#808080"),
                BorderStrokeStyle.DASHED,
                new CornerRadii(10),
                BorderStroke.THICK
        ));
        button.setBorder(border);


//        button.setTextFill(Paint.valueOf("#ffff00"));// yellow
        button.setStyle("-fx-text-fill:#ffff00");
        // hand 手的图标
//        button.setCursor(Cursor.HAND);
        // 自定义鼠标标志。获取当前
//        URL resource = getClass().getClassLoader().getResource("0.jpeg");
//        Cursor cursor = Cursor.cursor(resource.toExternalForm());
        Image image = new Image("0.jpeg");
//        image.heightProperty().
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Image image1 = imageView.getImage();
        ImageCursor cursor1 = new ImageCursor(image1,
                0,
                0);
        Dimension2D bestSize = ImageCursor.getBestSize(10, 10);

        button.setCursor(cursor1);



        // 向node中添加一个node
        group.getChildren().add(button);
//        group.setAutoSizeChildren(false);
        group.setOpacity(0.5);


        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("" +  c.getList().size());
            }
        });
        Scene scene = new Scene(group);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        // 快捷键设置
        KeyCodeCombination keyBind = new KeyCodeCombination(KeyCode.K, KeyCombination.CONTROL_DOWN);
        scene.getAccelerators().put(keyBind, () -> {

            System.out.println("aaa");
        });
        stage.setScene(scene);
        stage.show();
    }

    private void visitOwnBlogWeb() {
        HostServices hostServices = getHostServices();
        hostServices.showDocument("http://test.zll0428.fun:8443");
    }
    public void addAnButtonIntoGroup(Group group){
        Button button = new Button();
        button.setPrefWidth(200);
        button.setPrefHeight(100);
        button.setLayoutX(100);
        button.setLayoutY(200);
        button.setText("new button");
//        button.setFont(Font.font("sans-serif", 40 ));
        button.setFont(Font.font("sans-serif", 5 ));

        group.getChildren().add(button);
    }
}