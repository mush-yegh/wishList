package com.wishlist.controller;

import com.wishlist.service.WishService;
import com.wishlist.service.dto.WishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/wishes")
public class WishController {
    @Autowired
    WishService wishService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WishDto> getUserWishList(@PathVariable Long userId) {
        List<WishDto> userWishList = wishService.getUserWishList(userId);
        return new ResponseEntity(userWishList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}/{wishId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUserWishById(@PathVariable Long userId, @PathVariable Long wishId) {
        Optional<WishDto> userWish = wishService.getUserWish(userId, wishId);
        if (userWish.isPresent()){
            return new ResponseEntity(userWish,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
