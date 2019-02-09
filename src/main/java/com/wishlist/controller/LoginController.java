package com.wishlist.controller;

import com.wishlist.persistance.entity.UserEntity;
import com.wishlist.security.details.UserDetailsImpl;
import com.wishlist.service.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @GetMapping("/login")
    public ResponseEntity<HashMap> getLoginMessage(Authentication authentication) {
        HashMap<String, String> loginMessage = new HashMap<>();

        if (authentication != null) {
            loginMessage.put("message", "You're alreday loged in!");
            //loginMessage.put("info", UserDto.mapEntityToDto(authentication.getPrincipal()).getFirstName());
            UserDetailsImpl details  = (UserDetailsImpl)authentication.getPrincipal();

            loginMessage.put("info", UserDto.mapEntityToDto(details.getUser()).toString());
            return new ResponseEntity<>(loginMessage, HttpStatus.OK);
        }

        loginMessage.put("message", "Please POST to me your `login` and `password`");

        return new ResponseEntity<>(loginMessage, HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<>
}
