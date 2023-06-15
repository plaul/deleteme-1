package kea.dat22v2.mdd.eksamen3sem.app.service;


import kea.dat22v2.mdd.eksamen3sem.app.dto.ReserveRequest;
import kea.dat22v2.mdd.eksamen3sem.app.dto.ReserveResponse;
import kea.dat22v2.mdd.eksamen3sem.app.entity.Attendee;
import kea.dat22v2.mdd.eksamen3sem.app.entity.Event;
import kea.dat22v2.mdd.eksamen3sem.app.entity.EventAttendee;
import kea.dat22v2.mdd.eksamen3sem.app.exception.AttendeeNotFoundException;
import kea.dat22v2.mdd.eksamen3sem.app.exception.EventAtCapacityException;
import kea.dat22v2.mdd.eksamen3sem.app.exception.EventNotFoundException;
import kea.dat22v2.mdd.eksamen3sem.app.exception.NotYetImplementedException;
import kea.dat22v2.mdd.eksamen3sem.app.repository.AttendeeRepository;
import kea.dat22v2.mdd.eksamen3sem.app.repository.EventRepository;
import kea.dat22v2.mdd.eksamen3sem.app.repository.ReserveRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReserveService {
    ReserveRepository reserveRepository;
    AttendeeRepository attendeeRepository;

    EventRepository eventRepository;


    public ReserveService(ReserveRepository reserveRepository, AttendeeRepository attendeeRepository, EventRepository eventRepository) {
        this.reserveRepository = reserveRepository;
        this.attendeeRepository = attendeeRepository;
        this.eventRepository = eventRepository;
    }

    public ReserveResponse findReserve(Integer id) {
        throw new NotYetImplementedException("TODO");
    }

    public ReserveResponse addReserve(ReserveRequest request) {
        Event event = eventRepository.findById(request.getEvent_id()).orElseThrow(() -> new EventNotFoundException("Event not found"));
        Integer count = reserveRepository.countAllByEvent_Id(request.getEvent_id());
        if (event.getCapacity() <= count) {
            throw new EventAtCapacityException("Event is already full");
        }
        Attendee attendee = attendeeRepository.findById(request.getAttendee_id()).orElseThrow(() ->  new AttendeeNotFoundException("Attendee not found"));




        EventAttendee eventAttendee = new EventAttendee();

        eventAttendee.setEvent(event);
        eventAttendee.setAttendee(attendee);

        return new ReserveResponse(reserveRepository.save(eventAttendee));
    }

    public Boolean deleteReserve(Integer id) {
        reserveRepository.deleteById(id);
        return true;
    }


    public List<ReserveResponse> findAllReserves() {
        return reserveRepository.findAll().stream().map(ReserveResponse::new).toList();
    }
}
