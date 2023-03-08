package com.example.book_my_movie.Controller;

import com.example.book_my_movie.EntryDTO.MovieEntryDTO;
import com.example.book_my_movie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie (@RequestBody MovieEntryDTO movieEntryDTO){

        try {
            String result = movieService.addMovie(movieEntryDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            String response = "Movie not added.";
            return new ResponseEntity<>(response + "SEE THIS", HttpStatus.BAD_REQUEST);
        }

    }
}
