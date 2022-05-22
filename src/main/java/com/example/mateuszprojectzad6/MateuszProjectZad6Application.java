package com.example.mateuszprojectzad6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

//@EntityScan("com.example.mateuszprojectzad6.models")
//@EnableJpaRepositories("com.example.mateuszprojectzad6.repositories")


@RestController
@SpringBootApplication
public class MateuszProjectZad6Application {

    public static void main(String[] args) {
        SpringApplication.run(MateuszProjectZad6Application.class, args);
    }

}
