package com.wishlist.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wishlist.service.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
//@ToString(exclude = "wishes")
//@ToString(exclude = "requests")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "mail", unique = true, nullable = false)
    private String mail;

    @Column(name = "password", nullable = false)
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "state", nullable = false)
    private State state;

    @Column(name = "active")
    private Integer active;

    @Column(name = "created")
    private LocalDate created;

    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<WishEntity> wishes;

//    @OneToMany(mappedBy = "sentRequestOwner")
//    @JsonBackReference
//    private List<SentRequestEntity> sentRequests;


    /*@OneToMany(mappedBy = "requester")
    @JsonManagedReference
    private List<RequestEntity> sentRequests;


    @OneToMany(mappedBy = "receiver")
    @JsonManagedReference
    private List<RequestEntity> receivedRequests;*/

}
