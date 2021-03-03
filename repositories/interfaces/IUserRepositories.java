package com.company.repositories.interfaces;

import com.company.entities.User;

import java.util.List;

public interface IUserRepositories {
    boolean createUser(User user);
    User getUser(int id);
    User getUserByName(String name);
    List<User> getAllUsers();
}
