package com.example.demo.menu;

import com.example.demo.AbstractApp;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * 多行文本
 * 1、特征 多行之后会有滚动条
 */
public class TextAreaShow extends AbstractApp {

    @Override
    protected Parent initPane() {
        AnchorPane ap = new AnchorPane();
        VBox vBox = new VBox();
        TextField textField = new TextField();
        TextArea textArea = new TextArea();

//        textArea.setTextFormatter(new TextFormatter<String>(a -> {
////            a.getText()
//            // 过滤掉数字1-9的输入
//            if(a.getText().matches("[1-9]")) {
//                return null;
//            }
//            return a;
//        }));
        textArea.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                System.out.println("to:" + object);
                return object;
            }

            @Override
            public String fromString(String string) {
                System.out.println("from:" + string);
                return string.replace("1", "壹");
            }
        }));


        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            textArea.commitValue();
        });
        ap.getChildren().add(textArea);



        return ap;
    }
}
