package com.example.demo3.controller;

import com.example.demo3.entity.User;
import com.example.demo3.exception.UserAlreadyExistsException;
import com.example.demo3.model.request.UserInputDTO;
import com.example.demo3.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserInputDTO userInputDTO){
           userService.createUser(userInputDTO);
           return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
