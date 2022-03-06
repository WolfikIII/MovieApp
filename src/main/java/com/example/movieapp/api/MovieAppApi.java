package com.example.movieapp.api;

import com.example.movieapp.entities.MovieEntity;
import com.example.movieapp.entities.UserEntity;
import com.example.movieapp.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.movieapp.service.Service;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieAppApi {
    private Service service;
    @Autowired
    public MovieAppApi(Service service){this.service=service;}
    @GetMapping("/getByTitle")
    public Optional<MovieEntity> getByTitle(@RequestParam String title){return service.findByTitle(title);}
    @GetMapping("/all")
    public Iterable<MovieEntity> getAll(){return service.findAll();}
    @PostMapping
    public MovieEntity addMovie(@RequestBody MovieEntity movieEntity){return service.save(movieEntity);}
    @PutMapping
    public MovieEntity updateMovie(@RequestBody MovieEntity movieEntity){return service.save(movieEntity);}
    @GetMapping("/getUserByLogin")
    public UserEntity getByLogin(@RequestParam String login){return service.findByLogin(login);}
}
