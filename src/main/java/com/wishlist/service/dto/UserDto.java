package com.wishlist.service.dto;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.entity.WishEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<WishEntity> wishes;

    public static UserDto mapEntityToDto(UserEntity userEntity) {

        UserDto dto = new UserDto();

        dto.setId(userEntity.getId());
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setWishes(userEntity.getWishes());
        return dto;
    }

}
