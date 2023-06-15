package kea.dat22v2.mdd.eksamen3sem.app.api;


import kea.dat22v2.mdd.eksamen3sem.app.dto.AttendeeRequest;
import kea.dat22v2.mdd.eksamen3sem.app.dto.AttendeeResponse;
import kea.dat22v2.mdd.eksamen3sem.app.service.AttendeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendees")
@CrossOrigin
public class AttendeeController {

    AttendeeService service;

    public AttendeeController(AttendeeService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<AttendeeResponse>> findAllAttendees() {
        return ResponseEntity.ok().body(service.findAllAttendees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendeeResponse> findAttendee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.findAttendee(id));
    }

    @PostMapping
    public ResponseEntity<AttendeeResponse> addAttendee(@RequestBody AttendeeRequest request) {
        return ResponseEntity.ok().body(service.addAttendee(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendeeResponse> updateAttendee(@PathVariable("id") Integer id, @RequestBody AttendeeRequest request) {
        return ResponseEntity.ok().body(service.updateAttendee(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AttendeeResponse> deleteAttendee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.deleteAttendee(id));
    }
}