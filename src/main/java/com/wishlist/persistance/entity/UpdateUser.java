package com.wishlist.persistance.entity;

import lombok.Data;

@Data
public class UpdateUser {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private String birthDate;
}
