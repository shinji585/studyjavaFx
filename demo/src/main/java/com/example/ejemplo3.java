package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ejemplo3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("aprendiendo.fxml"));
        Parent root = loader.load();

        // Crear la escena
        stage.setScene(new Scene(root));
        stage.setTitle("Ejemplo con FXML");

        // Obtener la resolución de pantalla
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setWidth(screenBounds.getWidth());
        stage.setHeight(screenBounds.getHeight());

        // Mostrar la ventana
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
