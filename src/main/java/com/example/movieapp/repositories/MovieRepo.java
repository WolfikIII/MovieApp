package com.example.movieapp.repositories;

import com.example.movieapp.entities.MovieEntity;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<MovieEntity, Long> {
Optional<MovieEntity> findByTitle(String title);
@Query("Select m From MovieEntity m WHERE m.price<:price")
Iterable<MovieEntity> findByPrice(double price);
@Query("Select y From MovieEntity y Where y.productionYear>:year")
Iterable<MovieEntity> afterYear(int year);
}
