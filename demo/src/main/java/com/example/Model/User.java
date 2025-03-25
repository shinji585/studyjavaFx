package com.example.Model;

public class User {
    private String username;
    private String password;

    // creamos un constructor vacio
    public User(){}

    // creamos los getter and setters 
    public void setUsername(String name){
        this.username = name;
    }
    public void setPassword(String pass){
       this.password = pass;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}

