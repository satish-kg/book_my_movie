package com.example.book_my_movie.Controller;

import com.example.book_my_movie.EntryDTO.ShowEntryDTO;
import com.example.book_my_movie.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDTO showEntryDTO){

        return null;

    }
}
