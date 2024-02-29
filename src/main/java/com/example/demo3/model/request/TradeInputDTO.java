package com.example.demo3.model.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TradeInputDTO {
    @Max(value = 1000,message = " should not be greater than 1000")
    @Min(value = 1,message = " should not be less than 1")
    private int quantity;
    @DecimalMin(value = "0.1",message = " should not be less than 0.1")
    private Double price;
    private  String currency="JPY";
    @NotBlank(message = " should not be blank")
    @Pattern(regexp = "[BSC]",message = " should be either B,S,C")
    private String buySell;
    private String assetType="EQUITY";
    private String originCountry="JP";
}
