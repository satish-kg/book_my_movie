package com.example.book_my_movie.Entity;

import com.example.book_my_movie.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theaterSeats")
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private String seatNo;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

}
