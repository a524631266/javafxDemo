package com.example.demo.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 显示菜单
 *  配套使用 menubar menu menuitem
 */
public class MenuShow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane ap = new AnchorPane();


        // 给选项设置图标
        ImageView imageView = new ImageView("0.jpeg");
        imageView.setFitWidth(15);
        imageView.setFitHeight(15);

        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-color: #7a6edc");

        Menu menu1 = new Menu("menu1");
        menu1.setGraphic(imageView);
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");
        Menu menu5 = new Menu("menu5");


        MenuItem item1 = new MenuItem("item1", imageView);
        // 设置菜单项快捷键
        item1.setAccelerator(KeyCombination.valueOf("ctrl + alt + k"));
        item1.setOnAction(event -> {
            System.out.println("item1.setOnAction");
        });

        MenuItem item2 = new MenuItem("item2");

        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4");
        MenuItem item5 = new MenuItem("item5");
        menu1.getItems().addAll(item1, item2, item3, menu5);
        menu2.getItems().addAll(item4, item5);

        menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

        ap.getChildren().add(menuBar);
        Scene scene = new Scene(ap);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();

        menuBar.setPrefWidth(500);
        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            menuBar.setPrefWidth(newValue.doubleValue());
        });
    }

}