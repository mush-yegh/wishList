package com.wishlist.controller;

import com.wishlist.persistance.entity.RequestEntity;
import com.wishlist.persistance.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/requests")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<RequestEntity>> getAllRequests() {
        List<RequestEntity> requestEntities = requestRepository.findAll();
        return new ResponseEntity<>(requestEntities, HttpStatus.OK);
    }
}
