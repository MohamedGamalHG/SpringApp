package com.example.runapp.repository;

import com.example.runapp.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepo extends JpaRepository<Club,Long> {

    Optional<Club> findByTitle(String url);
}
