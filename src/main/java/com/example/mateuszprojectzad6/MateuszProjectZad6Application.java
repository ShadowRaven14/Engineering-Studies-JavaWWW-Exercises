package com.example.mateuszprojectzad6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;


@RestController
@SpringBootApplication
public class MateuszProjectZad6Application {

    public static void main(String[] args) {
        SpringApplication.run(MateuszProjectZad6Application.class, args);
    }

}
