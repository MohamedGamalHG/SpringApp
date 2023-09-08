package com.example.runapp.Service.interfaces;

import com.example.runapp.dto.RegistrationDto;
import com.example.runapp.dto.UserDTo;
import com.example.runapp.models.UserEntity;

import java.util.List;

public interface UserServiceInterface {
//    List<?> findAll();

//    UserEntity save(UserDTo user);

      void save(RegistrationDto registrationDto);
//    Club findById(long id);
//
//    void delete(long id);
//
//    List<?> searchClubs(String query);
}
