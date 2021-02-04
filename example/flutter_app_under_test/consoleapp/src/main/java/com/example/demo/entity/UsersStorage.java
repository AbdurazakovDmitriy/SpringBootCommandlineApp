package com.example.demo.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersStorage {
    private final List<User> users;

    public UsersStorage() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public String toString() {
        return "UserStorage{" +
            "users=" + users +
            '}';
    }
}
