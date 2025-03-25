package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Lgridpane extends Application{
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws Exception{
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // definimos 3 columas (30,40,30) porciento cada una 
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        col1.setPercentWidth(30);
        col2.setPercentWidth(40);
        col3.setPercentWidth(30);
        gridPane.getColumnConstraints().addAll(col1,col2,col3);

        // definimos 2 filas de (50,50) porciento cada una 
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new  RowConstraints();
        row1.setPercentHeight(50);
        row2.setPercentHeight(50);
        gridPane.getRowConstraints().addAll(row1,row2);

        // agregamos los botones 
        gridPane.add(new Button("1.1"),0,0);
        gridPane.add(new Button("2.1"),1,0);
        gridPane.add(new Button("3.1"),2,0);
        gridPane.add(new Button("1.2"),0,1);
        gridPane.add(new Button("2.2"),1,1);
        gridPane.add(new Button("3.2"),2,1);

        Scene scena = new Scene(gridPane);
        stage.setScene(scena);
        stage.setTitle("gridpane column & row costraints");
        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
