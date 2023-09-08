package com.example.runapp.Service.interfaces;

import com.example.runapp.dto.EventDto;
import com.example.runapp.models.Club;
import com.example.runapp.models.Event;

import java.util.List;

public interface EventServiceInterface {
    List<?> findAll();

    void save(Long clubId, EventDto event);

    EventDto findById(long id);

    void delete(long id);


}
