package com.example;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventfilterStudy extends Application {
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception {
        Label label = new Label("Caracteres ingresados:");
        TextField textField = new TextField();
        ArrayList<Character> caracteres = new ArrayList<>();
        textField.setPromptText("Ingrese un texto...");
        Button enviarTexto = new Button("Enviar");

        // Aplicando IDs para CSS
        label.setId("label");
        textField.setId("textField");
        enviarTexto.setId("button");

        // Evento para capturar caracteres
        textField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            caracteres.add(event.getCharacter().charAt(0));
            label.setText("Caracteres capturados: " + caracteres.size());
        });

        // Evento para mostrar caracteres almacenados
        enviarTexto.setOnAction(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : caracteres) {
                stringBuilder.append(character).append(" , ");
            }
            label.setText("Caracteres ingresados: " + stringBuilder.toString());
        });

        // Diseño mejorado con VBox
        VBox vbox = new VBox(15, label, textField, enviarTexto);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(350, 250);
        vbox.getStyleClass().add("container"); // Aplicando clase CSS

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("EventFilter UI Mejorada");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
