package com.example.runapp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
//@Builder
public class ClubDto {

    private long id;
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private List<EventDto> EventDtoList;
}
