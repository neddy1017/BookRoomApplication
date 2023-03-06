package com.example.sp;

import com.example.sp.Services.Impl.BookedRoomRepository;
import com.example.sp.Services.Impl.BookedServicesImpl;
import com.example.sp.entity.BookedRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class BookRoomApplicationTests {

	@Autowired
	private BookedRoomRepository bookedRoomRepository;

	@Test
	void findAllBybookRoomIDTest(){
		bookedRoomRepository.findAllBybookRoomID(1);
	}

	@Test
	void cancelRoomTest() throws Exception {
		bookedRoomRepository.deleteByid(15);
	}

	@Test
	void fetch_booked_roomsTest() throws Exception {
		bookedRoomRepository.findAll();
	}

}
