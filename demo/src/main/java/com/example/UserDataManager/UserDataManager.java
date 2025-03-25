package com.example.UserDataManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.example.Model.User;

public class UserDataManager {
    // creamos el metodo de guardar usuario
    public boolean saveUser(User user) {
        try (FileWriter writer = new FileWriter("user.txt", true);
        BufferedWriter file = new BufferedWriter(writer)) {
        file.write(user.getUsername() + "," + user.getPassword());
            file.newLine();
            file.close();
           return true;
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean loadUsers(String name, String pass) {
        String ruta = "user.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(","); 
                if (datos.length == 2) {
                    String username = datos[0];
                    String password = datos[1];
                    if (username.equals(name) && password.equals(pass)) {
                        return true; 
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de tipo " + e.getLocalizedMessage());
            return false; 
        }
        return false; 
    }
}
