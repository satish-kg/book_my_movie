package com.example.book_my_movie.Convertor;

import com.example.book_my_movie.Entity.UserEntity;
import com.example.book_my_movie.EntryDTO.UserEntryDTO;
import org.apache.catalina.User;

public class UserConvertor {

    public static UserEntity userEntryDTOtoUserEntityConvertor(UserEntryDTO userEntryDTO){

        UserEntity userEntity = UserEntity.builder()
                .name(userEntryDTO.getName())
                .age(userEntryDTO.getAge())
                .address(userEntryDTO.getAddress())
                .email(userEntryDTO.getEmail())
                .mobileNo(userEntryDTO.getMobileNo())
                .build();

        return userEntity;

    }
}
