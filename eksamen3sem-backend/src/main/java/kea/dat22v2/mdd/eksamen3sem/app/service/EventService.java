package kea.dat22v2.mdd.eksamen3sem.app.service;


import kea.dat22v2.mdd.eksamen3sem.app.dto.EventRequest;
import kea.dat22v2.mdd.eksamen3sem.app.dto.EventResponse;
import kea.dat22v2.mdd.eksamen3sem.app.entity.Event;
import kea.dat22v2.mdd.eksamen3sem.app.entity.EventAttendee;
import kea.dat22v2.mdd.eksamen3sem.app.entity.EventStatus;
import kea.dat22v2.mdd.eksamen3sem.app.exception.EventNotFoundException;
import kea.dat22v2.mdd.eksamen3sem.app.repository.EventRepository;
import kea.dat22v2.mdd.eksamen3sem.app.repository.ReserveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    EventRepository eventRepository;

    ReserveRepository reserveRepository;

    public EventService(EventRepository eventRepository, ReserveRepository reserveRepository) {
        this.eventRepository = eventRepository;
        this.reserveRepository = reserveRepository;
    }

    public List<EventResponse> findAllEvents() {
        return eventRepository.findAll().stream().map(event -> {
            EventResponse eventResponse = new EventResponse(event);
            eventResponse.setRemainingCapacity(event.getCapacity() - reserveRepository.countAllByEvent_Id(event.getId()));
            return eventResponse;
        }).toList();
    }

    public EventResponse findEvent(Integer id, Boolean includeAll) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Could not find event by : " + id));
        return new EventResponse(event, includeAll);
    }

    public EventResponse addEvent(EventRequest request) {
        // add checks?
        Event event = EventRequest.getEventEntity(request);
        event.setEventStatus(EventStatus.OPEN);
        return new EventResponse(eventRepository.save(event));
    }

    public EventResponse updateEvent(Integer id, EventRequest request) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));

        Optional.ofNullable(request.getCapacity()).ifPresent(event::setCapacity);
        Optional.ofNullable(request.getName()).ifPresent(event::setName);
        Optional.ofNullable(request.getDescription()).ifPresent(event::setDescription);
        Optional.ofNullable(request.getDate()).ifPresent(event::setDate);

        return new EventResponse(eventRepository.save(event));
    }

    public Boolean deleteEvent(Integer id) {
        eventRepository.deleteById(id);
        return true;
    }




    public EventResponse findEventByName(String name, boolean includeAll) {
        Event event = eventRepository.findByName(name).orElseThrow(() -> new EventNotFoundException("Could not find event by : " + name));
        return new EventResponse(event, includeAll);
    }

    public EventResponse updateEventStatus(Integer id, EventStatus eventStatus) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Could not find event by : " + id));
        event.setEventStatus(eventStatus);

        return new EventResponse(eventRepository.save(event));
    }
}
