package com.wishlist.persistance.repository;

import com.wishlist.persistance.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    //List<UserEntity> findByLastName(String lastName);

    Optional<UserEntity> findById(Long userId);
}
