package kea.dat22v2.mdd.eksamen3sem.app.service;


import kea.dat22v2.mdd.eksamen3sem.app.dto.AttendeeRequest;
import kea.dat22v2.mdd.eksamen3sem.app.dto.AttendeeResponse;
import kea.dat22v2.mdd.eksamen3sem.app.exception.NotYetImplementedException;
import kea.dat22v2.mdd.eksamen3sem.app.repository.AttendeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {
    AttendeeRepository repository;



    public AttendeeService(AttendeeRepository repository) {
        this.repository = repository;
    }

    public List<AttendeeResponse> findAllAttendees() {
        throw new NotYetImplementedException("TODO");
    }

    public AttendeeResponse findAttendee(Integer id) {
        throw new NotYetImplementedException("TODO");
    }

    public AttendeeResponse addAttendee(AttendeeRequest request) {
        throw new NotYetImplementedException("TODO");
    }

    public AttendeeResponse updateAttendee(Integer id, AttendeeRequest request) {
        throw new NotYetImplementedException("TODO");
    }

    public AttendeeResponse deleteAttendee(Integer id) {
        throw new NotYetImplementedException("TODO");
    }


}
