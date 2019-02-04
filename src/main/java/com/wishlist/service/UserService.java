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

    public UserDto findById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();

        return UserDto.mapEntityToDto(userEntity);
    }

    public List<UserDto> findAll() {

        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();

        return UserDto.mapUserEntitiesToDto(userEntities);
    }


    public UserDto saveUser(UserDto user) {
        UserEntity userEntity = new UserEntity(user);

        UserEntity savedUser = userRepository.save(userEntity);
        //in case of sqlException(non unique mail) what to do ?
        return UserDto.mapEntityToDto(savedUser);
    }

    public Optional<UserDto> updateUser(UserDto user) {

        Optional<UserEntity> userCandidate = userRepository.findById(user.getId());

        if (userCandidate.isPresent()){
            UserEntity userToUpdate = new UserEntity(user);
            userToUpdate.setId(user.getId());
            UserEntity updatedUser = userRepository.save(userToUpdate);
            return Optional.of(UserDto.mapEntityToDto(updatedUser));
        }
        return Optional.empty();
    }
}
