package com.wishlist.service;

import com.wishlist.persistance.entity.CreateUser;
import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.repository.UserRepository;
import com.wishlist.service.dto.UserDto;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto findById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();

        return UserDto.mapEntityToDto(userEntity);
    }

    public List<UserDto> findAll(){

        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();

        return UserDto.mapUserEntitiesToDto(userEntities);
    }


    public UserDto save(CreateUser user) {
        UserEntity postedUser = new UserEntity(user);

        UserEntity userEntity = userRepository.save(postedUser);
        return UserDto.mapEntityToDto(userEntity);
    }
}
