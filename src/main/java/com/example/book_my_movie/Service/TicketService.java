package com.example.book_my_movie.Service;

import com.example.book_my_movie.Convertor.TicketConvertor;
import com.example.book_my_movie.Entity.ShowEntity;
import com.example.book_my_movie.Entity.ShowSeatEntity;
import com.example.book_my_movie.Entity.TicketEntity;
import com.example.book_my_movie.Entity.UserEntity;
import com.example.book_my_movie.EntryDTO.TickeEntryDTO;
import com.example.book_my_movie.Repository.ShowRepository;
import com.example.book_my_movie.Repository.TicketRepository;
import com.example.book_my_movie.Repository.UserRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String addTicket(TickeEntryDTO tickeEntryDTO) throws Exception{

        boolean isValidRequest = checkValidityOfRequestedSeats(tickeEntryDTO);
        if(isValidRequest == false){
            throw new Exception("Requested seats are not available.");
        }
        TicketEntity ticketEntity = TicketConvertor.ticketEntryDTOtoTicketEntityConvertor(tickeEntryDTO);
        ShowEntity showEntity = showRepository.findById(tickeEntryDTO.getShowId()).get();
        List<ShowSeatEntity> seatEntityList = showEntity.getListOfShowSeats();
        List<String> requestedSeats = tickeEntryDTO.getRequestedSeats();

        int totalAmount = 0;

        for(ShowSeatEntity showSeatEntity : seatEntityList){
            if(requestedSeats.contains(showSeatEntity.getSeatNo())){
                totalAmount += showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedOn(new Date());
            }
        }

        ticketEntity.setTotalAmount(totalAmount);

        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());

        String allotedSeats = getAllotedSeatsFromShowSeats(requestedSeats);
        ticketEntity.setBookedSeats(allotedSeats);

        UserEntity userEntity = userRepository.findById(tickeEntryDTO.getUserId()).get();

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTickets(ticketEntityList);

        showRepository.save(showEntity);

        List<TicketEntity> ticketEntityList1 = userEntity.getBookedTicketList();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTicketList(ticketEntityList1);

        userRepository.save(userEntity);

        return "Ticket added successfully.";
    }

    private String getAllotedSeatsFromShowSeats(List<String> requestedSeats){

        String result = "";
        for(String seat : requestedSeats){
            result = result + seat + ", ";
        }
        return result;

    }
    private boolean checkValidityOfRequestedSeats(TickeEntryDTO tickeEntryDTO){

        int showId = tickeEntryDTO.getShowId();
        List<String> requestedSeats = tickeEntryDTO.getRequestedSeats();
        ShowEntity showEntity = showRepository.findById(showId).get();
        List<ShowSeatEntity> listOfSeats = showEntity.getListOfShowSeats();

        for (ShowSeatEntity showSeatEntity : listOfSeats){
            String seatNo = showSeatEntity.getSeatNo();
            if(requestedSeats.contains(seatNo)){
                if(showSeatEntity.isBooked()==true){
                    return false;
                }
            }
        }

        return true;
    }


}
