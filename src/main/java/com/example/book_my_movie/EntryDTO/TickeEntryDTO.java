package com.example.book_my_movie.EntryDTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TickeEntryDTO {

    private int showId;
    private int userId;
    private List<String> requestedSeats = new ArrayList<>();

}
