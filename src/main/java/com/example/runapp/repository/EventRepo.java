package com.example.runapp.repository;

import com.example.runapp.dto.EventDto;
import com.example.runapp.models.Club;
import com.example.runapp.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepo extends JpaRepository<Event,Long> {

    Optional<Event> findByName(String name);

//    @Query("select c from Club c where c.title like concat('%',:query,'%') ")
//    List<Club> searchClubs(String query);
}
