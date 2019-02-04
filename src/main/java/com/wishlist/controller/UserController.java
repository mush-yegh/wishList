package com.wishlist.controller;

import com.wishlist.service.UserService;
import com.wishlist.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        List<UserDto> users = userService.findAll();
        return users;
    }
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<UserDto>  getUserById(@PathVariable Long userId) {
        UserDto user = userService.findById(userId);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public UserDto addUser(UserDto user){
        UserDto newUser = userService.saveUser(user);
        return newUser;
    }

//TO DO
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<UserDto> editUser(UserDto user){

        Optional<UserDto> updatedUser= userService.updateUser(user);
        if (updatedUser.isPresent()){
            return new ResponseEntity(updatedUser,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
