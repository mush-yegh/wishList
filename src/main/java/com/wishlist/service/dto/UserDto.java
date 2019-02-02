package com.wishlist.service.dto;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.entity.WishEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<WishEntity> wishes;

    public static UserDto mapEntityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .wishes(userEntity.getWishes())
                .build();
    }

    public static List<UserDto> mapUserEntitiesToDto(List<UserEntity> userEntities){

        return userEntities.stream()
                .map(UserDto::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
