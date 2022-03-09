package com.example.movieapp.repositories;

import com.example.movieapp.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);
    Optional<UserEntity> findByEmail(String email);
    @Query("Select u from UserEntity u WHERE u.login=:login and u.password=:password")
    Optional<UserEntity> checkUser(String login, String password);

}
