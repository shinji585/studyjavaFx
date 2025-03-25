package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ejercicio2  extends Application{
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        Button boton = new Button("click me ");
        boton.setPrefSize(100, 50);
        
        
        // creamos un pane y le damos un tamaño 
        Pane pane = new Pane();
        pane.setPrefSize(200, 200);
        pane.setStyle("-fx-background: rgb(99, 134, 104)");
        
        // definimos lo que seria una accion para el button 
        boton.setOnAction(e ->{
              if (boton.getText().equals(("click me"))){
                boton.setText("boton presionado");
                pane.setStyle("-fx-background: rgb(232, 143, 143)");
              }else{
                boton.setText("click me");
                pane.setStyle("-fx-background: rgb(99, 134, 104)");
              }
        });
        // pasamos el botton a lo que seria el pane 
        pane.getChildren().addAll(boton);

        Scene scene = new Scene(pane,500,400);
        pane.setTranslateX((scene.getWidth() - pane.getWidth()) / 2);
        pane.setTranslateY((scene.getHeight() - pane.getHeight()) /2);


        // pasamos todo a el stage 
        stage.show();
        stage.setTitle("ejercicio numero 2");
        stage.setScene(scene);
    }
    public static void main(String[] args) {
        // mostramos la informacion 
        Application.launch(args);
    }
}
