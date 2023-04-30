package com.example.University.Event.Management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Event_Id")
    private Long eventId;

    @NotBlank(message = "Event name cannot be blank")
    @Column(name="EventName")
    private String eventName;

    @NotBlank(message = "Location of event cannot be blank")
    @Column(name="LocationOfEvent")
    private String locationOfEvent;

    @NotNull(message = "Date cannot be null")
    private LocalDate date;

    @NotNull(message = "Start time cannot be null")
    private LocalTime startTime;

    @NotNull(message = "End time cannot be null")
    private LocalTime endTime;



}
