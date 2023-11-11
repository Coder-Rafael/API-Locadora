package com.apiLocadora.APILocadora.DTO;

import com.apiLocadora.APILocadora.Enum.UserRole;


public record UserRegDTO(String login, String password, UserRole role){}