package com.example.demo3.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrors {
    private String message;
    private String cause;
}
