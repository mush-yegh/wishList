package com.wishlist.controller;

import com.wishlist.persistance.entity.CreateUser;
import com.wishlist.service.UserService;
import com.wishlist.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserDto addUser(CreateUser user){    //firstName, lastName, mail, birthDate
        UserDto newUser = userService.saveUser(user);
        return newUser;
    }


}
