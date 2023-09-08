package com.example.runapp.controllers;


import com.example.runapp.Service.ClubService;
import com.example.runapp.Service.EventService;
import com.example.runapp.dto.EventDto;
import com.example.runapp.models.Event;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private  EventService eventService;
    private ClubService clubService;

    @Autowired
    public EventController(EventService eventService,ClubService clubService){
        this.eventService = eventService;
        this.clubService = clubService;
    }
    @GetMapping(value = {"","/"})
    public String listEvent(Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events",events);
        model.addAttribute("name","mohamed gamal");
        return "events/event-list";
    }
    @GetMapping("/create/{clubId}")
    public String createFormEvent(@PathVariable("clubId") Long clubId,Model model) {
        Event event = new Event();
        model.addAttribute("event",event);
        model.addAttribute("club",clubId);
        return "events/event-create";
    }
/*    @GetMapping("/search")
    public String searchevent(@RequestParam(value = "query") String query,Model model)
    {
        List<EventDto> EventDtos = eventService.searchevents(query);
        model.addAttribute("events",EventDtos);
        return "events/event-list";
    }*/
    @PostMapping("/save/{clubId}")
    public String saveEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDto event, BindingResult bindingResult){
        //if(bindingResult.hasErrors())
          //  return "events/event-create";
        eventService.save(clubId,event);
        return "redirect:/clubs/item/"+clubId;
    }
    @GetMapping("/update/{id}")
    public String updateEvent(@PathVariable long id,Model model){
        EventDto event = eventService.findById(id);
        if(event != null) {
            model.addAttribute("event",event);
            model.addAttribute("id",id);
            return "events/event-update";
        }
        else
            return "there is a problem HMMMMMMM !!!";
    }
    @PostMapping("/update/{id}")
    public String updateEvent(@Valid @ModelAttribute("event") EventDto event,@PathVariable Long id,Model model,BindingResult bindingResult){
        //event.setId(id);
        if(bindingResult.hasErrors())
            return "events/event-update";
        EventDto events = eventService.findById(id);
        event.setId(events.getId());
        event.setClub(events.getClub());
        eventService.save(id,event);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable long id)
    {
        eventService.delete(id);
        return "redirect:/events";
    }
    @GetMapping("/item/{id}")
    public String itemEvent(@PathVariable long id,Model model)
    {
        EventDto event = eventService.findById(id);
        model.addAttribute("event",event);
        return "events/event-item";
    }
}
