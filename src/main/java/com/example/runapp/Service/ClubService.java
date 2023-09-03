package com.example.runapp.Service;

import com.example.runapp.dto.ClubDto;
import com.example.runapp.models.Club;
import com.example.runapp.repository.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService implements BaseService{

    @Autowired
    private ClubRepo clubRepo;
    @Override
    public List<ClubDto> findAll() {
        List<Club> clubs = clubRepo.findAll();
        return clubs.stream().map(c -> mapToClubDto(c)).collect(Collectors.toList());
    }
    @Override
    public Club save(Club club){
        return  clubRepo.save(club);

    }
    @Override
    public Club findById(long id){
        return  clubRepo.findById(id).get();
    }

    private ClubDto mapToClubDto(Club club)
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
        return clubDto;
    }
}
