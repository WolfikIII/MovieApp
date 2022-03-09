package com.example.movieapp.service;

import com.example.movieapp.entities.MovieEntity;
import com.example.movieapp.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import com.example.movieapp.repositories.MovieRepo;
import com.example.movieapp.repositories.UserRepo;

import java.io.Serializable;
import java.util.Optional;
import java.util.Scanner;

@org.springframework.stereotype.Service
public class Service implements Serializable {

Scanner scanner = new Scanner(System.in);
    private MovieRepo movieRepo;
    private UserRepo userRepo;
    @Autowired
    public Service(MovieRepo movieRepo, UserRepo userRepo){this.movieRepo=movieRepo; this.userRepo=userRepo;}

    //MOVIES
    public Optional<MovieEntity> findByTitle(String title){return movieRepo.findByTitle(title);}
    public MovieEntity save(MovieEntity movieEntity) {return movieRepo.save(movieEntity);}
    public Iterable<MovieEntity> findAll() {return movieRepo.findAll();}
    public Iterable<MovieEntity> findByPrice(double price){return movieRepo.findByPrice(price);}
    public Iterable<MovieEntity> afterYear(int year){return movieRepo.afterYear(year);}

    //USER
    public Optional<UserEntity> findByLogin(String login) {return userRepo.findByLogin(login);}
    public UserEntity saveUser(UserEntity userEntity){return userRepo.save(userEntity);}
    public Optional<UserEntity> findById(Long id){return userRepo.findById(id);}
    public Optional<UserEntity> findUserByEmail(String email) {return userRepo.findByEmail(email);}
    public Optional <UserEntity> checkUser(String login, String password){return userRepo.checkUser(login, password);}
    @EventListener(ApplicationReadyEvent.class)
    public void basicMoviesInApp(){
        save(new MovieEntity(1L, "Titanic", 1999, "02:05:24", 9.99));
        save(new MovieEntity(2L, "Matrix", 2001, "01:43:42", 12.99));
        save(new MovieEntity(3L, "Fast and Furious", 2006, "01:54:12", 7.99));
        save(new MovieEntity(4L, "Hobbit", 2011, "02:32:21", 21.99));
        save(new MovieEntity(5L, "Fast and Furious 2", 2006, "02:07:34", 5.99));
    }
    @EventListener(ApplicationReadyEvent.class)
    public void adminUser(){
        saveUser(new UserEntity(1L,"Admin", "1234", "admin@wp.pl"));
        saveUser(new UserEntity(2L,"Login", "pass", "login@wp.pl"));
        saveUser(new UserEntity(3L,"Tutek", "tutu", "tutek@wp.pl"));
    }
}
