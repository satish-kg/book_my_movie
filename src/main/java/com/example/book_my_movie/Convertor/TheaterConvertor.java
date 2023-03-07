package com.example.book_my_movie.Convertor;

import com.example.book_my_movie.Entity.TheaterEntity;
import com.example.book_my_movie.EntryDTO.TheaterEntryDTO;

public class TheaterConvertor {

    public static TheaterEntity theaterEntryDTOtoTheaterEntityConvertor(TheaterEntryDTO theaterEntryDTO){

        TheaterEntity theaterEntity = TheaterEntity.builder()
                .name(theaterEntryDTO.getName())
                .location(theaterEntryDTO.getLocation())
                .build();

        return theaterEntity;

    }
}
