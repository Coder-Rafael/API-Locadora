package com.apiLocadora.APILocadora.DTO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginTokenDTO {
    private String token;
}
