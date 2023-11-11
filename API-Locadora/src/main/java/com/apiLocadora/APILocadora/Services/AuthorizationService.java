package com.apiLocadora.APILocadora.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apiLocadora.APILocadora.DTO.UserRegDTO;
import com.apiLocadora.APILocadora.Models.UserModel;
import com.apiLocadora.APILocadora.Repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService{

    @Autowired
    UserRepository repository;

    public void save(UserRegDTO userRegDTO){
        // Converter UserDTO para UserModel
        UserModel userModel = new UserModel();
        userModel.setLogin(userRegDTO.login());
        userModel.setPassword(userRegDTO.password());
        userModel.setRole(userRegDTO.role());
        userModel = repository.save(userModel);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
    
}
