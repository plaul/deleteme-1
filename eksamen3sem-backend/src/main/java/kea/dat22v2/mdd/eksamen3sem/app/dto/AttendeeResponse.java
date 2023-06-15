package kea.dat22v2.mdd.eksamen3sem.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kea.dat22v2.mdd.eksamen3sem.app.entity.Attendee;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttendeeResponse {


    private int id;
    private String username;
    private String email;
    private String phoneNumber;



    public AttendeeResponse(Attendee entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.phoneNumber = entity.getPhoneNumber();

    }

}

