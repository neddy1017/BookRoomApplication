package com.example.sp.entity;


import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rooms")
public class BookedRoom {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @javax.persistence.Id
        private int id;

        @Column(name = "bookRoomID")
        private int bookRoomID;

        @Column(name = "roomName")
        private String roomName;

        @Column(name = "startDateTime")
        private LocalDateTime startDateTime;

        @Column(name = "endDateTime")
        private LocalDateTime endDateTime;


        //getter & setter
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getRoomName() {
                return roomName;
        }

        public void setRoomName(String roomName) {
                this.roomName = roomName;
        }

        public LocalDateTime getStartDateTime() {
                return startDateTime;
        }

        public void setStartDateTime(LocalDateTime startDateTime) {
                this.startDateTime = startDateTime;
        }

        public LocalDateTime getEndDateTime() {
                return endDateTime;
        }

        public void setEndDateTime(LocalDateTime endDateTime) {
                this.endDateTime = endDateTime;
        }

        public int getBookRoomID() {
                return bookRoomID;
        }

        public void setBookRoomID(int bookRoomID) {
                this.bookRoomID = bookRoomID;
        }


}
