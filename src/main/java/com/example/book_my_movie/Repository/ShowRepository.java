package com.example.book_my_movie.Repository;

import com.example.book_my_movie.Entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {
}
