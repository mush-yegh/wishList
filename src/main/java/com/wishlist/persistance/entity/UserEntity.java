package com.wishlist.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wishlist.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonManagedReference
    private List<WishEntity> wishes;

    public UserEntity(UserDto user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = LocalDate.parse(user.getBirthDate());
        this.mail = user.getMail();
        this.active = 1;
        this.created = LocalDate.now();
    }


}
