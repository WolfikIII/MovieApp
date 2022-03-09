package com.example.movieapp.api;

import com.example.movieapp.entities.MovieEntity;
import com.example.movieapp.entities.UserEntity;
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
    @GetMapping("/allMovies")
    public Iterable<MovieEntity> getAll(){return service.findAll();}
    @PostMapping("/addMovie")
    public MovieEntity addMovie(@RequestBody MovieEntity movieEntity){return service.save(movieEntity);}
    @PutMapping("/updateMovie")
    public MovieEntity updateMovie(@RequestBody MovieEntity movieEntity){return service.save(movieEntity);}
    @GetMapping("/getUserByLogin")
    public Optional<UserEntity> getByLogin(@RequestParam String login){return service.findByLogin(login);}
    @GetMapping("/getUserById")
    public Optional<UserEntity> getUserById(@RequestParam Long id){return service.findById(id);}
    @GetMapping("/getUserByEmail")
    public Optional<UserEntity> getByEmail(@RequestParam String email){return service.findUserByEmail(email);}
    @PostMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity userEntity){return service.saveUser(userEntity);}
    @GetMapping("/login")
    public Optional <UserEntity> checkUser(@RequestParam String login, @RequestParam String password){return service.checkUser(login, password);}
    @GetMapping("/byPrice")
    public Iterable<MovieEntity> findByPrice(@RequestParam double price){return service.findByPrice(price);}
    @GetMapping("/afterYear")
    public Iterable<MovieEntity> afterYear(@RequestParam int year){return service.afterYear(year);}
}
