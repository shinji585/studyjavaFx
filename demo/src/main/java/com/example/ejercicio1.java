package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ejercicio1 extends Application {
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
       Pane pane = new Pane();
       pane.setPrefSize(200, 200);
       pane.setStyle("-fx-background-color:rgb(61, 66, 73)");


       double sceneWidth = 500;
       double sceneHeight = 400;
       // obtenemos el ancho de la scene en x 
      Scene scene = new Scene(pane,sceneWidth,sceneHeight);
       double x = (scene.getWidth() - pane.getWidth())/2;
       double y = (scene.getHeight() - pane.getHeight())/2;
       pane.setLayoutX(x);
       pane.setLayoutY(y);

       // ahora pasamos los valores scene 
       
       stage.show();
       stage.setTitle("ejercicio 1");
       stage.setScene(scene);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
