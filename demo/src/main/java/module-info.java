module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.View; // <-- Esto permite que JavaFX acceda a LoginView
    opens com.example.View to javafx.graphics; // <-- Esto soluciona el problema de acceso reflejado
}
