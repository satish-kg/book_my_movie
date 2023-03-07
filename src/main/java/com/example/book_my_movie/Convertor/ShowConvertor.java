package com.example.book_my_movie.Convertor;

import com.example.book_my_movie.Entity.ShowEntity;
import com.example.book_my_movie.EntryDTO.ShowEntryDTO;

public class ShowConvertor {

    public static ShowEntity showEntryDTOtoShowEntityConvertor(ShowEntryDTO showEntryDTO){

        ShowEntity showEntity = ShowEntity.builder()
                .showTime(showEntryDTO.getShowTime())
                .showDate(showEntryDTO.getShowDate())
                .showType(showEntryDTO.getShowType())
                .build();

        return showEntity;

    }
}
