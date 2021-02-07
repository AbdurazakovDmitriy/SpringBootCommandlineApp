package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repositories.UsersStorage;
import com.example.demo.utils.UserParser;
import com.example.demo.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:user.properties")
@RequiredArgsConstructor
public class CommandLineUserApp implements CommandLineRunner {
    private final UsersStorage usersStorage;
    private final UserValidator userValidator;
    private final UserParser userParser;

    @Value("${files}")
    private List<String> files;

    @Override
    public void run(String... args) {
        List<User> users = userParser.getUsersFromPaths(files);
        users.forEach(user -> {
            if(userValidator.validate(user)) {
                usersStorage.save(user);
            }
        });
        System.out.println(usersStorage);
    }
}
