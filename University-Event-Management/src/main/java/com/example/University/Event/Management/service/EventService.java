package com.example.University.Event.Management.service;

import com.example.University.Event.Management.model.Event;
import com.example.University.Event.Management.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    IEventRepository eventRepo;


    public String addEVentUsingCRUD_Repo(List<Event> event) {
        Iterable<Event> list=eventRepo.saveAll(event); // CRUDRepository method
        if(list!=null){
            return "Added ";
        }else{
            return "Not Added !!!!!";
        }
    }


    public Iterable<Event> getAllEvent() {
       return eventRepo.findAll();
    }

    @Transactional
    public void updateAll(Long id, String locationOfEvent) {
        eventRepo.updateBasedOnId(id,locationOfEvent);
    }

    @Transactional
    public void deleteBasedOnEventName(String eventName) {
        eventRepo.deleteByEventName(eventName);
    }

    public List<Event> getByDate(String date) {
        LocalDate myDate = LocalDate.parse(date);
        return eventRepo.findByDate(myDate);
    }
}
