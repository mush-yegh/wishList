package com.wishlist.service.dto;

import com.wishlist.persistance.entity.RequestEntity;
import com.wishlist.persistance.entity.SentRequestEntity;
import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.entity.WishEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;
    private String lastName;

    private String mail;
    private String birthDate;

    //private List<WishEntity> wishes;

    private List<SentRequestEntity> sentRequests;

    //private List<RequestEntity> sentRequests;
    //private List<RequestEntity> receivedRequests;

    public static UserEntity mapDtoToEntity(UserDto userDto) {
        return UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .mail(userDto.getMail())
                .birthDate(LocalDate.parse(userDto.getBirthDate()))
                .active(1)
                .created(LocalDate.now())
                .build();
    }

    public static UserDto mapEntityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .mail(userEntity.getMail())
                .birthDate((userEntity.getBirthDate()).toString())
                //.wishes(userEntity.getWishes())
                //.sentRequests(userEntity.getSentRequests())
                //.receivedRequests(userEntity.getReceivedRequests())


                //.sentRequests(userEntity.getSentRequests())
                .build();
    }

    public static List<UserDto> mapEntityListToDto(List<UserEntity> userEntities) {

        return userEntities.stream()
                .map(UserDto::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
