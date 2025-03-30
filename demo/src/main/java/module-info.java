module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    exports com.example;  // <-- Agrega esto para permitir que JavaFX acceda a Estudiofx
    exports com.example.View; 

    opens com.example to javafx.graphics;  // <-- Abre el paquete donde está la clase principal
    opens com.example.View to javafx.graphics;
}
