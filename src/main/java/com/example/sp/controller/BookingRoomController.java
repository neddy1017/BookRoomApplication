package com.example.sp.controller;

import com.example.sp.Services.Impl.BookedServicesImpl;
import com.example.sp.entity.BookedRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/bookingroom", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookingRoomController {

    private final BookedServicesImpl repository;

    BookingRoomController(BookedServicesImpl repository) {
        this.repository = repository;
    }

    // Book Room
    @PostMapping("/book_room")
    ResponseEntity<BookedRoom> book_room(@RequestParam int bookRoomID, @RequestParam String roomName, @RequestParam String startDateTime, @RequestParam String endDateTime) {
        try {
            System.out.println(bookRoomID+ " "+ roomName + startDateTime + endDateTime);

            //dateTime轉換
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime1 = LocalDateTime.parse(startDateTime, formatter);
            LocalDateTime dateTime2 = LocalDateTime.parse(endDateTime, formatter);

            return repository.bookRoom(bookRoomID, roomName, dateTime1, dateTime2);

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Cancel Room
    @GetMapping("/cancel_room")
    ResponseEntity cancel_room(int id) {
        try {
            repository.cancelRoom(id);
            return new ResponseEntity("delete successful id:"+id,
                    HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Fetch Available Rooms
    @GetMapping("/fetch_available_rooms")
    List<BookedRoom> fetch_available_rooms(String startDateTime, String endDateTime) {
        try {
            //dateTime轉換
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime1 = LocalDateTime.parse(startDateTime, formatter);
            LocalDateTime dateTime2 = LocalDateTime.parse(endDateTime, formatter);

            return repository.fetchAvailableRooms(dateTime1, dateTime2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //Fetch Booked Rooms
    @GetMapping("/fetch_booked_rooms")
    List<BookedRoom> fetch_booked_rooms() {
        try {
            return repository.fetchBookedRooms();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
