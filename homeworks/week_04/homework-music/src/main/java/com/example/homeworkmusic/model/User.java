package com.example.homeworkmusic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String fullName;

    private String email;

    private String password;

    private List<Song> playlist = new ArrayList<>();

    public User(Long id, String fullName, String email, String password){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}
