package com.example.book_my_movie.Service;

import com.example.book_my_movie.Convertor.UserConvertor;
import com.example.book_my_movie.Entity.UserEntity;
import com.example.book_my_movie.EntryDTO.UserEntryDTO;
import com.example.book_my_movie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDTO userEntryDTO) throws Exception, NullPointerException{

        UserEntity userEntity = UserConvertor.userEntryDTOtoUserEntityConvertor(userEntryDTO);
        userRepository.save(userEntity);
        return "User Added Successfully.";

    }
}
