package kea.dat22v2.mdd.eksamen3sem.app.dto;

import kea.dat22v2.mdd.eksamen3sem.app.entity.EventAttendee;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ReserveRequest {

    Integer event_id;
    Integer attendee_id;


}