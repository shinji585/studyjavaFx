package com.example;

import javafx.application.Application;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {

    
    @Override 
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception{
        stage.setTitle("mi primer hola mundo"); // el titlo de nuestro ventana 
        stage.setMaxHeight(900);
        stage.setMinHeight(300); // configuramos el ancho
        stage.setMaxWidth(900);
        stage.setMinWidth(300); // configuramos la altura 
        stage.show(); //  inicializamos la ventana
    }

    public static void main(String[] args) {
        launch(); // creamos un subproceso al momento de ejecutar el programa
    }



}