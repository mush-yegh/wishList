package com.wishlist.controller;

import com.wishlist.service.WishService;
import com.wishlist.service.dto.WishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
