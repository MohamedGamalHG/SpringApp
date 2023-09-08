package com.example.runapp.Service.interfaces;

import com.example.runapp.models.Club;

import java.util.List;

public interface ClubServiceInterface {
    List<?> findAll();

    Club save(Club club);

    Club findById(long id);

    void delete(long id);

    List<?> searchClubs(String query);
}
