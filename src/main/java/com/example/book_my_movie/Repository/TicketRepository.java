package com.example.book_my_movie.Repository;

import com.example.book_my_movie.Entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
