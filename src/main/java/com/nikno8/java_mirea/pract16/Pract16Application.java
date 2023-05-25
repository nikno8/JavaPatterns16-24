package com.nikno8.java_mirea.pract16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
@EnableScheduling
@EnableJdbcHttpSession
public class Pract16Application {
    public static void main(String[] args) {
        SpringApplication.run(Pract16Application.class);
    }
}