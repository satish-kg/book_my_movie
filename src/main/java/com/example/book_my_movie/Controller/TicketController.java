package com.example.book_my_movie.Controller;

import com.example.book_my_movie.EntryDTO.TickeEntryDTO;
import com.example.book_my_movie.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestBody TickeEntryDTO tickeEntryDTO){

        try{
            String result = ticketService.addTicket(tickeEntryDTO);
            return result;
        }catch (Exception e){
            return (e.getMessage()+" - addTicket Error.");
        }

    }

}
