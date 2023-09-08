package com.example.runapp.Service;

import com.example.runapp.Service.interfaces.UserServiceInterface;
import com.example.runapp.dto.RegistrationDto;
import com.example.runapp.dto.UserDTo;
import com.example.runapp.mapper.UserMapper;
import com.example.runapp.models.Role;
import com.example.runapp.models.UserEntity;
import com.example.runapp.repository.RoleRepo;
import com.example.runapp.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements UserServiceInterface {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    @Autowired
    public UserService(UserRepo userRepo,RoleRepo roleRepo)
    {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public void save(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role roles = roleRepo.findByName("USER");
        user.setRoles(Arrays.asList(roles));
        userRepo.save(user);
    }
   /* @Override
    public UserEntity save(UserDTo user) {
       return userRepo.save(UserMapper.mapToUser(user));
    }*/
}
