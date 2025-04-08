package com.example;

import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.List;

public class CrudControllerAnimal {
    private ObservableList<CrudAnimal> listaAnimales;
    private TableView<CrudAnimal> tableView;
    private TextField txtNombre;
    private TextField txtEspecie;
    private TextField txtEdad;
    private TextField txtPeso;
    private Button btnAgregar;
    private Button btnEliminar;
    private Button btnModificar;

    private final String archivo = "animales.dat";

    public CrudControllerAnimal(
        ObservableList<CrudAnimal> listaAnimales,
        TableView<CrudAnimal> tableView,
        TextField txtNombre,
        TextField txtEspecie,
        TextField txtEdad,
        TextField txtPeso,
        Button btnAgregar,
        Button btnEliminar,
        Button btnModificar) {

        this.listaAnimales = listaAnimales;
        this.tableView = tableView;
        this.txtNombre = txtNombre;
        this.txtEspecie = txtEspecie;
        this.txtEdad = txtEdad;
        this.txtPeso = txtPeso;
        this.btnAgregar = btnAgregar;
        this.btnEliminar = btnEliminar;
        this.btnModificar = btnModificar;

        // Leer datos del archivo al iniciar
        List<CrudAnimal> datos = Logica.leerDatos(archivo);
        this.listaAnimales.setAll(datos);
        this.tableView.setItems(this.listaAnimales); // Conectar lista a tabla

        configurarEventos();
    }

    private void configurarEventos() {
        btnAgregar.setOnAction(e -> agregarAnimal());
        btnEliminar.setOnAction(e -> eliminarAnimal());
        btnModificar.setOnAction(e -> modificarAnimal());
    }

    private void agregarAnimal() {
        try {
            String nombre = txtNombre.getText();
            String especie = txtEspecie.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            double peso = Double.parseDouble(txtPeso.getText());

            CrudAnimal animal = new CrudAnimal(nombre, especie, edad, peso);
            listaAnimales.add(animal);
            Logica.guardarDatos(listaAnimales, archivo);
            limpiarCampos();

        } catch (NumberFormatException ex) {
            System.out.println("Edad debe ser un entero y peso un decimal.");
        }
    }

    private void eliminarAnimal() {
        CrudAnimal seleccionado = tableView.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaAnimales.remove(seleccionado);
            Logica.guardarDatos(listaAnimales, archivo);
        }
    }

    private void modificarAnimal() {
        CrudAnimal seleccionado = tableView.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try {
                seleccionado.setNombre(txtNombre.getText());
                seleccionado.setEspecie(txtEspecie.getText());
                seleccionado.setEdad(Integer.parseInt(txtEdad.getText()));
                seleccionado.setPeso(Double.parseDouble(txtPeso.getText()));
                tableView.refresh();
                Logica.guardarDatos(listaAnimales, archivo);
                limpiarCampos();
            } catch (NumberFormatException ex) {
                System.out.println("Edad debe ser un entero y peso un decimal.");
            }
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtEspecie.clear();
        txtEdad.clear();
        txtPeso.clear();
    }
}
