package com.example.Events.Controller;

import com.example.Events.Model.Accounts;
import com.example.Events.Model.Event;
import com.example.Events.Repository.AccountsRepository;
import com.example.Events.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {


    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    //Add New Product

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Event> createNewEvent(@RequestBody Event event) {
        System.out.println("Requst Comming........");
        Event createdEvent = eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @GetMapping
    @CrossOrigin
    public List<Event> getAllEvents() {

        return eventRepository.findAll();
    }

    @GetMapping("/{userID}")
    @CrossOrigin
    public List<Event> getAllEventsByUser_id(@PathVariable Long userID)
    {
       return eventRepository.findAllByUserID(userID);
    }
    @Transactional
    @GetMapping("/join/{id}")
    @CrossOrigin
    public String joinEvent(@PathVariable Long id)
    {
        System.out.println("Comming!!!!");
        Event event = eventRepository.findById(id).get();
       if(event.getAttendees()<event.getMaxAttendee())
       {
           System.out.println("Comming!!!!");

           Integer attendees=event.getAttendees();
           attendees++;
           System.out.println(attendees);
           eventRepository.updateEvent(event.getTitle(), event.getDescription(), event.getAddress(),
                   event.getDate(), event.getTime(), event.getMaxAttendee(), attendees, event.getUserID(), id);
           return "Your Seat has been reserved";
       }
       else {
           return "Event Hall Already Full";
       }
    }
}


