package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class VIstaCrudAnimal {

    @SuppressWarnings({ "unchecked", "unused" })
    public static BorderPane borderPane() {
        BorderPane bp = new BorderPane();
        bp.setId("root");

        // TextFields
        TextField textField1 = new TextField();
        textField1.setPromptText("Ingrese el nombre");

        TextField textField2 = new TextField();
        textField2.setPromptText("Ingrese la especie");

        TextField textField3 = new TextField();
        textField3.setPromptText("Ingrese la edad");

        TextField textField4 = new TextField();
        textField4.setPromptText("Ingrese el peso");

        // GridPane de campos
        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10));

        gp.add(new Label("Nombre:"), 0, 0);
        gp.add(textField1, 1, 0);
        gp.add(new Label("Especie:"), 0, 1);
        gp.add(textField2, 1, 1);
        gp.add(new Label("Edad:"), 0, 2);
        gp.add(textField3, 1, 2);
        gp.add(new Label("Peso:"), 0, 3);
        gp.add(textField4, 1, 3);

        // Botones
        Button btnAgregar = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar");
        Button btnModificar = new Button("Modificar");

        btnAgregar.getStyleClass().add("button");
        btnEliminar.getStyleClass().add("button");
        btnModificar.getStyleClass().add("button");

        HBox hbox = new HBox(15, btnAgregar, btnEliminar, btnModificar);
        hbox.setPadding(new Insets(10));
        hbox.setId("nav");

        VBox formSection = new VBox(20, gp, hbox);
        formSection.setPadding(new Insets(20));
        formSection.setId("form-section");

        // Tabla
        TableView<CrudAnimal> tableView = new TableView<>();
        tableView.setId("tabla-animal");

        TableColumn<CrudAnimal, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<CrudAnimal, String> colEspecie = new TableColumn<>("Especie");
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));

        TableColumn<CrudAnimal, Integer> colEdad = new TableColumn<>("Edad");
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        TableColumn<CrudAnimal, Double> colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));

        tableView.getColumns().addAll(colNombre, colEspecie, colEdad, colPeso);
        tableView.setPrefWidth(600);

        ObservableList<CrudAnimal> listaMascotas = FXCollections.observableArrayList(
            new CrudAnimal("Luna", "Perro", 3, 12.5),
            new CrudAnimal("Milo", "Gato", 2, 4.1)
        );

        tableView.setItems(listaMascotas);

        new CrudControllerAnimal(listaMascotas, tableView, textField1, textField2, textField3, textField4, btnAgregar, btnEliminar, btnModificar);

        // Layout con Split Pane para diseño moderno
        HBox mainContent = new HBox(30, formSection, tableView);
        mainContent.setPadding(new Insets(20));
        mainContent.setId("main-content");

        bp.setCenter(mainContent);
        return bp;
    }
}
