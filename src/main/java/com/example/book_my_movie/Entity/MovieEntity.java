package com.example.book_my_movie.Entity;


import com.example.book_my_movie.Enums.Genre;
import com.example.book_my_movie.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String movieName;
    private int duration;
    private double rating;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Enumerated(value = EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList  = new ArrayList<>();

}
