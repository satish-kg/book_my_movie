package com.example.book_my_movie.Repository;

import com.example.book_my_movie.Entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
}
