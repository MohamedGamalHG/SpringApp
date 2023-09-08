package com.example.runapp.repository;

import com.example.runapp.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
    UserEntity findByName(String name);
    UserEntity findByEmail(String email);
}
