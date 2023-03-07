package com.example.book_my_movie.Convertor;

import com.example.book_my_movie.Entity.MovieEntity;
import com.example.book_my_movie.EntryDTO.MovieEntryDTO;

public class MovieConvertor {

    public static MovieEntity movieEntryDTOtoMovieEntityConvertor(MovieEntryDTO movieEntryDTO){

        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDTO.getMovieName())
                .duration(movieEntryDTO.getDuration())
                .genre(movieEntryDTO.getGenre())
                .language(movieEntryDTO.getLanguage())
                .rating(movieEntryDTO.getRating()).build();

        return movieEntity;

    }
}
