package com.example.demo3.service;

import com.example.demo3.entity.User;
import com.example.demo3.exception.UserAlreadyExistsException;
import com.example.demo3.model.request.UserInputDTO;
import com.example.demo3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public void createUser(UserInputDTO userInputDTO){
        if (userRepository.existsByUserId(userInputDTO.getUserId())){
            throw new UserAlreadyExistsException("userid already exists");
        }
        User user = new User();
        user.setUserId(userInputDTO.getUserId());
        user.setPassword(passwordEncoder.encode(userInputDTO.getPassword()));
        userRepository.save(user);
    }
}
