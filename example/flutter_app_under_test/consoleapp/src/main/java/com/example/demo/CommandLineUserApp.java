package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.UsersStorage;
import com.example.demo.utils.FileUtils;
import com.example.demo.validation.UserValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@PropertySource("classpath:user.properties")
public class CommandLineUserApp implements CommandLineRunner {
    private final UsersStorage usersStorage;
    private final UserValidator userValidator;
    private final Environment environment;

    public CommandLineUserApp(UsersStorage usersStorage, UserValidator userValidator, Environment environment) {
        this.usersStorage = usersStorage;
        this.userValidator = userValidator;
        this.environment = environment;
    }

    @Override
    public void run(String... args) {
        List<User> users = FileUtils.getUsersFromPaths(Arrays.asList(
            environment.getProperty("user-path-one"),
            environment.getProperty("user-path-two"),
            environment.getProperty("user-path-three")));
        users.forEach(user -> {
            if(userValidator.validate(user)) {
                usersStorage.addUser(user);
            }
        });
        System.out.println(usersStorage);
    }
}
