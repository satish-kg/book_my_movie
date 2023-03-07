package com.example.book_my_movie.Service;

import com.example.book_my_movie.Convertor.MovieConvertor;
import com.example.book_my_movie.Entity.MovieEntity;
import com.example.book_my_movie.EntryDTO.MovieEntryDTO;
import com.example.book_my_movie.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDTO movieEntryDTO) throws Exception{

        MovieEntity movieEntity = MovieConvertor.movieEntryDTOtoMovieEntityConvertor(movieEntryDTO);
        movieRepository.save(movieEntity);
        return "Movie addedd successfully.";

    }

}
