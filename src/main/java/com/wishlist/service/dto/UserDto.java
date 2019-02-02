package com.wishlist.service.dto;

import com.wishlist.persistance.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder*/
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;



    public static UserDto mapEntityToDto(Optional<UserEntity> userEntity){

        UserDto dto = new UserDto();

        /*dto.setId(userEntity.get().getId());
        dto.setFirstName(userEntity.get().getFirstName());
        dto.setLastName(userEntity.get().getLastName());
        dto.setMail(userEntity.get().getMail());*/
        return dto;
    }

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

}
