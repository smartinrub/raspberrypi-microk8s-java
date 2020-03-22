package com.sergiomartinrubio.raspberrypimicrok8sjava;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/uppercase/{input}")
    public String uppercase(@PathVariable("input") String input) {
        log.info("Converting string to uppercase...");
        return input.toUpperCase();
    }
}
