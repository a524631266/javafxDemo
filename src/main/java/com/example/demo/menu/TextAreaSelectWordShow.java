package com.example.demo.menu;

import com.example.demo.AbstractApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;

/**
 * 多行文本
 * 1、特征 多行之后会有滚动条
 */
public class TextAreaSelectWordShow extends AbstractApp {

    @Override
    protected Parent initPane() {
        AnchorPane ap = new AnchorPane();
        VBox vBox = new VBox();

        HBox hBox = new HBox();
        TextField textField = new TextField();
        hBox.setSpacing(10);
        Button findButton = new Button("find");
        hBox.getChildren().addAll(textField, findButton);

        TextArea textArea = new TextArea();
        Button openFile = new Button("openFile");
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setStyle("-fx-font-family: 'serif'");
        vBox.getChildren().addAll(hBox, textArea, openFile, colorPicker);



        // buttonBar
        ButtonBar buttonBar = new ButtonBar();
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        buttonBar.getButtons().addAll(b1, b2, b3, b4);
        ap.getChildren().addAll(vBox, buttonBar);
        findButton.setOnAction(new EventHandler<ActionEvent>() {
            int startIndex = 0;
            @Override
            public void handle(ActionEvent event) {
                String searchText = textField.getText();
                String input = textArea.getText();
                int subIndex = input.substring(startIndex).indexOf(searchText);
                // 查找
                if(subIndex < 0) {
                    startIndex = 0;
                    textArea.positionCaret(1);
                    return;
                }
                startIndex = startIndex + subIndex;
                textArea.selectRange(startIndex, startIndex + searchText.length());
                startIndex ++;
            }
        });
        openFile.setOnAction(event -> {
            Stage window=new Stage();
            FileChooser fc=new FileChooser();
            File sf=fc.showOpenDialog(window);
            String name = sf.getName();
            System.out.println("choose file name: " + name);
        });
        return ap;
    }
}
