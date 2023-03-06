package com.example.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class BookRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookRoomApplication.class, args);
    }

}
