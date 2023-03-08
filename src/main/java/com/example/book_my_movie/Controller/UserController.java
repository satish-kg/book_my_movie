package com.example.book_my_movie.Controller;

import com.example.book_my_movie.EntryDTO.UserEntryDTO;
import com.example.book_my_movie.Service.UserService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UserEntryDTO userEntryDTO){
        try {
            String result = userService.addUser(userEntryDTO);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage()+" addUser Exception", HttpStatus.BAD_REQUEST);
        }
    }
}
