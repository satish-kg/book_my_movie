package com.example.book_my_movie.EntryDTO;

import com.example.book_my_movie.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDTO {

    private LocalTime showTime;
    private LocalDate showDate;
    private ShowType showType;
    private int movieId;
    private int theaterId;
    private int regularSeatPrice;
    private int reclinerSeatPrice;
    private int sofaSeatPrice;
    private int vipSeatPrice;

}
