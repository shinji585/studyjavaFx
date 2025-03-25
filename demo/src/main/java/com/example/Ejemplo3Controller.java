package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Ejemplo3Controller {

    @FXML
    private Button botonPresionar;

    @FXML
    public void initialize() {
        botonPresionar.setOnAction(event -> System.out.println("¡Botón presionado!"));
    }
}
