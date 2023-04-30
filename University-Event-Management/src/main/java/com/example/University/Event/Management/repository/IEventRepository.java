package com.example.University.Event.Management.repository;

import com.example.University.Event.Management.model.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepository extends CrudRepository<Event,Long> {

    // custom Query

    @Modifying
    @Query(value = "update Event set Location_Of_Event =:locationOfEvent where Event_Id=:id",nativeQuery = true)
    void updateBasedOnId(Long id, String locationOfEvent);

    @Modifying
    @Query(value = "delete from event where event_name =:eventName",nativeQuery = true)
    void deleteByEventName(String eventName);


    //custom finder
    public List<Event> findByDate(LocalDate date);

}
