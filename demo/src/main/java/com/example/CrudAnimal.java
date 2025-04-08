package com.example;

import java.io.Serializable;

public class CrudAnimal implements Serializable{
    private String nombre;
    private String especie;
    private int edad; 
    private double peso;

     // creamos el constructor 
     public CrudAnimal(String nombre, String especie, int edad, double peso) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
   
    @Override
    public String toString() {
        return "CrudAnimal [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", peso=" + peso + "]";
    }
    
}
