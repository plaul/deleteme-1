package kea.dat22v2.mdd.eksamen3sem.app.entity;

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
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String username;
    private String email;
    private String phoneNumber;


    @OneToMany(mappedBy = "attendee", fetch = FetchType.LAZY)
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
