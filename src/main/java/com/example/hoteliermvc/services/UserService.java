package com.example.hoteliermvc.services;

import com.example.hoteliermvc.dtos.UserDtos.UserRegisterDto;
import com.example.hoteliermvc.models.UserEntity;

public interface UserService {
    public boolean confirmEmail(String email, String token);
    void registerUser(UserRegisterDto userRegisterDto);
    UserEntity findByEmail(String email);
    UserEntity findByUserId(Long id);
}
