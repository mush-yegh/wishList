package com.wishlist.service;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.repository.UserRepository;
import com.wishlist.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto findById(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        return (UserDto) UserDto.mapEntityToDto(userEntity);
    }
}
