package com.wishlist.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sent_request")
public class SentRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity sentRequestOwner;
    /*@Column(name = "user_id", nullable = false)
    private Long user_id;*/


    @Column(name = "user_to_id", nullable = false)
    private Long userToId;


    @Column(name = "request_date", nullable = false)
    private LocalDate requestDate;


    @Column(name = "status", nullable = false)
    private Byte status;


    @Override
    public String toString() {
        return "SentRequestEntity{" +
                "id=" + id +
                ", userToId=" + userToId +
                ", requestDate=" + requestDate +
                ", status=" + status +
                '}';
    }
}
