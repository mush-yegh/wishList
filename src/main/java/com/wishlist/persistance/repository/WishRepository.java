package com.wishlist.persistance.repository;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishRepository extends JpaRepository<WishEntity, Long> {

    List<WishEntity> findAllByOwner(UserEntity owner);

    List<WishEntity> findAllByOwnerAndActive(UserEntity owner, Integer active);

    WishEntity findWishEntityByOwnerAndId(UserEntity owner, Long wishId);

    boolean existsByOwnerAndId(UserEntity owner, Long wishId);

}
