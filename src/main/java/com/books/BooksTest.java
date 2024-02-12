package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.books.*")
public class BooksTest {
    public static void main(String[] args) {
        SpringApplication.run(BooksTest.class, args);
    }
}
