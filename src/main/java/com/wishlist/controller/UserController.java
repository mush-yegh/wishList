package com.wishlist.controller;

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

    @Autowired
    private UserRepository userRepository;

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserEntity> getAllUsers(@RequestParam(name="lastName", required = false) String lastName) {
        List<UserEntity> users = null;
        if(lastName != null){
            users = userRepository.findByLastName(lastName);
        }else{
            users = (List<UserEntity>) userRepository.findAll();
        }
        return users;
    }*/

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserDto getUserById(@PathVariable Long userId) {
        UserDto user = userService.findById(userId);
        return user;
    }


   /* @RequestMapping(value = "", method = RequestMethod.POST)
    public String addNewUser(UserEntity newUser) {
        System.out.println(newUser);
        userRepository.save(newUser);
        return "saved";
        //curl -d "firstName=Mushegh&lastName=Yegh&mail=mush@gmail.com&birthDate=1988-01-01" -X POST http://localhost:8080/addUser
    }*/
}
