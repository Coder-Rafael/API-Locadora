package com.apiLocadora.APILocadora.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.apiLocadora.APILocadora.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
     UserDetails findByLogin(String login);
     UserModel save(UserModel userModel);
}
