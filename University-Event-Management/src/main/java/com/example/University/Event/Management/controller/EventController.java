package com.example.University.Event.Management.controller;

import com.example.University.Event.Management.model.Event;
import com.example.University.Event.Management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/Event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping(value = "/add")
    public String addEvent(@Valid @RequestBody List<Event> event){
        return eventService.addEVentUsingCRUD_Repo(event);
    }

    @GetMapping(value = "/getAll")
    public Iterable<Event> getAll(){
        return eventService.getAllEvent();
    }

    @PutMapping(value = "/update/id/{id}/location/{LOCATION_OF_EVENT}")
    public void update(@PathVariable Long id,@PathVariable String LOCATION_OF_EVENT){
        eventService.updateAll(id,LOCATION_OF_EVENT);
    }

    @DeleteMapping(value = "delete/{EventName}")
    public void deleteBasedOnEventName(@PathVariable String EventName){
        eventService.deleteBasedOnEventName(EventName);
    }

    @GetMapping(value = "GetByDate/{date}")
    public List<Event> getById(@PathVariable String date){
        return eventService.getByDate(date);
    }
}
