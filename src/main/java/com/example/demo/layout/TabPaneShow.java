package com.example.demo.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneShow  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("tab1");
        Tab tab2 = new Tab("tab2");
        Tab tab3 = new Tab("tab3");
        // tab1 不可关闭
        tab1.setClosable(false);

        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: #f508e8");
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        hBox.getChildren().addAll(new Button("but1"), new Button("but2"));

        tab1.setContent(hBox);

        // 设置图标
        ImageView imageView = new ImageView("d3.gif");
        imageView.setFitHeight(15);
        imageView.setFitWidth(15);
        tab1.setGraphic(imageView);


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        vBox.getChildren().addAll(new Button("but1"), new Button("but2"));
        tab2.setContent(vBox);

        // 禁用
        tab3.setDisable(true);


        tabPane.getTabs().addAll(tab1, tab2, tab3);
        //默认选中状态
        tabPane.getSelectionModel().select(tab2);
        Scene scene = new Scene(tabPane);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();

        // 添加监听
        tabPane.selectionModelProperty().addListener((observable, oldValue, newValue) -> {
            Tab selectedItem = newValue.getSelectedItem();
            System.out.println(selectedItem.getText());
        });

        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue.getText());
        });
    }
}
