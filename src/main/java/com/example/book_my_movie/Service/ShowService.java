package com.example.book_my_movie.Service;

import com.example.book_my_movie.Controller.ShowController;
import com.example.book_my_movie.Convertor.ShowConvertor;
import com.example.book_my_movie.Entity.*;
import com.example.book_my_movie.EntryDTO.ShowEntryDTO;
import com.example.book_my_movie.Enums.SeatType;
import com.example.book_my_movie.Repository.MovieRepository;
import com.example.book_my_movie.Repository.ShowRepository;
import com.example.book_my_movie.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String addShow(ShowEntryDTO showEntryDTO){

        ShowEntity showEntity = ShowConvertor.showEntryDTOtoShowEntityConvertor(showEntryDTO);

        int movieId = showEntryDTO.getMovieId();
        int theaterId = showEntryDTO.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();

        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        List<ShowSeatEntity> showSeatEntityList = createShowSeatEntity(showEntryDTO, showEntity);

        showEntity.setListOfShowSeats(showSeatEntityList);

        List<ShowEntity> showEntityList = movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);

        movieRepository.save(movieEntity);

        List<ShowEntity> showEntityList1 = theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);

        theaterRepository.save(theaterEntity);

        return "The show has been added successfully.";

    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDTO showEntryDTO, ShowEntity showEntity){

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();
        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.REGULAR)){
                showSeatEntity.setPrice(showEntryDTO.getRegularSeatPrice());
            }else if(theaterSeatEntity.getSeatType().equals(SeatType.RECLINER)){
                showSeatEntity.setPrice(showEntryDTO.getReclinerSeatPrice());
            }else if(theaterSeatEntity.getSeatType().equals(SeatType.SOFA_SEATS)){
                showSeatEntity.setPrice(showEntryDTO.getSofaSeatPrice());
            }else{
                showSeatEntity.setPrice(showEntryDTO.getVipSeatPrice());
            }

            showSeatEntity.setBooked(true);
            showSeatEntity.setShowEntity(showEntity);

            seatEntityList.add(showSeatEntity);

        }
        return seatEntityList;

    }
}
