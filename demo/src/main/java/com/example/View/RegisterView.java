package com.example.View;

import com.example.LoginController.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterView extends Application {
    private final LoginController loginController = new LoginController(); // Controlador

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label userLabel = new Label("Nuevo usuario:");
        TextField userField = new TextField();
        userField.setPromptText("Ingrese su nombre");

        Label passLabel = new Label("Nueva contraseña:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Ingrese su contraseña");

        Button registerButton = new Button("Registrar");

        registerButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passwordField.getText();

            if (!username.isEmpty() && !password.isEmpty()) {
                loginController.registerUser(username, password);
                showAlert("Registro exitoso", "Usuario registrado correctamente", Alert.AlertType.INFORMATION);
                stage.close(); // Cierra la ventana después del registro
            } else {
                showAlert("Error", "Por favor, complete todos los campos", Alert.AlertType.ERROR);
            }
        });

        gridPane.add(userLabel, 0, 1);
        gridPane.add(userField, 1, 1);
        gridPane.add(passLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(registerButton, 1, 3);

        Scene scene = new Scene(gridPane, 400, 300);
        stage.setTitle("Registro de usuario");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
