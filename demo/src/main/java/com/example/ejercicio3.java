package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ejercicio3 extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        // creamos el pane 
        Pane pane = new Pane();
        pane.setPrefSize(200, 200);
        pane.setStyle("-fx-background: rgba(125, 155, 119, 0.3)");

        // creamos el button 
        Button boton = new Button("click me");
        boton.setStyle("-fx-background: rgba(204, 204, 212, 0.61)");

        // creamos la logica cuando el boton se presione 
        boton.setOnAction(e ->{
            if (boton.getText().equals("click me")){
                boton.setText("jajaja ahora donde estoy");
                pane.setStyle("-fx-background: rgba(88, 194, 243, 0)");
                boton.setTranslateX(Math.random() * (pane.getWidth() - boton.getWidth()));
                boton.setTranslateY(Math.random() * (pane.getHeight() - boton.getHeight()));
            }else{
                boton.setText("click me");
                pane.setStyle("-fx-background: rgba(0, 0, 0, 0.3)");
            }
        });
        pane.getChildren().addAll(boton);

        // pasamos todo a la scena 
        Scene scena = new Scene(pane);

        //pasamos la scena a el stage
        stage.show();
        stage.setScene(scena);
        stage.setTitle("ejemplo numero 3");
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
