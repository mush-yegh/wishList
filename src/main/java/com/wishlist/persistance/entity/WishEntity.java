package com.wishlist.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.service.dto.WishDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wish")
public class WishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private UserEntity owner;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "created", nullable = false)
    private LocalDate created;

    @Column(name = "updated")
    private LocalDate updated;

    @Column(name = "active", nullable = false)
    private Integer active;

    //for WishService -> saveWish(wishDto)
    public WishEntity(WishDto wishDto) {
        this.title = wishDto.getTitle();
        this.link = wishDto.getLink();
        this.description = wishDto.getDescription();
        this.price = wishDto.getPrice();
    }

    @Override
    public String toString() {
        return "WishEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
