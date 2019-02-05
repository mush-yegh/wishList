package com.wishlist.service;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.repository.UserRepository;
import com.wishlist.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserDto> findAllActiveUsers() {

        List<UserEntity> userEntities = userRepository.findAllByActive(1);

        return UserDto.mapEntitiyListToDto(userEntities);
    }

    //TO DO - have to retrieve a user with isActive: 1 and userId: {userId}
    public Optional<UserDto> findById(Long userId) {

        if (userRepository.existsById(userId)) {
            UserEntity userEntity = userRepository.findById(userId).get();
            return Optional.of(UserDto.mapEntityToDto(userEntity));
        }
        return Optional.empty();
    }


    public UserDto saveUser(UserDto user) {
        UserEntity userEntity = new UserEntity(user);

        UserEntity savedUser = userRepository.save(userEntity);
        //in case of sqlException(non unique mail) what to do ?
        return UserDto.mapEntityToDto(savedUser);
    }

    public Optional<UserDto> updateUser(UserDto user) {

        if (userRepository.existsById(user.getId())) {
            UserEntity userToUpdate = new UserEntity(user);
            userToUpdate.setId(user.getId());
            UserEntity updatedUser = userRepository.save(userToUpdate);
            return Optional.of(UserDto.mapEntityToDto(updatedUser));
        }
        return Optional.empty();
    }

    public Optional<Long> deleteUserById(Long userId) {

        if (userRepository.existsById(userId)) {
            UserEntity userToDelete = userRepository.findById(userId).get();
            userToDelete.setActive(0);
            userRepository.save(userToDelete);

            return Optional.of(userId);
        }
        return Optional.empty();
    }
}
