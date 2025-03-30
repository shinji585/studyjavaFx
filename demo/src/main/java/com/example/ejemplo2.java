package com.example;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ejemplo2 extends Application {
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception{
       // para que la ventana se adaptativa 
       Rectangle2D screenbound = Screen.getPrimary().getVisualBounds();
       // pasamos ese limite de pantalla a lo que seria el ancho y la altura 
       stage.setWidth(screenbound.getHeight());
       stage.setHeight(screenbound.getHeight());
       // le damos un titulo a nuestro programa 
       stage.setTitle("ejemplo numero 2");
       // creamos la imagen como icono
       Image icon = new Image("file:C:\\Users\\USUARIO\\Desktop\\studyjavaFx\\demo\\src\\main\\resources\\com\\example\\bcd1036c99280a69d6175d8583b826f3.jpg"); 
       stage.getIcons().add(icon);
       
       stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
