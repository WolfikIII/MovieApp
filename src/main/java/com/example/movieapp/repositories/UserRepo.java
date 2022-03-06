package com.example.movieapp.repositories;

import com.example.movieapp.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
    UserEntity findByEmail(String email);
    @Query("Select u from UserEntity u WHERE u.login=:login and u.password=:password")
    UserEntity findUser(@Param("login") String login, @Param("password") String password);
}
