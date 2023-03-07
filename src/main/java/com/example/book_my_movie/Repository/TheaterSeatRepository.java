package com.example.book_my_movie.Repository;

import com.example.book_my_movie.Entity.TheaterSeatEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity, Integer> {
}
