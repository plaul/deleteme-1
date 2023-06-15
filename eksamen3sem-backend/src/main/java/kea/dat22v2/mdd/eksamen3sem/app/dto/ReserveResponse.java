package kea.dat22v2.mdd.eksamen3sem.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.dat22v2.mdd.eksamen3sem.app.entity.EventAttendee;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReserveResponse {

    Integer id;
    String event_name;
    String username;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime reservationDate;




    public ReserveResponse(EventAttendee entity) {
        this.id = entity.getId();
        this.event_name = entity.getEvent().getName();
        this.username = entity.getAttendee().getUsername();
        this.reservationDate = entity.getRegister();
    }

}

