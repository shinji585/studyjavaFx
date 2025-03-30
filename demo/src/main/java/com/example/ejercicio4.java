package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ejercicio4  extends Application{
    // codigo para javafx 
    @Override
    public void start(Stage stage) throws Exception{
        Button boton1 = new Button("soy el boton 1");
        boton1.setPrefSize(100, 20);
        Button boton2 = new Button("soy el boton 2");
        boton2.setPrefSize(100, 20);
        Button boton3 = new Button("soy el boton 3");
        boton3.setPrefSize(100, 20);

        // creamos un panel 
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(500, 500);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        hbox.setStyle("-background-color: rgb(103, 150, 232)");
        hbox.getChildren().addAll(addVbox(),boton1,boton2,boton3);
        borderPane.setCenter(hbox);
        Label nombres[] = new Label[]{
             new Label("santiago"),
             new Label("sebastian"),
             new Label("samuel"),
        };
        // recorremos el label 
        for (Label label : nombres) {
            HBox.setMargin(label, new Insets(0,0,0,8));
            hbox.getChildren().add(label);
        }
        // agregamos a el border pane
        borderPane.setCenter(addStackpane());
       // creamos la scene 
       Scene scene = new Scene(borderPane);

      stage.setScene(scene);
       stage.show();
        stage.setTitle("hola mundo");
    }
    // metodo vbob
    public   VBox addVbox(){
          VBox vbox = new VBox();
          vbox.setPadding(new Insets(10));
          vbox.setSpacing(8);

          // creamos un titulo de texto 
          Text titulo = new Text("Datos");
          titulo.setFont(Font.font("Arial",FontWeight.BOLD,14));
          vbox.getChildren().addAll(titulo);

          // creamos un array de hiperlink
          Hyperlink options[] = new Hyperlink[]{
            new Hyperlink("en venta"),
            new Hyperlink("marquetin"),
            new Hyperlink("distribucion"),
            new Hyperlink("costo"),
          };

          // recorremos el array de hyperlink 
          for (int i = 0; i < options.length; i++) {
            VBox.setMargin(options[i], new Insets(0,0,0,8));
            vbox.getChildren().addAll(options[i]);
          }


          return vbox;

    }
    // metodo para crear el stackpanel y la forma en como debemos utilizar este 
    public StackPane addStackpane(){
        StackPane stackPane = new StackPane();
        Image imagen = new Image("file:C:\\Users\\USUARIO\\Desktop\\studyjavaFx\\demo\\src\\main\\resources\\com\\example\\bcd1036c99280a69d6175d8583b826f3.jpg");
        ImageView imageView = new ImageView(imagen);
        imageView.setFitHeight(200);
        imageView.setFitWidth(150);

        // creamos un texto sobre la imagen 
        Label label = new Label("texto de ejemplo");
        label.setStyle("-background-color: rgb(193, 68, 68)");
        label.setFont(Font.font(20));

        // agregamos a el stack pane 
        stackPane.getChildren().addAll(imageView,label);
        return stackPane;
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
