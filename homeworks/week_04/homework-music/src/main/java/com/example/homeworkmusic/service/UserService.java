package com.example.homeworkmusic.service;

import com.example.homeworkmusic.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    static List<User> users = new ArrayList<>();

    public static List<User> getAllUsers() {
        return users;
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getUserByLetter(String letter) {
        return users.stream().filter(user -> user.getFullName().contains(letter)).toList();
    }

    public List<User> getUserByNumberOfSong() {
        return users.stream().filter(user -> user.getPlaylist().size() > 10).toList();
    }

    public User deleteUser(User user) {
        users.remove(user);
        return user;
    }

    public User updateUser(Long id, User newUser) {
        User theUser =users.stream().filter(user -> user.getId() == id).findAny().orElseThrow();

        if(theUser.getFullName() != null) theUser.setFullName(newUser.getFullName());
        if(theUser.getEmail() != null) theUser.setEmail(newUser.getEmail());
        if(theUser.getPassword() != null) theUser.setPassword(newUser.getPassword());

        return theUser;
    }
}
