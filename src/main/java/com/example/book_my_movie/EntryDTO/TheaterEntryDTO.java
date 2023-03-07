package com.example.book_my_movie.EntryDTO;

import lombok.Data;

@Data
public class TheaterEntryDTO {

    private String name;
    private String location;
    private int regularSeatCount;
    private int reclinerSeatCount;
    private int sofaSeatCount;
    private int vipSeatCount;

}
