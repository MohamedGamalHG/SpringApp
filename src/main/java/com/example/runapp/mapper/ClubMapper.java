package com.example.runapp.mapper;

import com.example.runapp.dto.ClubDto;
import com.example.runapp.models.Club;

import java.util.stream.Collectors;

public class ClubMapper {

    public static ClubDto mapToClubDto(Club club)
    {
    /*    ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .created_at(club.getCreated_at())
                .updated_at(club.getUpdated_at())
                .build();*/

        ClubDto clubDto = new ClubDto();
        clubDto.setId(club.getId());
        clubDto.setTitle(club.getTitle());
        clubDto.setContent(club.getContent());
        clubDto.setPhotoUrl(club.getPhotoUrl());
        clubDto.setCreated_at(club.getCreated_at());
        clubDto.setUpdated_at(club.getUpdated_at());
        clubDto.setEventDtoList(club.getEvents().stream().map(event -> EventMapper.mapToEventDto(event)).collect(Collectors.toList()));
        return clubDto;
    }
}
