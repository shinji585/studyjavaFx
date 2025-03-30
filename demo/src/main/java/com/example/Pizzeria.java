package com.example;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pizzeria extends Application {
    @Override
    @SuppressWarnings("exports")
    public void  start(Stage stage) throws Exception{
        Label label = new Label("Selecciona los ingredientes de tu pizza");

        // creamos los checbox 
        CheckBox checkBox1 = new CheckBox("quezo Extra");
        CheckBox checkBox2 = new CheckBox("Pepperoni");
        CheckBox checkBox3 = new CheckBox("Champiñones");
        CheckBox checkBox4 = new CheckBox("Aceitunas");

        // creamos un button para captura la entrada 
        Button button1 = new Button("Ordenar Pizza");

        Label label2 = new Label();
        // capturamos la accion 
        button1.setOnAction(e ->{
            StringBuilder iStringBuilder = new StringBuilder("Tu pizza tiene: ");
            Boolean estado = false;
            // creamos un booleano para determinar los ingredientes que se seleccionaron aplicando el metodo isSelected()
            if(checkBox1.isSelected()){
             iStringBuilder.append("Quezo Extra");
             estado = true;
            }

            if (checkBox2.isSelected()){
                iStringBuilder.append("Pepperoni; ");
                estado = true;
            }

            if (checkBox3.isSelected()){
                iStringBuilder.append("Champiñones, ");
                estado = true;
            }
            
            if (checkBox4.isSelected()){
                iStringBuilder.append("Aceitunas");
                estado = true;
            }


            if (estado == true){
               // eliminalos ingredientes no seleccionados 
               iStringBuilder.setLength(iStringBuilder.length() - 2);
               label2.setText(iStringBuilder.toString());
            }else{
                label2.setText("Debes seleccionar al menos un ingrediente");
            }

        });

        VBox vbox = new VBox(10,label,label2,checkBox1,checkBox2,checkBox3,checkBox4,button1);
        vbox.setAlignment(Pos.CENTER);

        // creamos la scene
        Scene scene = new Scene(vbox,350,300);

        // pasamos a el stage 
        stage.setScene(scene);
        stage.setTitle("pizzerias con sabor a chucha");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
