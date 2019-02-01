package com.wishlist.controller;

import com.wishlist.model.User;
import com.wishlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers(@RequestParam(name="lastName", required = false) String lastName) {
        List<User> users = null;
        if(lastName != null){
            users = userRepository.findByLastName(lastName);
        }else{
            users = (List<User>) userRepository.findAll();
        }
        return users;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addNewUser(User newUser) {
        System.out.println(newUser);
        userRepository.save(newUser);
        return "saved";
        //curl -d "firstName=Mushegh&lastName=Yegh&mail=mush@gmail.com&birthDate=1988-01-01" -X POST http://localhost:8080/addUser
    }
}
