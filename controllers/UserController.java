package com.company.controllers;

import com.company.entities.User;
import com.company.repositories.interfaces.IUserRepositories;

import java.util.List;

public class UserController {
    private final IUserRepositories repo;

    public UserController(IUserRepositories repo){this.repo=repo;}
    public String createUser(String name, String surname, String gender){
        boolean male = (gender.toLowerCase().equals("male"));
        User user = new User(name, surname, male);
        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed! ");
    }
    public  String getUser(int id){
        User user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public  String getUserByName(String name){
        User user = repo.getUserByName(name);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers(){
        List <User> users = repo.getAllUsers();

        return users.toString();
    }
}
