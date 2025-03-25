package com.example.LoginController;

import com.example.Model.User;
import com.example.UserDataManager.UserDataManager;

public class LoginController {
    // creamos el registerser
    public void registerUser(String name, String password) {
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        // pasamos los datos a el metodo dentro de userdatamangaer
        UserDataManager userDataManager = new UserDataManager();
        userDataManager.saveUser(user);
    }

    // creamnos el metodo autenticar usuario
    public boolean autenticarUser(String name,String password){
        UserDataManager userDataManager = new UserDataManager();
        return userDataManager.loadUsers(name, password);
    }
}
