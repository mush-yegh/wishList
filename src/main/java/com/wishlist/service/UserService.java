package com.wishlist.service;

import com.wishlist.persistance.entity.CreateUser;
import com.wishlist.persistance.entity.UpdateUser;
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

    public UserDto findById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();

        return UserDto.mapEntityToDto(userEntity);
    }

    public List<UserDto> findAll() {

        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();

        return UserDto.mapUserEntitiesToDto(userEntities);
    }


    public UserDto saveUser(CreateUser user) {
        UserEntity userEntity = new UserEntity(user);

        UserEntity savedUser = userRepository.save(userEntity);
        return UserDto.mapEntityToDto(savedUser);
    }

    public Optional<UserDto> updateUser(UpdateUser updateUser) {

        Optional<UserEntity> userCandidate = userRepository.findById(updateUser.getId());

        if (userCandidate.isPresent()){
            UserEntity userToUpdate = new UserEntity(updateUser);
            UserEntity updatedUser = userRepository.save(userToUpdate);
            return Optional.of(UserDto.mapEntityToDto(updatedUser));
        }
        return Optional.empty();
    }
}
