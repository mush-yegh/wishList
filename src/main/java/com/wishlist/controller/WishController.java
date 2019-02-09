package com.wishlist.controller;

import com.wishlist.service.WishService;
import com.wishlist.service.dto.WishDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/wishes")
public class WishController {
    @Autowired
    WishService wishService;

    @RequestMapping(value = "/{ownerId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<WishDto>> getUserWishList(@PathVariable Long ownerId) {
        List<WishDto> userWishList = wishService.getUserWishList(ownerId);
        return new ResponseEntity<>(userWishList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{ownerId}/{wishId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WishDto> getUserWishById(@PathVariable Long ownerId, @PathVariable Long wishId) {
        Optional<WishDto> userWish = wishService.getUserWish(ownerId, wishId);
        return userWish
                .map(wishDto -> new ResponseEntity<>(wishDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(userWish.get(), HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(value = "/{ownerId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<WishDto> addNewWish(@PathVariable Long ownerId, WishDto wishDto) {
        WishDto savedWish = wishService.saveWish(ownerId, wishDto);
        return new ResponseEntity<>(savedWish, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{ownerId}/{wishId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<WishDto> updateWish(@PathVariable Long ownerId, @PathVariable Long wishId, WishDto wishDto) {
        Optional<WishDto> updatedWish = wishService.updateWish(ownerId, wishId, wishDto);
        return updatedWish
                .map(wishDto1 -> new ResponseEntity<>(wishDto1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(updatedWish.get(), HttpStatus.BAD_REQUEST));
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
        wishService.deleteWishesByOwnerId(ownerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
