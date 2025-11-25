package com.midas.core; // <--- This was missing or incorrect!

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MidasCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidasCoreApplication.class, args);
    }

}