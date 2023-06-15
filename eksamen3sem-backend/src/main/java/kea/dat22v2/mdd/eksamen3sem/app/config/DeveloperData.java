package kea.dat22v2.mdd.eksamen3sem.app.config;

import kea.dat22v2.mdd.eksamen3sem.app.entity.Attendee;
import kea.dat22v2.mdd.eksamen3sem.app.entity.Event;
import kea.dat22v2.mdd.eksamen3sem.app.repository.AttendeeRepository;
import kea.dat22v2.mdd.eksamen3sem.app.repository.EventRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;


@Controller
public class DeveloperData implements ApplicationRunner {

    EventRepository eventRepository;

    AttendeeRepository attendeeRepository;

    public DeveloperData(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Event event1 = Event
            .builder()
            .name("Eksamen")
            .description("Meget vigtig for Mark")
            .capacity(3)
            .date(LocalDateTime.of(2023,6,20,10,10))
            .build();
        Event event2 = Event
            .builder()
            .name("Sommerferie")
            .description("Meget vigtig")
            .capacity(21)
            .date(LocalDateTime.of(2023,6,22,0,0))
            .build();

        eventRepository.save(event1);
        eventRepository.save(event2);


        Attendee attendee1 = Attendee.builder()
            .username("Mardyrden")
            .email("mark771e@stud.kea.dk")
            .phoneNumber("71201230")
            .build();

        Attendee attendee2 = Attendee.builder()
            .username("KristianWede")
            .email("glemthansmail@stud.kea.dk")
            .phoneNumber("12345678")
            .build();


        attendeeRepository.save(attendee1);
        attendeeRepository.save(attendee2);




    }




}
