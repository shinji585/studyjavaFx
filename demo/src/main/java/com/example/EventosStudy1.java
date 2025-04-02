package com.example;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventosStudy1 extends Application {
    // estudio de acciones con javafx 
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        Label colorlabel = new Label("Color seleccionado: ninguno");

        // creamos los botones 
        Button button1 = new Button("Rojo");
        button1.setStyle("-fx-background-color: rgb(249, 0, 0)");
        Button button2 = new Button("Verde");
        button2.setStyle("-fx-background-color: rgb(47, 255, 0)");
        Button button3 = new Button("Azul");
        button3.setStyle("-fx-background-color: rgb(0, 87, 249)");

   
        // generamos el evento 
        @SuppressWarnings("unused")
        EventHandler<ActionEvent> eventHandler = new EventHandler<>(){
            @Override
            public void handle(ActionEvent event){
                if (event.getSource() == button1){
                 colorlabel.setText("Color seleccionado: Rojo");   
                }else if (event.getSource() == button2){
                    colorlabel.setText("Color seleccionado: Verde");
                }else {
                    colorlabel.setText("Color seleccionado: Azul");
                }
            }
        }; 

        // pasamos el evento a los botones
        button1.setOnAction(eventHandler);
        button2.setOnAction(eventHandler);
        button3.setOnAction(eventHandler);


        HBox hBox = new HBox(10,button1,button2,button3);
        hBox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10,colorlabel,hBox);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox,300,200);

        stage.setScene(scene);
        stage.setTitle("Seleccion de color");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
