package com.example;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio10  extends Application{
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        Label label = new Label("Estado: Off");
        label.setPadding(new Insets(5));
        Button estado = new Button("click me");
        estado.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 14px;");

        // creamos la logica del evento 
        @SuppressWarnings("unused")
        EventHandler<ActionEvent> eventoEventHandler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent event){
                if (event.getSource() == estado && label.getText().equals("Estado: Off")){
                    label.setText("Estado: On");
                    label.setStyle("-fx-background-color: rgb(255, 2, 2)");
                }else{
                    label.setText("Estado: Off");
                    label.setStyle("-fx-background-color: transparent; -fx-text-fill: black");
                }
            }
        };

        // pasamos el evento a el button
        estado.setOnAction(eventoEventHandler);
        estado.setAlignment(Pos.BOTTOM_CENTER);
        // pasamos lo que seria el label y el button a un hbox 
        HBox hbox = new HBox(10,label,estado);
        hbox.setAlignment(Pos.CENTER);

        // pasamos el Hbox a un vbox y le damos forma a los elementos 
        VBox vBox = new VBox(10,hbox);
        vBox.setAlignment(Pos.CENTER);

        Scene scene  = new Scene(vBox,300,250);
        stage.setScene(scene);
        stage.setTitle("botones");
        stage.show();
        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
