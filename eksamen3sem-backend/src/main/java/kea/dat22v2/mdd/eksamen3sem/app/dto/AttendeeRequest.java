package kea.dat22v2.mdd.eksamen3sem.app.dto;

import kea.dat22v2.mdd.eksamen3sem.app.entity.Attendee;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendeeRequest {

    private String username;
    private String email;
    private String phoneNumber;



    public static Attendee getAttendeeEntity(AttendeeRequest request) {
        return Attendee.builder()
            .username(request.getUsername())
            .phoneNumber(request.getPhoneNumber())
            .email(request.getEmail())
            .build();
    }

}
