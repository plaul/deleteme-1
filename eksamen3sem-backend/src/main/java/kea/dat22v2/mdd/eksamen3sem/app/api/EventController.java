package kea.dat22v2.mdd.eksamen3sem.app.api;

import kea.dat22v2.mdd.eksamen3sem.app.dto.EventRequest;
import kea.dat22v2.mdd.eksamen3sem.app.dto.EventResponse;
import kea.dat22v2.mdd.eksamen3sem.app.entity.EventStatus;
import kea.dat22v2.mdd.eksamen3sem.app.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {

    EventService service;

    public EventController(EventService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<EventResponse>> findAllEvents() {
        return ResponseEntity.ok().body(service.findAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> findEvent(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.findEvent(id, false));
    }

    @GetMapping("/{name}")
    public ResponseEntity<EventResponse> findEventByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(service.findEventByName(name, false));
    }

    @GetMapping("/{id}/{includeAll}")
    public ResponseEntity<EventResponse> findEventToEdit(@PathVariable("id") Integer id, @PathVariable("includeAll") Boolean includeAll) {
        return ResponseEntity.ok().body(service.findEvent(id, includeAll));
    }

    @PostMapping
    public ResponseEntity<EventResponse> addEvent(@RequestBody EventRequest request) {
        return ResponseEntity.ok().body(service.addEvent(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable("id") Integer id, @RequestBody EventRequest request) {
        return ResponseEntity.ok().body(service.updateEvent(id,request));
    }

    @PatchMapping("/{id}/{eventStatus}")
    public ResponseEntity<EventResponse> updateEventStatus(@PathVariable("id") Integer id, @PathVariable("eventStatus") EventStatus eventStatus) {
        return ResponseEntity.ok().body(service.updateEventStatus(id,eventStatus));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEvent(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.deleteEvent(id));
    }
}