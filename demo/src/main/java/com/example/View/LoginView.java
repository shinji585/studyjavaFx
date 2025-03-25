package com.example.View;

import com.example.LoginController.LoginController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView extends Application {
    private final LoginController loginController = new LoginController(); // Controlador del login

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label userLabel = new Label("Usuario:");
        TextField userField = new TextField();
        userField.setPromptText("Ingrese su nombre");

        Label passLabel = new Label("Contraseña:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Ingrese su contraseña");

        Button loginButton = new Button("Iniciar sesión");
        Button registerButton = new Button("Registrarse");

        // Eventos de botones
        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passwordField.getText();
            if (loginController.autenticarUser(username, password)) {
                showAlert("Inicio de sesión exitoso", "Bienvenido " + username, Alert.AlertType.INFORMATION);
            } else {
                showAlert("Error", "Usuario o contraseña incorrectos", Alert.AlertType.ERROR);
            }
        });

        registerButton.setOnAction(e -> {
            RegisterView registerView = new RegisterView();
            try {
                registerView.start(new Stage()); // Abre la ventana de registro
            } catch (Exception ex) {
                showAlert("Error", "No se pudo abrir la ventana de registro", Alert.AlertType.ERROR);
            }
        });

        gridPane.add(userLabel, 0, 1);
        gridPane.add(userField, 1, 1);
        gridPane.add(passLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(loginButton, 0, 3);
        gridPane.add(registerButton, 1, 3);

        Scene scene = new Scene(gridPane, 400, 300);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
