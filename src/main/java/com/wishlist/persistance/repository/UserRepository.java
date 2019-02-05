package com.wishlist.persistance.repository;

import com.wishlist.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    //List<UserEntity> findAllByFirstName();

    Optional<UserEntity> findById(Long userId);

    List<UserEntity> findAllByActive(Integer val);
}
