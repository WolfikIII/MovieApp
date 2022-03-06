package com.example.movieapp.repositories;

import com.example.movieapp.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<MovieEntity, Long> {
Optional<MovieEntity> findByTitle(String title);
}
