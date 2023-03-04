package com.example.demo.layout;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CheckButtonShow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane ap = new AnchorPane();

        HBox hBox = new HBox();

        CheckBox cb1 = new CheckBox("cb1");
        CheckBox cb2 = new CheckBox("cb2");
        CheckBox cb3 = new CheckBox("cb3");

        // 不确定状态设置， 但是只有初始的时候是不确定的，最后只有两种状态 一个是可选择☑️，一个是不可选择
        cb1.setIndeterminate(true);

        // 运行不确定状态 可以点击三种状态
        cb2.setAllowIndeterminate(true);

        hBox.getChildren().addAll(cb1, cb2, cb3);

        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        ap.getChildren().add(hBox);
        //默认选中状态
        Scene scene = new Scene(ap);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
        ap.addEventFilter(MouseEvent.MOUSE_CLICKED, a -> {
            ObservableList<Node> children = hBox.getChildren();
            children.stream().forEach(b -> {
                CheckBox c = (CheckBox) b;
                System.out.println(c.getText() + " 选择状态: "+ c.isSelected() + ", 不确定状态" + c.isIndeterminate());
            });
        });
    }
}
