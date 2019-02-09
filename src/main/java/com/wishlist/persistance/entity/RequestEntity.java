package com.wishlist.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString(exclude = "requester")
@Entity
@Table(name = "request", catalog = "wishlist_test")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id", unique = true, nullable = false)
    private Long reqId;


    /*@Column(name = "requester_id", nullable = false)
    private Long requesterId;*/

    /*@Column(name = "receiver_id", nullable = false)
    private Long receiverId;*/

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "request_date", nullable = false)
    private LocalDate requestDate;

    @Column(name = "respond_date")
    private LocalDate respondDate;


    /*@ManyToMany
    @JoinTable(name = "user_request",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "req_id")})
    @ElementCollection(targetClass = UserEntity.class)
    //private UserEntity reqOwner;
    private List<UserEntity> users;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id")
    @JsonBackReference
    private UserEntity requester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    @JsonBackReference
    private UserEntity receiver;


    @Override
    public String toString() {
        return "RequestEntity{" +
                "reqId=" + reqId +
                ", status=" + status +
                ", requestDate=" + requestDate +
                ", respondDate=" + respondDate +
                '}';
    }
}
