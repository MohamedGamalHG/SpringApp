package com.example.runapp.controllers;

import com.example.runapp.Service.ClubService;
import com.example.runapp.dto.ClubDto;
import com.example.runapp.models.Club;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping(value = {"","/"})
    public String listClub(Model model) {
        List<ClubDto> clubDtos = clubService.findAll();
        model.addAttribute("clubs",clubDtos);
        model.addAttribute("name","mohamed gamal");
        return "club-list";
    }
    @GetMapping("/create")
    public String createFormClub(Model model) {
        Club club = new Club();
        model.addAttribute("club",club);
        return "club-create";
    }
    @PostMapping("/save")
    public String saveClub(@Valid @ModelAttribute("club") Club club, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "club-create";
        clubService.save(club);
        return "redirect:/clubs";
    }
    @GetMapping("/update/{id}")
    public String updateClub(@PathVariable long id,Model model){
        Club club = clubService.findById(id);
        if(club != null) {
            model.addAttribute("club",club);
            return "club-update";
        }
        else
            return "there is a problem HMMMMMMM !!!";
    }
    @PostMapping("/update/{id}")
    public String updateClub(@Valid @ModelAttribute("club") Club club,BindingResult bindingResult){
        //club.setId(id);
        if(bindingResult.hasErrors())
            return "club-update";
        Club clubs = clubService.findById(club.getId());
        clubService.save(clubs);
        return "redirect:/clubs";
    }
}
