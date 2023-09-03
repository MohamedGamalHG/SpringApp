package com.example.runapp.Service;

import com.example.runapp.models.Club;

import java.util.List;

public interface BaseService {
    List<?> findAll();

    Club save(Club club);

    Club findById(long id);
}
