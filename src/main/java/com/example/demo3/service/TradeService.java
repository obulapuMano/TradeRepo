package com.example.demo3.service;

import com.example.demo3.entity.Trade;
import com.example.demo3.model.request.TradeInputDTO;
import com.example.demo3.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    @Autowired
    TradeRepository tradeRepository;

    public void createTrade(TradeInputDTO tradeInputDTO){
        Trade trade = new Trade();
        trade.setQuantity(tradeInputDTO.getQuantity());
        trade.setPrice(tradeInputDTO.getPrice());
        trade.setCurrency(tradeInputDTO.getCurrency());
        trade.setBuySell(tradeInputDTO.getBuySell());
        trade.setAssetType(tradeInputDTO.getAssetType());
        trade.setOriginCountry(tradeInputDTO.getOriginCountry());
        tradeRepository.save(trade);
    }
}
