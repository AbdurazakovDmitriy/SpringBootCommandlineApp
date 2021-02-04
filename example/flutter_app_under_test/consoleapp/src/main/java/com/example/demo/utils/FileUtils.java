package com.example.demo.utils;

import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<User> getUsersFromPaths(List<String> paths) {
        List<User> users = new ArrayList<>();
        paths.forEach(path-> {
            try {
                users.add(objectMapper.readValue(new File(path), User.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return users;
    }
}
