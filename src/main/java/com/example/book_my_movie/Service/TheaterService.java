package com.example.book_my_movie.Service;

import com.example.book_my_movie.Convertor.TheaterConvertor;
import com.example.book_my_movie.Entity.TheaterEntity;
import com.example.book_my_movie.Entity.TheaterSeatEntity;
import com.example.book_my_movie.EntryDTO.TheaterEntryDTO;
import com.example.book_my_movie.Enums.SeatType;
import com.example.book_my_movie.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatEntity theaterSeatEntity;

    public String addTheater(TheaterEntryDTO theaterEntryDTO) throws Exception{

        if(theaterEntryDTO.getName() == null || theaterEntryDTO.getLocation() == null){
            throw new Exception("Name and location should be valid!!");
        }

        TheaterEntity theaterEntity = TheaterConvertor.theaterEntryDTOtoTheaterEntityConvertor(theaterEntryDTO);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeat(theaterEntryDTO, theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);

        return "Theater added successfully.";

    }

    private List<TheaterSeatEntity> createTheaterSeat (TheaterEntryDTO theaterEntryDTO, TheaterEntity theaterEntity){

        int numOfRegularSeats = theaterEntryDTO.getRegularSeatCount();
        int numOfReclinerSeats = theaterEntryDTO.getReclinerSeatCount();
        int numOfSofaSeats = theaterEntryDTO.getSofaSeatCount();
        int numOfVipSeats = theaterEntryDTO.getVipSeatCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        for(int count = 1; count <= numOfRegularSeats; count++){
            TheaterSeatEntity theaterSeatEntity1 = TheaterSeatEntity.builder()
                    .seatType(SeatType.REGULAR)
                    .seatNo(count+"REG")
                    .theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        for(int count = 1; count <= numOfReclinerSeats; count++){
            TheaterSeatEntity theaterSeatEntity1 = TheaterSeatEntity.builder()
                    .seatType(SeatType.RECLINER)
                    .seatNo(count+"REC")
                    .theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        for(int count = 1; count <= numOfSofaSeats; count++){
            TheaterSeatEntity theaterSeatEntity1 = TheaterSeatEntity.builder()
                    .seatType(SeatType.SOFA_SEATS)
                    .seatNo(count+"SOFA")
                    .theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        for(int count = 1; count <= numOfVipSeats; count++){
            TheaterSeatEntity theaterSeatEntity1 = TheaterSeatEntity.builder()
                    .seatType(SeatType.VIP)
                    .seatNo(count+"VIP")
                    .theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;
    }

}
