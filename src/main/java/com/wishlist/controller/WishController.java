package com.wishlist.controller;

import com.wishlist.service.WishService;
import com.wishlist.service.dto.WishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/wishes")
public class WishController {
    @Autowired
    WishService wishService;

    @RequestMapping(value = "/{ownerId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WishDto> getUserWishList(@PathVariable Long ownerId) {
        List<WishDto> userWishList = wishService.getUserWishList(ownerId);
        return new ResponseEntity(userWishList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{ownerId}/{wishId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WishDto> getUserWishById(@PathVariable Long ownerId, @PathVariable Long wishId) {
        Optional<WishDto> userWish = wishService.getUserWish(ownerId, wishId);
        if (userWish.isPresent()) {
            return new ResponseEntity(userWish, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{ownerId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<WishDto> addNewWish(@PathVariable Long ownerId, WishDto wishDto) {
        WishDto savedWish = wishService.saveWish(ownerId, wishDto);
        return new ResponseEntity<>(savedWish, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{ownerId}/{wishId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<WishDto> updateWish(@PathVariable Long ownerId, @PathVariable Long wishId) {
        //TO DO
        throw new NotImplementedException();
    }

    @RequestMapping(value = "/{ownerId}/{wishId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteWish(@PathVariable Long ownerId, @PathVariable Long wishId) {

        Optional<Long> deletedWishId = wishService.deleteWishById(ownerId, wishId);

        if (deletedWishId.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/{ownerId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteWishes(@PathVariable Long ownerId) {
        wishService.deleteWishesByOwnerd(ownerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
