package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ejemplo5 extends Application{
    @Override
    @SuppressWarnings("exports")
    public void start(Stage prymari){
      // creamos un panel 
      Pane panel = new Pane();

      // creamos un textfield 
      TextField text = new TextField();
      text.setLayoutX(50);
      text.setLayoutY(100);
      
      // agregamos el textfiedl a el panel 
      panel.getChildren().add(text);

      // pasamos el panel a la scene 
      Scene scene = new Scene(panel);

      prymari.setScene(scene);



        prymari.setTitle("ejemplo5");
        prymari.setWidth(400);
        prymari.setHeight(300);
        prymari.show();
    }
    public static void main(String[] args) {
        Application.launch();
    }
}
