package com.example.runapp.mapper;

import com.example.runapp.dto.EventDto;
import com.example.runapp.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto event) {
        Event event1= new Event();
        event1.setId(event.getId());
        event1.setName(event.getName());
        event1.setType(event.getType());
        event1.setPhotoUrl(event.getPhotoUrl());
        event1.setStartTime(event.getStartTime());
        event1.setEndTime(event.getEndTime());
        return event1;
    }
    public static EventDto mapToEventDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setType(event.getType());
        eventDto.setPhotoUrl(event.getPhotoUrl());
        eventDto.setStartTime(event.getStartTime());
        eventDto.setEndTime(event.getEndTime());
        return eventDto;
    }
}
