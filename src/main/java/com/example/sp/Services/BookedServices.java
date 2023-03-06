package com.example.sp.Services;

import com.example.sp.entity.BookedRoom;

import java.util.List;

public interface BookedServices {
    List<BookedRoom> findAllBybookRoomID(int bookRoomID);
}
