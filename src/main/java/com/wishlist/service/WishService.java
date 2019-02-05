package com.wishlist.service;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.entity.WishEntity;
import com.wishlist.persistance.repository.UserRepository;
import com.wishlist.persistance.repository.WishRepository;
import com.wishlist.service.dto.WishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WishService {
    @Autowired
    WishRepository wishRepository;
    @Autowired
    UserRepository userRepository;

    public List<WishDto> getUserWishList(Long ownerId) {
        UserEntity owner = userRepository.findById(ownerId).get();

        List<WishEntity> wishEntities = wishRepository.findAllByOwner(owner);
        return WishDto.mapEntityListToDto(wishEntities);
    }

    public Optional<WishDto> getUserWish(Long ownerId, Long wishId) {
        UserEntity owner = userRepository.findById(ownerId).get();
        Optional<WishEntity> wishEntity = Optional.ofNullable(wishRepository.findWishEntityByOwnerAndId(owner, wishId));
        if (wishEntity.isPresent()) {
            return Optional.of( WishDto.mapEntityToDto(wishEntity.get()) );
        }
        return Optional.empty();
    }

    public WishDto saveWish(Long ownerId, WishDto wishDto) {
        WishEntity wishEntity = new WishEntity(wishDto);
        UserEntity owner = userRepository.findById(ownerId).get();
        wishEntity.setOwner(owner);
        wishEntity.setCreated(LocalDate.now());
        wishEntity.setActive(1);
        WishEntity savedWish = wishRepository.save(wishEntity);
        return WishDto.mapEntityToDto(savedWish);
    }
}
