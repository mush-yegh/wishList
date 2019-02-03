package com.wishlist.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.wishlist")
@EnableJpaRepositories(basePackages = "com.wishlist.persistance.repository")
@EntityScan(basePackages = "com.wishlist.persistance.entity")
class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
