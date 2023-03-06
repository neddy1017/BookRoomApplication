package com.example.sp.Services.Impl;


import com.example.sp.Services.BookedServices;
import com.example.sp.entity.BookedRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookedServicesImpl implements BookedServices {

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    //Fetch Booked Rooms
    public List<BookedRoom> fetchBookedRooms() {
        return bookedRoomRepository.findAll();
    }

    //fetchAvailableRooms
    public List<BookedRoom> fetchAvailableRooms(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        //預設room1 & room2
        List<BookedRoom> fetchAvailableRooms = new ArrayList<>();
        for(int i=1;i<=2;i++)
        {
            List<BookedRoom> bookedroom = checkIfRoomBooked(i,startDateTime,endDateTime);
            if(bookedroom.isEmpty())
            {
                BookedRoom bookedRoom = new BookedRoom();
                bookedRoom.setBookRoomID(i);
                fetchAvailableRooms.add(bookedRoom);
            }
        }

        return fetchAvailableRooms;
    }

    //book Room
    public ResponseEntity<BookedRoom> bookRoom(int bookRoomID, String roomName, LocalDateTime startDateTime, LocalDateTime endDateTime) throws Exception {
        //check if overlappingRooms
        List<BookedRoom> overlappingRooms = checkIfRoomBooked(bookRoomID, startDateTime, endDateTime);
        if (!overlappingRooms.isEmpty()) {
            return new ResponseEntity("The room is already booked for the selected time slot.", HttpStatus.BAD_REQUEST);
        }

        //save book room
        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setBookRoomID(bookRoomID);
        bookedRoom.setRoomName(roomName);
        bookedRoom.setStartDateTime(startDateTime);
        bookedRoom.setEndDateTime(endDateTime);
        bookedRoomRepository.save(bookedRoom);
        return new ResponseEntity<>(bookedRoom, HttpStatus.OK);
    }

    //Cancel Room
    public void cancelRoom(int id) {
            bookedRoomRepository.deleteByid(id);
    }


    @Override
    public List<BookedRoom> findAllBybookRoomID(int bookRoomID) {
        return bookedRoomRepository.findAllBybookRoomID(bookRoomID);
    }

    //check If Room have been Booked
    public List<BookedRoom> checkIfRoomBooked(int bookRoomID, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<BookedRoom> bookedroom = bookedRoomRepository.findAllBybookRoomID(bookRoomID);
        List<BookedRoom> exist = new ArrayList<>();
        for(BookedRoom i:bookedroom)
        {
            //判斷是否在時間區間內
            if( ((startDateTime.isAfter(i.getStartDateTime()) && startDateTime.isBefore(i.getEndDateTime())) || startDateTime.equals(i.getStartDateTime()) )
                    || ((endDateTime.isAfter(i.getStartDateTime()) && endDateTime.isBefore(i.getEndDateTime()))) || endDateTime.equals(i.getEndDateTime()))
            {
                exist.add(i);
            }
        }
        return exist;
    }
}
