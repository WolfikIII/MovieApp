package com.example.movieapp.service;

import com.example.movieapp.entities.MovieEntity;
import com.example.movieapp.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import com.example.movieapp.repositories.MovieRepo;
import com.example.movieapp.repositories.UserRepo;
import java.util.Optional;
import java.util.Scanner;

@org.springframework.stereotype.Service
public class Service {
Scanner scanner = new Scanner(System.in);

    private MovieRepo movieRepo;
    private UserRepo userRepo;
    @Autowired
    public Service(MovieRepo movieRepo, UserRepo userRepo){this.movieRepo=movieRepo; this.userRepo=userRepo;}
    public Optional<MovieEntity> findByTitle(String title){return movieRepo.findByTitle(title);}
    public MovieEntity save(MovieEntity movieEntity) {return movieRepo.save(movieEntity);}
    public Iterable<MovieEntity> findAll() {return movieRepo.findAll();}
    public UserEntity findByLogin(String login) {return userRepo.findByLogin(login);}
    public UserEntity saveUser(UserEntity userEntity){return userRepo.save(userEntity);}
    @EventListener(ApplicationReadyEvent.class)
    public void basicMoviesInApp(){
        save(new MovieEntity(1L, "Titanic", 1999, "02:05:24", 9.99));
        save(new MovieEntity(2L, "Matrix", 2001, "01:43:42", 12.99));
        save(new MovieEntity(3L, "Fast and Furious", 2006, "01:54:12", 7.99));
        save(new MovieEntity(4L, "Hobbit", 2011, "02:32:21", 21.99));
        save(new MovieEntity(5L, "Fast and Furious", 2006, "02:07:34", 5.99));
    }
    @EventListener(ApplicationReadyEvent.class)
    public void adminUser(){
        saveUser(new UserEntity("Admin", "1234", "admin@wp.pl"));
    }

    public void addMovieToApp(){
        System.out.println("Podaj tytuł filmu: ");
        String title = scanner.next();
        System.out.println("Podaj rok produkcji: ");
        int productionYear = scanner.nextInt();
        System.out.println("Podaj czas trwania: hh:mm:ss");
        String duration = scanner.next();
        System.out.println("Podaj cene: ");
        double price = scanner.nextDouble();
        save(new MovieEntity(title, productionYear ,duration, price));
    }

}
