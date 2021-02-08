package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.UserParser;
import com.example.demo.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@PropertySource("classpath:user.properties")
@RequiredArgsConstructor
public class CommandLineUserApp implements CommandLineRunner {
    private final UserService usersStorage;
    private final UserValidator userValidator;
    private final UserParser userParser;

    @Value("${files}")
    private List<String> files;

    @Override
    public void run(String... args) {
        List<User> users = userParser.getUsersFromPaths(files);
        users.forEach(user -> {
            if(userValidator.validate(user)) {
                User us = usersStorage.save(user);
                System.out.println("User " + us + " was added to database");
            }
        });
    }
}
