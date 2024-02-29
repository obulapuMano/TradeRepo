package com.example.demo3.controller;

import com.example.demo3.model.request.TradeInputDTO;
import com.example.demo3.repository.TradeRepository;
import com.example.demo3.service.TradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    @Autowired
    TradeService tradeService;

    @PostMapping("/trade")
    public ResponseEntity<?>createTrade(@Valid @RequestBody TradeInputDTO tradeInputDTO){
        tradeService.createTrade(tradeInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
