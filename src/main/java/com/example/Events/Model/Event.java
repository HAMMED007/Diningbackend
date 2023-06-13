package com.example.Events.Model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "max_attendee")
    private Integer maxAttendee;

    @Column(name = "attendees")
    private Integer attendees;

    @Column(name = "user_id")
    private Long userID;

    public Event()
    {}

    public Event(Long id, String title, String description, String address, String date, String time, Integer maxAttendee, Integer attendees, Long userID) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.date = date;
        this.time = time;
        this.maxAttendee = maxAttendee;
        this.attendees = attendees;
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Integer getMaxAttendee() {
        return maxAttendee;
    }

    public Integer getAttendees() {
        return attendees;
    }

    public Long getUserID() {
        return userID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMaxAttendee(Integer maxAttendee) {
        this.maxAttendee = maxAttendee;
    }

    public void setAttendees(Integer attendees) {
        this.attendees = attendees;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
