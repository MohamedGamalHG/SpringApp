package com.example.runapp.mapper;

import com.example.runapp.dto.EventDto;
import com.example.runapp.dto.UserDTo;
import com.example.runapp.models.Event;
import com.example.runapp.models.UserEntity;

public class UserMapper {
    public static UserEntity mapToUser(UserDTo userDto) {
        UserEntity user= new UserEntity();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
    public static UserDTo mapToUserDto(UserEntity user) {
        UserDTo userDTo = new UserDTo();
        userDTo.setId(user.getId());
        userDTo.setName(user.getName());
        userDTo.setEmail(user.getEmail());
        userDTo.setPassword(user.getPassword());
        return userDTo;
    }
}
