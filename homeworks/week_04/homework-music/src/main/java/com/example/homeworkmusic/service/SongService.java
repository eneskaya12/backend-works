package com.example.homeworkmusic.service;

import com.example.homeworkmusic.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    private List<Song> songs= new ArrayList<>();

    public List<Song> getAllSongs() {
        return songs;
    }

    public String createSong(Song song) {
        if(songs.size() < 20) {
            songs.add(song);
            return song + "added successfully.";
        }else{
            return song + "couldn't added because you have already added 20 songs!";
        }
    }

    public Song deleteSong(Song song) {
        songs.remove(song);
        return song;
    }

    public Song updateSong(Long id, Song newSong) {
        Song theSong = songs.stream().filter(song -> song.getId() == id).findAny().orElseThrow();
        theSong.setName(newSong.getName());
        return theSong;
    }
}
