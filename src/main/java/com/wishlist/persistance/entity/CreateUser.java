package com.wishlist.persistance.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUser {
    private String firstName;
    private String lastName;
    private String mail;
    private String birthDate;
}
