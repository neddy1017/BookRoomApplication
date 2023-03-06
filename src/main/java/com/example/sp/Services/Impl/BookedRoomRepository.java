package com.example.sp.Services.Impl;

import com.example.sp.entity.BookedRoom;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface BookedRoomRepository extends JpaRepository<BookedRoom, Long> {
    @Query("select b from BookedRoom b where b.bookRoomID = ?1")
    List<BookedRoom> findAllBybookRoomID(int bookRoomID);

//    @Query("select b.bookRoomID from BookedRoom b where b.endDateTime > ?1 and b.startDateTime < ?2")
//    List<BookedRoom> findAllByEndDateTimeAfterAndStartDateTimeBefore(LocalDateTime startDateTime, LocalDateTime endDateTime);

    @Transactional
    @Modifying
    @Query("delete from BookedRoom b where b.id = ?1")
    void deleteByid(int id);
}
