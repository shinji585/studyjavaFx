package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Lhyperlink extends Application{
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        Hyperlink link = new Hyperlink("visitar google");

         link.setOnAction(e -> getHostServices().showDocument("https://www.google.com"));
         StackPane stackPane = new StackPane();
         stackPane.getChildren().addAll(link);
         Scene scena = new Scene(stackPane);

         stage.setScene(scena);
         stage.show();
         stage.setTitle("hyperlink example");
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
