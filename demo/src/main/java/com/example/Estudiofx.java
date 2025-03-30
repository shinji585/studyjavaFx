package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Estudiofx extends Application{
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception{
        Label label = new Label("ingrese su nombre");
        TextField textField = new TextField();
        
        Button button = new Button("enviar nombre");

        // mostramos lo que seria una informacion
        button.setOnAction(e ->{
            String nombre = textField.getText();

            label.setText("el texto ingresado es: " + nombre);
        });
        // le damos diseño 
        button.setStyle("-fx-background-color: rgb(108, 108, 140)");
        button.setPadding(new Insets(2.5));
        button.setPrefSize(100, 50);

        // creamos el vbox 
        VBox vBox = new VBox();

        vBox.getChildren().addAll(label,textField,button);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox,500,250);
        stage.setScene(scene);
        stage.setTitle("capturar nombre");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
