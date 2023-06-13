package com.example.Events.Repository;

import com.example.Events.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByUserID(@Param("userID") Long userID);

    @Modifying
    @Query("UPDATE Event e SET e.title = :title, e.description = :description, e.address = :address, e.date = :date, e.time = :time, e.maxAttendee = :maxAttendee, e.attendees = :attendees, e.userID = :userID WHERE e.id = :id")
    int updateEvent(
            @Param("title") String title,
            @Param("description") String description,
            @Param("address") String address,
            @Param("date") String date,
            @Param("time") String time,
            @Param("maxAttendee") Integer maxAttendee,
            @Param("attendees") Integer attendees,
            @Param("userID") Long userID,
            @Param("id") Long id
    );

}
