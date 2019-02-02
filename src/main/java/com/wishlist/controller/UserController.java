package com.wishlist.controller;

import com.wishlist.persistance.entity.CreateUser;
import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.persistance.repository.UserRepository;
import com.wishlist.service.UserService;
import com.wishlist.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        List<UserDto> users = userService.findAll();
        return users;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserDto getUserById(@PathVariable Long userId) {
        UserDto user = userService.findById(userId);
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    //                                firstName, lastName, mail, birthDate
    public UserDto addUser(CreateUser user){
        UserDto newUser = userService.save(user);
        return newUser;
    }


}
