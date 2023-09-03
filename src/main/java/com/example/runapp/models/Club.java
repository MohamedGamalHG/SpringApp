package com.example.runapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Club Title not be empty")
    private String title;
    @NotEmpty(message = "Club Photo not be empty")

    private String photoUrl;
    @NotEmpty(message = "Club Content not be empty")

    private String content;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

}
