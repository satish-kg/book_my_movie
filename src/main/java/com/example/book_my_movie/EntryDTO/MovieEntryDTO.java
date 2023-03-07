package com.example.book_my_movie.EntryDTO;

import com.example.book_my_movie.Enums.Genre;
import com.example.book_my_movie.Enums.Language;
import lombok.Data;


@Data
public class MovieEntryDTO {

    private String movieName;
    private int duration;
    private double rating;
    private Genre genre;
    private Language language;

}
