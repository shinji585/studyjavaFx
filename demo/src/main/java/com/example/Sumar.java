package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sumar extends Application {
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        Label label = new Label("Ingrese dos numeros");
        Label label2 = new Label();
        TextField textField1 = new TextField();
        textField1.setPrefWidth(150);
        TextField textField2 = new TextField();
        textField2.setPrefWidth(150);
        Button button = new Button("suma numeros");
        button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        // capturamos la entrada 
        button.setOnAction(e ->{
            try {
                Double suma;
                Double operador1 = Double.parseDouble(textField1.getText());
                Double operador2 = Double.parseDouble(textField2.getText());
     
    
                // sumamos 
                suma = operador1 + operador2;
                // mostramos la suma en el label 
                label2.setText("el resultado de la suma es: " + suma);
            } catch (NumberFormatException ex) {
                label2.setText("ingrese solo numeros validos");
            }
        });

        // creamos el vbox y le damos un espaciado vertical de 10 
        VBox vbox = new VBox(10,label,label2,textField1,textField2,button);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox,300,200);
        stage.setScene(scene);
        stage.setTitle("suma de numeros");
        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
