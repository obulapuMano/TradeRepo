package com.example.demo3.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserInputDTO {
    @NotBlank(message = " should not be blank")
    @Email(message = " should follow proper email format")
    private String userId;
    @NotBlank(message = " should not be blank")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,16}$")
    private  String password;
}
