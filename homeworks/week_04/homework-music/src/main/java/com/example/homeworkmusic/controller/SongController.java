package com.example.homeworkmusic.controller;

import com.example.homeworkmusic.model.Song;
import com.example.homeworkmusic.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    SongService songService;

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @PostMapping
    public String createSong(Song song){
        return songService.createSong(song);
    }

    @PutMapping
    public Song updateSong(Long id, Song newSong){
        return songService.updateSong(id, newSong);
    }

    @DeleteMapping
    public Song deleteSong(Song song){
        return songService.deleteSong(song);
    }

}
