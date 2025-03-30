package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComidaRapida extends Application {

    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        // creamos un label 
        Label label = new Label("Seleccione el tipo de comidad a pedir");

        // creamos el comboBox
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("comida disponible");
        comboBox.getItems().addAll("Hamburguesa", "Pizza", "Ensalada", "Pasta");
        
        // creamos los actores de la accion 
        Label label2 = new Label();
        Button seleccionar = new Button("confirmar seleccion");

       // creamos la accion para el button
       seleccionar.setOnAction( e -> {
         if (comboBox.getValue() != null){
            label2.setText("has seleccionado: " + comboBox.getValue());
         }else{
            label2.setText("usted no ha seleccionado nada");
         }
       });

       // creamos el vbox 
       VBox vbox = new VBox(10,label,comboBox,seleccionar,label2);
       vbox.setAlignment(Pos.CENTER);

       Scene scene = new Scene(vbox,300,250);

       stage.setScene(scene);
       stage.setTitle("Lista de comida disponible");
       stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}