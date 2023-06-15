package kea.dat22v2.mdd.eksamen3sem.app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EventAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private LocalDateTime register;

    @UpdateTimestamp
    private LocalDateTime updated;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Event event;


    @ManyToOne(cascade = CascadeType.DETACH)
    private Attendee attendee;


    public void setEvent(Event event) {
        this.event = event;
        event.addEventAttendee(this);
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
        attendee.addEventAttendee(this);
    }
}
