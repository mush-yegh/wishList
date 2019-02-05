package com.wishlist.service.dto;

import com.wishlist.persistance.entity.WishEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishDto {
    private Long id;
    private Long ownerId;
    private String title;
    private String link;
    private String description;
    private Double price;

    public static List<WishDto> mapEntityListToDto(List<WishEntity> wishList){
        return wishList.stream()
                .map(WishDto::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public static WishDto mapEntityToDto(WishEntity wish){
        return WishDto.builder()
                .id(wish.getId())
                .ownerId(wish.getOwner().getId())
                .title(wish.getTitle())
                .link(wish.getLink())
                .description(wish.getDescription())
                .price(wish.getPrice())
                .build();
    }
}
