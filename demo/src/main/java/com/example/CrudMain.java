package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrudMain extends Application {
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(VIstaCrudAnimal.borderPane(), 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/com/example/Curd.css").toExternalForm());

        stage.setTitle("CRUD de Animales");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}