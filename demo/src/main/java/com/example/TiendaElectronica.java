package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TiendaElectronica extends Application {
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {
        // creamos un label para mostrar informacion
        Label label = new Label("Tienda de Electronica");
        label.setFont(Font.font("Arial", 24));
        label.setStyle("-fx-font-weight:bold; -fx-alignment: center;");

        ListView<String> listView = new ListView<>();
        listView.setPrefHeight(150);
        ObservableList<String> observableList = FXCollections.observableArrayList(
                "Iphone 15",
                "Samsung galaxy s24",
                "Lavadora Samsung",
                "HP pavilion DK20",
                "Dell XPS 17");
        listView.setItems(observableList);

        // creamos el textfield
        TextField textField = new TextField();
        textField.setPrefSize(250, 35);
        textField.setPromptText("ingrese un nuevo producto o eliminar");

        // creamos los buttons
        
        Button button1 = new Button("Agregar producto");
        button1.setPrefSize(100, 35);
        button1.setStyle("-fx-background-color: rgb(68, 254, 6)");

        Button button2 = new Button("Eliminar producto");
        button2.setStyle("-fx-background-color: rgb(254, 52, 6)");
        button2.setPrefSize(100, 35);

        Label label2 = new Label();
        label2.setStyle("-fx-text-fill: red;");

        // cremos la logica par agregar producto a la lista
        button1.setOnAction(e -> {
            String texto = textField.getText();

            // verificamos que no se envie nada y que el elemento seleccionado
            if (texto == null || texto.isEmpty()) {
                label2.setText("No se ha seleccionado ninguna opcion por favor volver a intentarlo");
                return;
            }
            // pasamos el nuevo producto ingresado a el observablelist
            if (observableList.contains(texto)) {
                label2.setText("El producto ya se encuentra en lista");
                return;
            } else {
                observableList.add(texto);
                listView.setItems(observableList);
            }

            // mostramos un mensaje donde se muestre la lista con el nuevo producto
            
                label2.setText(
                        "producto guardado correctamente la lista se muestra de la forma " + observableList.toString());
                textField.clear();
        });
        button2.setOnAction(e -> {
            String textoEliminmar = textField.getText();

            if (textoEliminmar == null || textoEliminmar.isEmpty()) {
                label2.setText("No se ha seleccionado ninguna opcion por favor volver a intentarlo");
                return;
            }

           if (!observableList.contains(textoEliminmar)){
              label2.setText("El producto no esta en la lista");
              return;
           }else {
             observableList.remove(textoEliminmar);
             listView.setItems(observableList);
             textField.clear();
           }

            // se muestra un mensaje con el texto eliminado
            if (observableList.isEmpty()){
                label2.setText("La lista esta vacia");
            }else{
                label2.setText("Elemento eliminado correctamente: " + observableList.toString());
            }
        });

        // cremaos HBox
        HBox hbox = new HBox(10,textField, button1, button2);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER_LEFT);

        // creamos Vbox
        VBox vbox = new VBox(10,label, listView, hbox,label2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        // creamos la scene y la pasamos a el stage
        Scene scene = new Scene(vbox,500,40);
        stage.setScene(scene);
        stage.setTitle("Tienda Electronica");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
