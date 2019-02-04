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
    @ResponseBody
    public ResponseEntity<List<UserDto>> getUsers() {
        //DEFAULT -if list is empty, returns empty list
        List<UserDto> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserDto>  getUserById(@PathVariable Long userId) {
        UserDto user = userService.findById(userId);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserDto> addUser(UserDto user){
        UserDto newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<UserDto> editUser(UserDto user){

        Optional<UserDto> updatedUser= userService.updateUser(user);
        if (updatedUser.isPresent()){
            return new ResponseEntity<>(updatedUser.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(updatedUser.get(),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteById(@PathVariable Long userId){
        Optional<Long> deletedUserId = userService.deleteUserById(userId);
        if (deletedUserId.isPresent()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
