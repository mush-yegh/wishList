package com.wishlist.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "request")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "request",
            joinColumns = {@JoinColumn(name = "requester_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    @ElementCollection(targetClass = UserEntity.class)
    @Column(name = "requester_id")
    private List<UserEntity> requester;


    @ManyToMany
    @JoinTable(name = "request",
            joinColumns = {@JoinColumn(name = "receiver_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    @ElementCollection(targetClass = UserEntity.class)
    @Column(name = "receiver_id")
    private List<UserEntity> receiver;

    private Integer status;
    private LocalDate requestDate;
    private LocalDate respondDate;
}
