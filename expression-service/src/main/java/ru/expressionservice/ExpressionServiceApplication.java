package ru.expressionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExpressionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExpressionServiceApplication.class, args);
    }
}
