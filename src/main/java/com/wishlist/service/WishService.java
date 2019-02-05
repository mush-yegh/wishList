package com.wishlist.service;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.entity.WishEntity;
import com.wishlist.persistance.repository.UserRepository;
import com.wishlist.persistance.repository.WishRepository;
import com.wishlist.service.dto.WishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    @Autowired
    WishRepository wishRepository;
    @Autowired
    UserRepository userRepository;

    public List<WishDto> getUserWishList(Long userId) {
        UserEntity owner = userRepository.findById(userId).get();

        List<WishEntity> wishEntities = wishRepository.findAllByOwner(owner);
        return WishDto.mapEntityListToDto(wishEntities);
    }
}
