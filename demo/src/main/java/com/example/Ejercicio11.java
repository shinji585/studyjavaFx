package com.example;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio11 extends Application {
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception {
        AtomicInteger contador = new AtomicInteger(0);
        TextField textField = new TextField();
        textField.setPromptText("ingresa la cantidad de veces que se contara");
        textField.setPrefSize(20, 10);
        Label label = new Label("Contador: " + contador);
        Button button = new Button("click me");
        Button enviar = new Button("click para enviar");
        enviar.setStyle("-fx-background-color: white; -fx-text-fill: black;");
        Button button2 = new Button("click me now");
        button2.setDisable(true);
        button2.setStyle("-fx-background-color: white; -fx-text-fill: black;");
        button.setStyle("-fx-background-color: white; -fx-text-fill: black;");
        // creamos la accion
        EventHandler<ActionEvent> eventHandler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                int valor = 0;
                int valorMaximo = Integer.parseInt(textField.getText());
                if (event.getSource() == button  || event.getSource() == enviar) {
                    valor = contador.incrementAndGet();
                    enviar.setDisable(true);
                    label.setText("Contador: " + contador);
                    
                    if (valor >= 10) {
                        button.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                    }
                    
                    if (valor == 20) {
                        button.setDisable(true);
                        label.setText("hemos desactivado tu button");
                        button2.setDisable(false);
                    }  
                    if (valor == valorMaximo) {
                        label.setText("Haz alcanzado el limite");
                        button2.setDisable(true);
                    }
                }
                  if (event.getSource() == button2){
                        contador.set(0);
                        button.setDisable(false);
                        button2.setDisable(true);
                        valor = contador.incrementAndGet();
                        label.setText("Contador renovado: " + valor);
                        button.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    }
            }
        };

        // pasamos el evento a el button
        button.setOnAction(eventHandler);
        enviar.setOnAction(eventHandler);
        button2.setOnAction(eventHandler);

        // creamos la logica de los paneles
        VBox vBox = new VBox(10, textField, label, button, enviar, button2);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 300, 250);
        stage.setScene(scene);
        stage.setTitle("el contador");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
