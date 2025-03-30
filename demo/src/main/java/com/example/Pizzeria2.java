package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pizzeria2 extends Application {
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
    Label label = new Label("Ingrese el tamaño de la pizza que quiere");
    
    // creamos los radiosbutton
    RadioButton radioButton1 = new RadioButton("Grande ");
    RadioButton radioButton2 = new RadioButton("Mediana ");
    RadioButton radioButton3 = new RadioButton("Pequeña ");

    // utilizamos un toggleGroup
    ToggleGroup toggleGroup = new ToggleGroup();
    radioButton1.setToggleGroup(toggleGroup);
    radioButton2.setToggleGroup(toggleGroup);
    radioButton3.setToggleGroup(toggleGroup);


     // creamos el button que detectara lo seleccionado 
     Button selecionado = new Button("seleccionar");

     // creamos el label que mostrara un segundo mensaje 
     Label label2 = new Label();

     // definimos la accion
     selecionado.setOnAction( e ->{
        RadioButton resultado = (RadioButton) toggleGroup.getSelectedToggle();
        if (resultado != null){
            label2.setText("Tamaño seleccionado: " + resultado.getText());
        }else{
            label2.setText("Debes seleccionar un tamaño correspondiente");
        }
     });

     // diseñamos el vbox 
     VBox vbox = new VBox(10,label,label2,radioButton1,radioButton2,radioButton3,selecionado);
     vbox.setAlignment(Pos.CENTER);



     // creamos la scene 
     Scene scene = new Scene(vbox,350,250);

     stage.setScene(scene);
     stage.setTitle("RadioButton");
     stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
