package com.web.bloomingdales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.web.bloomingdales")
public class BloomingdalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloomingdalesApplication.class, args);
    }

}
