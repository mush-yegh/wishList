package com.wishlist.persistance.repository;

import com.wishlist.persistance.entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<WishEntity, Long> {

}
