package com.example.book_my_movie.Entity;

import com.example.book_my_movie.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "showSeats")
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private int price;
    private boolean isBooked;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private Date bookedOn;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
