package com.example;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Logica {
    public static void guardarDatos(List<CrudAnimal> lista, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(new ArrayList<>(lista));
            System.out.println("Guardado OK en: " + new File(archivo).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<CrudAnimal> leerDatos(String archivo) {
        File file = new File(archivo);
        if (!file.exists()) {
            System.out.println("Archivo no existe. Se devolverá lista vacía.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<CrudAnimal>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}