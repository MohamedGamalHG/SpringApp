package com.example.runapp.Service;

import com.example.runapp.Service.interfaces.EventServiceInterface;
import com.example.runapp.dto.EventDto;
import com.example.runapp.mapper.EventMapper;
import com.example.runapp.models.Club;
import com.example.runapp.models.Event;
import com.example.runapp.repository.ClubRepo;
import com.example.runapp.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService implements EventServiceInterface {

    private EventRepo eventRepo;
    private ClubRepo clubRepo;
    @Autowired
    public EventService(EventRepo eventRepo,ClubRepo clubRepo){
        this.clubRepo = clubRepo;
        this.eventRepo = eventRepo;
    }
    @Override
    public List<Event> findAll() {
        List<Event> events = eventRepo.findAll();
        return events;
    }



    @Override
    public void save(Long clubId,EventDto event) {
        Club club = clubRepo.findById(clubId).get();
        Event event1 = EventMapper.mapToEvent(event);
        event1.setClub(club);
        eventRepo.save(event1);
    }

    @Override
    public EventDto findById(long id) {
        Event event = eventRepo.findById(id).get();
        return EventMapper.mapToEventDto(event);
    }

    @Override
    public void delete(long id) {
        eventRepo.deleteById(id);
    }

}
