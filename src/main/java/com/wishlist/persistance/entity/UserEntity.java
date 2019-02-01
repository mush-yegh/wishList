package com.wishlist.persistance.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mail", unique=true, nullable = false)
    private String mail;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "active")
    private Byte active;

    @Column(name = "created")
    private LocalDate created;


    //=======================================================
    /*@OneToMany(mappedBy = "owner", targetEntity = WishEntity.class)
    private List<WishEntity> wishes;

    public List<WishEntity> getWishes() {
        return wishes;
    }

    public void setWishes(List<WishEntity> wishes) {
        this.wishes = wishes;
    }*/
    //=======================================================


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {

        this.birthDate = LocalDate.parse(birthDate);
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                ", created=" + created +
                '}';
    }
}
