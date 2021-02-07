package com.example.demo.repositories;

import com.example.demo.entity.User;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ToString
public class UsersStorage implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        this.users.add(user);
        return user;
    }
}
