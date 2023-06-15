package kea.dat22v2.mdd.eksamen3sem.app.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private String description;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
    private List<EventAttendee> eventAttendees;


    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;


    public void addEventAttendee(EventAttendee eventAttendee) {
        if (eventAttendees == null) {
            eventAttendees = new ArrayList<>();
        }
        eventAttendees.add(eventAttendee);
    }
}
