package com.apiLocadora.APILocadora.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiLocadora.APILocadora.DTO.LoginDTO;
import com.apiLocadora.APILocadora.DTO.LoginTokenDTO;
import com.apiLocadora.APILocadora.DTO.UserRegDTO;
import com.apiLocadora.APILocadora.Enum.UserRole;
import com.apiLocadora.APILocadora.Models.UserModel;
import com.apiLocadora.APILocadora.Security.TokenService;
import com.apiLocadora.APILocadora.Services.AuthorizationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthorizationService service;

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        System.out.println("Chegou na desgraça do endpoint");
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel)auth.getPrincipal());

        return ResponseEntity.ok(new LoginTokenDTO(token));  
    }

     //localhost:8080/auth/register
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegDTO userDTOreg){
        if(this.service.loadUserByUsername(userDTOreg.login()) != null)
            return ResponseEntity.badRequest().build();

            String encriptedPassowrd = new BCryptPasswordEncoder().encode(userDTOreg.password());
            UserRegDTO userDto = new UserRegDTO(userDTOreg.login(), encriptedPassowrd, UserRole.USER);
            service.save(userDto);
        return ResponseEntity.ok().build();  
    }
}
