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
    private WishRepository wishRepository;
    @Autowired
    private UserRepository userRepository;

    public List<WishDto> getUserWishList(Long ownerId) {
        UserEntity owner = userRepository.findById(ownerId).get();

        List<WishEntity> wishEntities = wishRepository.findAllByOwnerAndActive(owner, 1);
        return WishDto.mapEntityListToDto(wishEntities);
    }

    public Optional<WishDto> getUserWish(Long ownerId, Long wishId) {
        UserEntity owner = userRepository.findById(ownerId).get();
        Optional<WishEntity> wishEntity = Optional.ofNullable(wishRepository.findWishEntityByOwnerAndId(owner, wishId));
        return wishEntity.map(WishDto::mapEntityToDto);
    }

    public WishDto saveWish(Long ownerId, WishDto wishDto) {

        WishEntity wishEntity = WishDto.mapDtoToEntity(wishDto);

        UserEntity owner = userRepository.findById(ownerId).get();

        wishEntity.setOwner(owner);
        wishEntity.setCreated(LocalDate.now());
        wishEntity.setActive(1);

        WishEntity savedWish = wishRepository.save(wishEntity);
        return WishDto.mapEntityToDto(savedWish);
    }

    public Optional<WishDto> updateWish(Long ownerId, Long wishId, WishDto wishDto) {

        UserEntity owner = userRepository.findById(ownerId).get();

        if (wishRepository.existsByOwnerAndId(owner, wishId)){
            WishEntity wishToUpdate = WishDto.mapDtoToEntity(wishDto);
            wishToUpdate.setId(wishDto.getId());

            WishEntity updatedWish = wishRepository.save(wishToUpdate);
            return Optional.of(WishDto.mapEntityToDto(updatedWish));
        }
        return Optional.empty();
    }

    public Optional<Long> deleteWishById(Long ownerId, Long wishId) {
        if (wishRepository.existsByOwnerAndId(userRepository.findById(ownerId).get(), wishId)) {
            WishEntity wishToDelete = wishRepository.findById(wishId).get();
            wishToDelete.setActive(0);
            wishRepository.save(wishToDelete);

            return Optional.of(wishId);
        }
        return Optional.empty();
    }

    public void deleteWishesByOwnerId(Long ownerId) {
        List<WishEntity> wishes = wishRepository.findAllByOwnerAndActive(userRepository.findById(ownerId).get(), 1);
        if (!wishes.isEmpty()) {
            wishes.stream().forEach(wishEntity -> wishEntity.setActive(0));

            wishRepository.saveAll(wishes);
        }
    }
}
