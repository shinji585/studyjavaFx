package com.example;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class ejemplo4 extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Text text = new Text(40, 40, "Hola mundo");

        text.setFont(new Font(40));
        Scene scene = new Scene(new Group(text));
         
       

        stage.setTitle("welcome to javafx");
        stage.setScene(scene);
        stage.setFullScreen(true);;
        stage.show();

        Button button = new Button("abrir una ventana nueva");

        button.setOnAction(e ->{
            Stage stange2 = new Stage();
            stange2.setTitle("nueva ventana");
            stange2.setWidth(300);
            stange2.setHeight(200);
            stange2.show();
        });

        StackPane root = new StackPane(button);
        stage.setScene(new Scene(root,400,300));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
