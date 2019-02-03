package com.wishlist.controller;

import com.wishlist.persistance.entity.CreateUser;
import com.wishlist.persistance.entity.UpdateUser;
import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.service.UserService;
import com.wishlist.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        List<UserDto> users = userService.findAll();
        return users;
    }
    @RequestMapping(value = "users/{userId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<UserDto>  getUserById(@PathVariable Long userId) {
        UserDto user = userService.findById(userId);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "users/addNewUser", method = RequestMethod.POST)
    public UserDto addUser(CreateUser user){    //firstName, lastName, mail, birthDate
        UserDto newUser = userService.saveUser(user);
        return newUser;
    }


    @RequestMapping(value = "users", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<UserDto> editUser(UpdateUser user){

        Optional<UserDto> updatedUser= userService.updateUser(user);
        if (updatedUser.isPresent()){
            return new ResponseEntity(updatedUser,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
