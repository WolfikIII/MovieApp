package com.example.movieapp.service;

import com.example.movieapp.entities.UserEntity;
import com.example.movieapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ServiceUser {
    Scanner scan = new Scanner(System.in);
    private UserRepo userRepo;
    private com.example.movieapp.service.Service service;
    @Autowired
    public ServiceUser (UserRepo userRepo){this.userRepo = userRepo;}
    public UserEntity findByLogin (String login){return userRepo.findByLogin(login);}
    public UserEntity findByEmail (String email){return userRepo.findByEmail(email);}
    public UserEntity saveUser (UserEntity user){return userRepo.save(user);}
    @EventListener(ApplicationReadyEvent.class)
    public void adminUser(){
        saveUser(new UserEntity("Admin", "1234", "admin@wp.pl"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void signIn(){
        System.out.println("Wpisz login ");
        String login = scan.next();
        System.out.println("Wpisz hasło: ");
        String password = scan.next();
     // if(userRepo.findUser(login, password)!=null){
         // System.out.println("OK");
     // }

    }


}
