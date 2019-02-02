package com.wishlist.persistance.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "user")
//@ToString(exclude = "wishes")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mail", unique = true, nullable = false)
    private String mail;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "active")
    private Byte active;

    @Column(name = "created")
    private LocalDate created;

    @OneToMany(mappedBy = "owner")
    private List<WishEntity> wishes;


    public void setBirthDate(String birthDate) {

        this.birthDate = LocalDate.parse(birthDate);
    }

}
