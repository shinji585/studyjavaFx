package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio12 extends Application {
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        // creamos el label 
        Label label = new Label("Ningun valor seleccionado");
        
        // creamos el radio button
        RadioButton radioButton1 = new RadioButton("Azul");
        RadioButton radioButton2 = new RadioButton("Verde");
        RadioButton radioButton3 = new RadioButton("Rojo");
        // creamos el toglegroup
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        // ajustamos el stage
        stage.setMinWidth(300);
        stage.setMinHeight(200);
        // creamos el Vbox 
        VBox vBox = new VBox(10,label,radioButton1,radioButton2,radioButton3);
        vBox.setAlignment(Pos.CENTER);
        // pasamos la logica de la accion 
        radioButton1.setOnAction((e -> cambiarFondo(vBox, radioButton1, label)));
        radioButton2.setOnAction((e -> cambiarFondo(vBox, radioButton2, label)));
        radioButton3.setOnAction((e -> cambiarFondo(vBox, radioButton3, label)));

        // pasamos la informacion a la scene 
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("ejercicio 12");
        stage.show();
    }
    // creamos los metodos privados para la logica 
    private void cambiarFondo(VBox vbox,RadioButton e,Label label){
         vbox.setStyle("-fx-background-color: transparent;");
        if (e.isSelected() == true){
            String text = e.getText();
              switch (text) {
                case "Azul":{
                    vbox.setStyle("-fx-background-color: blue");
                    label.setText("Valor seleccionado: " + text);
                    break;
                }case "Verde":{
                    vbox.setStyle("-fx-background-color: green");
                    label.setText("Valor seleccionado: " + text);
                    break;
                }case "Rojo":{
                    vbox.setStyle("-fx-background-color: red");
                    label.setText("Valor seleccionado: " + text);
                    break;
                }
                default:
                        label.setText("Al parecer ocurrio un error reinice el programa");
                    break;
              }
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
