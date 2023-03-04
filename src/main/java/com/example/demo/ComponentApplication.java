package com.example.demo;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * stage 模式区别
 */
public class ComponentApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 获取主屏幕
        stage.setWidth(500);
        stage.setHeight(500);
        Group group = initGroup();
        TextField textField = getTextField();
        Button button = new Button("搜索");
        button.setLayoutX(400);
        group.getChildren().addAll(textField, button, getPassTextField());


        Scene scene = new Scene(group);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        stage.setScene(scene);
        stage.show();
    }

    private TextField getTextField() {
        // 输入框
        TextField textField = new TextField();
        Tooltip toolTip = new Tooltip("鼠标移动上去的提示");
//        textField.setText("默认内容");
        textField.setStyle("-fx-background-color: #f7002d;" +
                "-fx-text-fill: white;");
        textField.setFocusTraversable(false);
        textField.setTooltip(toolTip);
        textField.setPromptText("请输入不超过7个字的长度的内容");
        // a输入文字监听
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 7) {
                textField.setText(oldValue);
            }
        });
        // 选择文字监听
        textField.selectedTextProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("select value: " + newValue);
        });
        textField.setPrefWidth(200);

        // 输入之后按住 enter键触发
        textField.setOnAction(event -> {
            System.out.println("aaaaa");
        });
        return textField;
    }

    private TextField getPassTextField() {
        // 输入框
        PasswordField passwordField = new PasswordField();
        Tooltip toolTip = new Tooltip("鼠标移动上去的提示");
//        textField.setText("默认内容");
        passwordField.setStyle("-fx-background-color: #f7002d;" +
                "-fx-text-fill: white;");
        passwordField.setFocusTraversable(false);
        passwordField.setTooltip(toolTip);
        passwordField.setPromptText("请输入不超过7个字的密码");
        // a输入文字监听
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 7) {
                passwordField.setText(oldValue);
            }
            System.out.println("add password: "+ newValue );
        });
        // 选择文字监听
        passwordField.selectedTextProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("select value: " + newValue);
        });
        passwordField.setPrefWidth(200);
        passwordField.setLayoutX(200);
        return passwordField;
    }

    private Group initGroup() {
        Group group = new Group();
//        group.setAutoSizeChildren(false);
        group.setOpacity(0.5);
        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("" + c.getList().size());
            }
        });
        return group;
    }

}