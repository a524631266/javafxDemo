package com.example.demo.layout;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import com.google.common.collect.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * stage 模式区别
 */
public class StackPaneShow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button b1 = new Button("上一页");
        Button b2 = new Button("下一页");
        BorderPane mainPane = new BorderPane();
        List<BorderPane> picList = getGifList("0.jpeg", "d3.gif", "d4.gif");
        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: #f7002d;");
        stackPane.getChildren().addAll(picList);


        HBox hBox = new HBox();
        hBox.getChildren().addAll(b1, b2);
        hBox.setAlignment(Pos.CENTER);
        mainPane.setCenter(stackPane);
        mainPane.setBottom(hBox);
        Scene scene = new Scene(mainPane);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(scene);

        stage.show();

        b1.setOnAction(event -> {

            ObservableList<Node> children = stackPane.getChildren();
            Node remove1 = children.remove(children.size() - 1);
            children.add(0, remove1);
        });

        b2.setOnAction(event -> {

            ObservableList<Node> children = stackPane.getChildren();
            Node remove1 = children.remove(0);
            children.add(children.size(), remove1);
        });
    }

    private List<BorderPane> getGifList(String... picNames) {
        return IntStream.range(0, picNames.length)
                .mapToObj(index -> {
                    String picName = picNames[index];
                    BorderPane borderPane = new BorderPane();
                    borderPane.setStyle("-fx-background-color: #c7de5c;");
                    borderPane.setPrefWidth(300);
                    borderPane.setPrefHeight(300);
                    ImageView imageView = new ImageView(new Image(picName));
                    imageView.setFitWidth(300);
                    imageView.setFitHeight(300);
                    borderPane.setCenter(imageView);

                    Text title = new Text(index + "");

                    title.setFont(Font.font("Helvetica", FontWeight.LIGHT, 30));

                    VBox vBox = new VBox();
                    vBox.getChildren().add(title);
                    vBox.setAlignment(Pos.CENTER);
                    borderPane.setTop(vBox);

                    return borderPane;
                }).collect(Collectors.toList());
    }

}